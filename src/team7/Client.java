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

package team7;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

// (JTC) This will be the client object which maintains the socket and communicates to the views and models.

public class Client {
	
	//Create Client Variables
	Socket s;
	DataInputStream din = null;
	DataOutputStream dout = null;
	InputStream is = null;
	OutputStream os = null;
	
	// Incoming Message
	String smsg;
	
	public Client()
	{
		try
		{
			// (JTC) Creates a socket on localhost through port 1500
			s = new Socket("127.0.0.1", 1500);
			
			// This will continue while the socket is open
			while(true)
			{
				// (JTC) Establish I/O Stream
				is = s.getInputStream();
				din = new DataInputStream(is);
				os = s.getOutputStream();
				dout = new DataOutputStream(os);
				
				smsg = din.readUTF();
				
				
				/* (JTC) COMMAND PROCESSOR				
				switch(smsg)
				{
					case "WELCOME":
						//TODO
						break;
					case "PLAYERS PRESENT":
						//TODO
						break;
					case "SORRY - GAME IN PROGRESS":
						//TODO
						break;
					case "Game Started":
						//TODO
						break;
					case "Game Started":
						//TODO
						break;
					case "Game Started":
						//TODO
						break;
				} */
				
				
			}
		}catch(Exception e){
			System.out.println("Error in connection...");
			try {
				s.close();
			} catch (IOException e1) {
				System.out.println("Failed to close socket properly.");
			}
		}
	}
	
	// (JTC) This is just for testing.  The retrieving of players will normally be handles in the command processor.
	public static ArrayList<Player> genPlayers()
	{
		ArrayList<Player> players = new ArrayList<>();

		players.add(new Player("Player 1", 3, 5));
		players.add(new Player("Player 2", 8, 7));
		players.add(new Player("Player 3", 2, 5));
		players.add(new Player("Player 4", 4, 6));
		players.add(new Player("Player 5", 1, 9));
		players.add(new Player("Player 6", 0, 0));
		players.add(new Player("Player 7", 0, 1));
		players.add(new Player("Player 8", 6, 6));
		
		return players;
	}

}
