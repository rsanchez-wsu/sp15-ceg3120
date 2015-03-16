/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 *  Copyright (C) <2015>  <Team 6>
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

package team6;

import java.io.*;
//import java.io.*;
import java.net.*;
//import java.util.*;
//This class implements run, and will be the primary worker parsing messages
//and sending instructions to the thread safe queue

public class ServerMTSock implements Runnable {
	Socket socket;
	int playerID;
	String name;
	DataInputStream in;
	DataOutputStream out;

	public ServerMTSock(Socket socket) throws Exception {
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
		out= new DataOutputStream(socket.getOutputStream());
		playerID=ServerMTSockListen.socketList.size();
		name=in.readUTF();// first thing client does is send a string name in utf
		System.out.println(name);
		out.writeInt(playerID);
		
		InBufferInstruction instruction = new InBufferInstruction(3,-1,-1,name,playerID, -1);
		ServerMT.inBuffer.add(instruction);
		
		
	}// end const

	public void run() {
		try { // run interface doesnt allow for throwable exceptions
			while (true) {
				process();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}// end run

	// reads from socket, places parsed instructions in inbound buffer then
	// reads from outbound buffer, sends instructions to client
	private void process() {
		while (true) {
			

			try {
			
			if (!ServerMT.outBuffers.get(playerID).isEmpty()){	// if queue isnt empty
				OutBufferInstruction instruction=(OutBufferInstruction)ServerMT.outBuffers.get(playerID).remove();
				out.writeInt(instruction.type);
				out.writeInt(instruction.playerNumber);
				out.writeUTF(instruction.playerName);
			}
			else{
				out.writeInt(-1);
			}
				
				
				int type=in.readInt();
				System.out.println("debug "+type);
				
				switch (type) {
				case -1: System.out.println("MT do nothing");				
				case 0:  System.out.println("MT parsing tank move");
						ServerMT.inBuffer.add(parseAsMove());  break;
		        case 1:  System.out.println("MT parsing tank attack");
		        		ServerMT.inBuffer.add(parseAsAttack()); break;
		        case 2:  System.out.println("MT parsing chat");
		        		ServerMT.inBuffer.add(parseAsChat()); break;

		        default: System.out.println("not a valid message parsed: serverMTSock");break;
		    }
				//check to see if next outbuffer message is for this thread
				
				
				////parse messages into MTInstructions

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}// end while

	} // end process
	
	private InBufferInstruction parseAsMove(){		
		int type=0; //move
		int x=-1;
		int y=-1;		
		try {
			 x=in.readInt();
			 y=in.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InBufferInstruction temp = new InBufferInstruction(type,x,y,"none",playerID, -1);
		
		return temp;
	}
	
	private InBufferInstruction parseAsAttack(){		
		int type=1; //attack
		int x=-1;
		int y=-1;		
		try {
			 x=in.readInt();
			 y=in.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InBufferInstruction temp = new InBufferInstruction(type,x,y,"none",playerID, -1);
		
		return temp;
	}
	
	private InBufferInstruction parseAsChat(){
		int type=2;
		String message="default text:error";
		try {
			message=in.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InBufferInstruction temp = new InBufferInstruction(type,-1,-1,message,playerID, -1);
		return temp;
	}

}
