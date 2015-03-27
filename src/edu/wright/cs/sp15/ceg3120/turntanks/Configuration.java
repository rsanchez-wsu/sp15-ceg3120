/*
 *  Copyright (C) 2015 - Roberto C. Sánchez <roberto.sanchez@wright.edu>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package edu.wright.cs.sp15.ceg3120.turntanks;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * This is a static class which parses the game configuration and makes the
 * various settings available through accessor methods.
 * 
 * @author Roberto C. Sánchez <roberto.sanchez@wright.edu>
 *
 */
public class Configuration {
	
	/**
	 * Enumeration of the available game modes.
	 */
	public enum Mode {
		SERVER, CLIENT, INVALID
	}
	
	/**
	 * Enumeration of the available game clock units.
	 */
	public enum ClockUnit {
		SECONDS, MINUTES, HOURS, INVALID
	}

	private static final String CONF_FILE = "turntanks.xml";

	private static boolean valid = false;
	
	private static Mode gameMode;
	private static List<InetAddress> listenAddresses;
	private static InetAddress serverAddress;
	private static int listenPort;
	private static int serverPort;
	private static int maxClients;
	private static ClockUnit turnClockUnit;
	private static int turnClockDuration;
	
	private static String dbUri;
	
	// Load the game configuration when the class is loaded
	static {
		listenAddresses = new ArrayList<>();
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setValidating(true);
			docFactory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			docBuilder.setErrorHandler(new ErrorHandler() {
				
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					throw exception;
				}
				
				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					throw exception;
				}
				
				@Override
				public void error(SAXParseException exception) throws SAXException {
					throw exception;
				}
			});
			parseConfig(docBuilder.parse(new File(CONF_FILE)));
			
			// We have reached the end of the configuration parsing activity
			// without an exception, so the configuration is valid
			valid = true;
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			// TODO: Implement exception-handling logic
			System.out.println("********** An error occurred during configuration parsing!");
			e.printStackTrace();
		}
	}

	private static void parseConfig(Document doc) throws XPathExpressionException, UnknownHostException, DOMException {
		XPath xpath = XPathFactory.newInstance().newXPath();
		
		String mode = xpath.evaluate("/turntanks/@mode", doc);
		
		if (mode.equalsIgnoreCase("server")) {
			gameMode = Mode.SERVER;
			
			// The first element is a <listen> element, and its children (if any) are <address> elements
			NodeList addresses = (NodeList) xpath.evaluate("/turntanks/listen/address", doc, XPathConstants.NODESET);
			if (addresses.getLength() > 0) {
				for (int i = 0; i < addresses.getLength(); i++) {
					Node a = addresses.item(i).getChildNodes().item(0);
					listenAddresses.add(InetAddress.getByName(a.getNodeValue()));
				}
			} else {
				listenAddresses.add(InetAddress.getLoopbackAddress());
			}
			
			// The next element is <port>
			listenPort = Integer.parseInt(xpath.evaluate("/turntanks/listen/port", doc));
			
			// The next element is <max-clients>
			maxClients = Integer.parseInt(xpath.evaluate("/turntanks/max-clients", doc));
			
			// The next element is <turn-clock>
			turnClockDuration = Integer.parseInt(xpath.evaluate("/turntanks/turn-clock", doc));
			switch (xpath.evaluate("/turntanks/turn-clock/@unit", doc)) {
			case "seconds":
				turnClockUnit = ClockUnit.SECONDS;
				break;
			case "minutes":
				turnClockUnit = ClockUnit.MINUTES;
				break;
			case "hours":
				turnClockUnit = ClockUnit.HOURS;
				break;
			default:
				// This should never happen because the XML document was validated against the DTD
				turnClockUnit = ClockUnit.INVALID;
			}
			
			// The next element is <db-uri>
			dbUri = xpath.evaluate("/turntanks/db-uri", doc);
			
		} else if (mode.equalsIgnoreCase("client")) {
			gameMode = Mode.CLIENT;
			
			// The only element is a <server> element
			// The first element nested within <server> is <address>
			serverAddress = InetAddress.getByName(xpath.evaluate("/turntanks/server/address", doc));
			
			// The next element nested within <server> is <port>
			serverPort = Integer.parseInt(xpath.evaluate("/turntanks/server/port", doc));
			
		} else {
			// This should never happen because the XML document was validated against the DTD
			throw new RuntimeException("Unknown application mode: " + mode);
		}
	}

	/**
	 * 
	 * @return Whether the configuration was completely parsed and found to be valid.
	 */
	public static boolean isValid() {
		return valid;
	}

	/**
	 * 
	 * @return The mode for this invocation of the application (i.e., client or server).
	 */
	public static Mode getGameMode() {
		return gameMode;
	}

	/**
	 * Returns a list of InetAddress objects to which the server socket should
	 * bind.  If the configuration is not valid or the application is not
	 * configured for server mode, this method returns null.  If no listen
	 * address is specified in the configuration, an empty list will be
	 * returned. 
	 * 
	 * @return The list of addresses to which the server socket should bind.
	 */
	public static List<InetAddress> getListenAddresses() {
		if (valid && gameMode == Mode.SERVER) {
			return listenAddresses;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns an InetAddress object representing the game server to which the
	 * client should connect.  If the configuration is not valid or the
	 * application is not configured in client mode, this method returns null.
	 * 
	 * @return The InetAddress object for the configured game server.
	 */
	public static InetAddress getServerAddress() {
		if (valid && gameMode == Mode.CLIENT) {
			return serverAddress;
		} else {
			return null;
		}
	}

	/**
	 * Returns the TCP port on which to listen for incoming connections.  If
	 * the configuration is not valid or the application is not configured in
	 * server mode, this method returns -1.
	 *  
	 * @return The TCP port on which to listen for incoming client connections.
	 */
	public static int getListenPort() {
		if (valid && gameMode == Mode.SERVER) {
			return listenPort;
		} else {
			return -1;
		}
	}

	/**
	 * Returns the TCP port on which to make the connection to the remote game
	 * server.  If the configuration is not valid or the application is
	 * not configured in client mode, this method returns -1.
	 * 
	 * @return The TCP port for making the connection to the remote server.
	 */
	public static int getServerPort() {
		if (valid && gameMode == Mode.CLIENT) {
			return serverPort;
		} else {
			return -1;
		}
	}

	/**
	 * Returns the maximum number of clients for which the game is configured.
	 * If the configuration is not valid or the application is not configured
	 * in server mode, this method returns -1.
	 * 
	 * @return The maximum number of clients that are permitted to connect to the game.
	 */
	public static int getMaxClients() {
		if (valid && gameMode == Mode.SERVER) {
			return maxClients;
		} else {
			return -1;
		}
	}

	/**
	 * Returns the unit for the game's turn clock.  If the configuration is not
	 * valid or the application is not configured in server mode, this method
	 * returns INVALID (a value of ClockUnit enumeration).
	 * 
	 * @return The unit for the game's turn clock.
	 */
	public static ClockUnit getTurnClockUnit() {
		if (valid && gameMode == Mode.SERVER) {
			return turnClockUnit;
		} else {
			return ClockUnit.INVALID;
		}
	}

	/**
	 * Returns the configured numeric duration of the game's turn clock.  If
	 * the configuration is not valid or the application is not configured in
	 * server mode, this method returns -1.
	 * 
	 * @return The numeric duration for the game's turn clock.
	 */
	public static int getTurnClockDuration() {
		if (valid && gameMode == Mode.SERVER) {
			return turnClockDuration;
		} else {
			return -1;
		}
	}

	/**
	 * Returns the URI to be used when making JDBC connections to the database.
	 * If the configuration is not valid or the application is not configured
	 * in server mode, this method returns null.
	 * 
	 * @return The JDBC URI to use for database connections.
	 */
	public static String getDbUri() {
		if (valid && gameMode == Mode.SERVER) {
			return dbUri;
		} else {
			return null;
		}
	}
	
}
