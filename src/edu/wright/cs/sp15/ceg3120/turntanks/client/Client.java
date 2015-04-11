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

import java.awt.Point;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import edu.wright.cs.sp15.ceg3120.turntanks.Configuration;

// (JTC) This will be the client object which maintains the socket and communicates to the views and models.

public class Client {
	
	//Create Client Variables
	private Socket s;
	private DataInputStream din = null;
	private DataOutputStream dout = null;
	private InputStream is = null;
	private OutputStream os = null;
	
	// Incoming Message
	private String smsg;
	
	public Client() {
		try {
			// (JTC) Opens a socket on to the configured game server
			s = new Socket(Configuration.getServerAddress(), Configuration.getServerPort());
			
			// (JTC) Establish I/O Stream
			is = s.getInputStream();
			din = new DataInputStream(is);
			os = s.getOutputStream();
			dout = new DataOutputStream(os);
			
			//(kwood) After socket is opened, send connect message with player name.
			dout.writeUTF("CONNECT " + ClientView.getPlayer().getName());
			
			
			// This will continue while the socket is open
			while(true)
			{				
				smsg = din.readUTF();
							
				
				//COMMAND PROCESSOR 
				switch(smsg) { 
				case "WELCOME": // TODO
					break;
				case "PLAYERS PRESENT": // TODO
					break;
				case "SORRY - GAME IN PROGRESS": // TODO
					break;
				case "GAME STARTED": // TODO
					break;
				case "GAME ENDED": // TODO
					break;
				case "MAP INFO": // ?EMPTY?
					// TODO
					break;
				case "HEALTH": // TODO
					break;
				case "GO": // TODO
					break;
				case "TIME": // TODO
					break;
				case "CHAT FROM": // TODO
					break;
				case "ILLEGAL ACTION": // TODO
					break;
				case "PLAYER MOVED": // TODO
					break;
				case "PLAYER ATTACKING": // TODO
					break;
				case "ATTACK HIT": // TODO
					break;
				case "ATTACK MISS": // TODO
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
	
	// (JTC) This is just for testing.  The retrieving of players will normally be handles in the command processor.
	public static ArrayList<Player> genPlayers()
	{
		ArrayList<Player> players = new ArrayList<>();

		players.add(new Player(1, "Player 1"));
		players.get(0).setPlayerLocation(new Point(3,5));
		
		players.add(new Player(2, "Player 2"));
		players.get(1).setPlayerLocation(new Point(8,7));
		
		players.add(new Player(3, "Player 3"));
		players.get(2).setPlayerLocation(new Point(2,5));
		
		players.add(new Player(4, "Player 4"));
		players.get(3).setPlayerLocation(new Point(4,6));
		
		players.add(new Player(5, "Player 5"));
		players.get(4).setPlayerLocation(new Point(1,9));
		
		players.add(new Player(6, "Player 6"));
		players.get(5).setPlayerLocation(new Point(0,0));
		
		players.add(new Player(7, "Player 7"));
		players.get(6).setPlayerLocation(new Point(0,1));
		
		players.add(new Player(8, "Player 8"));
		players.get(7).setPlayerLocation(new Point(6,6));
		
		return players;
	}

}
