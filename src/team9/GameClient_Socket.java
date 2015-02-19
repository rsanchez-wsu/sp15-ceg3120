/*
 * Copyright (C) 2015 - Matthew Nelson corulik@gmail.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package team9;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



public class GameClient_Socket extends Socket {
	//ToDo: Find what port will be used on the client
	private static final int PORT = 1500;
	
	public GameClient_Socket(String host) throws UnknownHostException, IOException
	{
		super(host, PORT);
	}
	public GameClient_Socket(InetAddress address) throws UnknownHostException, IOException
	{
		super(address, PORT);
	}
	
	/*
	 * Sends the Game Protocol Player Connect message to the server the socket is connected to.
	 * Requires the name of the player to send to the game server.
	 * Returns True if command was successfully sent. Returns False if output connection failed.
	 */
	public boolean SendConnectMessage(String playerName)
	{
		try {
			
			PrintWriter outputWriter = new PrintWriter(this.getOutputStream());
			outputWriter.println("CONNECT ["+ playerName +"]");
			outputWriter.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/*
	 * Sends the Game Protocol Attack Action message to the server the socket is connected to.
	 * Requires the x and y coordinate as integers.
	 * Returns True if command was successfully sent. Returns False if output connection failed.
	 */
	//ToDo: Need coordinate format
	public boolean SendAttackMessage(int x, int y)
	{
		try {
			
			PrintWriter outputWriter = new PrintWriter(this.getOutputStream());
			outputWriter.println("ACTION ATTACK "+ x +", "+ y);
			outputWriter.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/*
	 * Sends the Game Protocol Move Action message to the server the socket is connected to.
	 * Requires the x and y coordinate as integers.
	 * Returns True if command was successfully sent. Returns False if output connection failed.
	 */
	//ToDo: Need coordinate format
	public boolean SendMoveMessage(int x, int y)
	{
		try {
			
			PrintWriter outputWriter = new PrintWriter(this.getOutputStream());
			outputWriter.println("ACTION MOVE "+ x +", "+ y);
			outputWriter.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/*
	 * Sends the Game Protocol Pass Action message to the server the socket is connected to.
	 * Returns True if command was successfully sent. Returns False if output connection failed.
	 */
	public boolean SendPassMessage()
	{
		try {
			
			PrintWriter outputWriter = new PrintWriter(this.getOutputStream());
			outputWriter.println("ACTION PASS");
			outputWriter.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/*
	 * Sends the Game Protocol Chat message to the server the socket is connected to.
	 * Requires a String to send to the server as a chat message.
	 * Returns True if command was successfully sent. Returns False if output connection failed.
	 */
	public boolean SendChatMessage(String message)
	{
		try {
			
			PrintWriter outputWriter = new PrintWriter(this.getOutputStream());
			outputWriter.println("CHAT "+ message);
			outputWriter.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/*
	 * Sends the Game Protocol Quit message to the server the socket is connected to.
	 * Requires a String message to send to the server for the reason to quit.
	 * Returns True if command was successfully sent. Returns False if output connection failed.
	 */
	public boolean SendQuitMessage(String message)
	{
		try {
			
			PrintWriter outputWriter = new PrintWriter(this.getOutputStream());
			outputWriter.println("QUIT ["+ message +"]");
			outputWriter.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
