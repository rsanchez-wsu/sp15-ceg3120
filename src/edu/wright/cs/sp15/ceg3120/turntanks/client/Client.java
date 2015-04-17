/*
 *  Copyright (C) <2015>  
 *  Josh Crank - crank.5@wright.edu
 *  // Aditional People
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

package edu.wright.cs.sp15.ceg3120.turntanks.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import edu.wright.cs.sp15.ceg3120.turntanks.Configuration;
import edu.wright.cs.sp15.ceg3120.turntanks.Player;

// (JTC) This will be the client object which maintains the socket and communicates to the views and models.

public class Client {
	
	//Create Client Variables
	private Socket s;
	private DataInputStream din = null;
	private DataOutputStream dout = null;
	private InputStream is = null;
	private OutputStream os = null;
	
	private ClientView cv = null;
	private HashMap<String,Player> players = new HashMap<>();
	
	// Incoming Message
	private String smsg;
	
	public Client() {
		try {
			cv = new ClientView();
			
			// (JTC) Opens a socket on to the configured game server
			s = new Socket(Configuration.getServerAddress(), Configuration.getServerPort());
			
			// (JTC) Establish I/O Stream
			is = s.getInputStream();
			din = new DataInputStream(is);
			os = s.getOutputStream();
			dout = new DataOutputStream(os);
			
			//(kwood) After socket is opened, send connect message with player name.
			dout.writeUTF("CONNECT " + cv.getLocalName());
			
			
			// This will continue while the socket is open
			while(true)
			{				
				smsg = din.readUTF();
				
				String[] msg = smsg.split("$");
				String cmd = msg[0].trim();
				String payload = msg[1].trim();
				
				//COMMAND PROCESSOR 
				switch(cmd) { 
				case "WELCOME":
					// Nothing to do
					break;
				case "PLAYERS PRESENT":
					// Add players as listed by the server
					populatePlayers(payload);
					break;
				case "SORRY - GAME IN PROGRESS":
					// TODO: Pop-up dialog to inform user.  Close socket.  Maybe exit application.
					break;
				case "GAME STARTED":
					// TODO: Update GUI to reflect that game has started
					break;
				case "GAME ENDED":
					// TODO: Update GUI to reflect that game has ended
					break;
				case "MAP INFO":
					// TODO: Parse and pass info/messages to renderer
					break;
				case "GO":
					// TODO: Alert the user it is his/her turn and handle any user
					// interactions for the turn, including keeping the clock synced
					break;
				case "CHAT FROM":
					// TODO: Display the chat message
					break;
				case "ILLEGAL ACTION":
					// TODO: Alert the user and revert to state just prior to last command
					break;
				case "PLAYER MOVED":
					// TODO: Update the map view to show the tank in its new location
					break;
				case "PLAYER ATTACKING":
					// TODO: Update status area to reflect the player who is attacking
					break;
				case "ATTACK HIT":
					// TODO: Update affected player status and GUI
					break;
				case "ATTACK MISS":
					// TODO: There might be nothing to do here
					break;
				case "INVALID MESSAGE":
					System.out.println("Your command was unrecognized by the server. Please re-enter.");
					break;
				default:
					// DEFAULT CASE
					break;
				}				
				
				
			}
		} catch(Exception e) {
			System.out.println("Error in connection...");
			e.printStackTrace();
			try {
				s.close();
			} catch (IOException e1) {
				System.out.println("Failed to close socket properly.");
				e1.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("boxing")
	private void populatePlayers(String payload) {
		List<String> playerParts = Arrays.asList(payload.split(" "));
		for (int i = 0; i < playerParts.size(); i += 2) {
			if (!players.containsKey(playerParts.get(i))) {
				players.put(playerParts.get(i),
						new Player(
								Integer.valueOf(playerParts.get(i+1)),
								playerParts.get(i))
						);
			}
		}
		cv.setPlayers(Collections.unmodifiableMap(players));
	}

	public HashMap<String,Player> getPlayers()
	{
		return players;
	}

}
