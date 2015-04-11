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

package edu.wright.cs.sp15.ceg3120.turntanks.server;

import java.io.*;
//import java.io.*;
import java.net.*;
//import java.util.*;
//This class implements run, and will be the primary worker parsing messages
//and sending instructions to the thread safe queue

public class ServerNetcode implements Runnable {
	Socket socket;
	int playerID;
	String name;
	DataInputStream in;
	DataOutputStream out;

	public ServerNetcode(Socket socket) throws Exception {
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
		playerID = ServerListener.socketList.size();
		// first thing client does is send a string name in UTF
		name = in.readUTF();
		System.out.println("debug client connected with name of " + name);
		out.writeInt(playerID);
		InBufferInstruction instruction = new InBufferInstruction(3, -1, -1, name, playerID, -1);
		// makes the playername inBufferInstructions
		Engine.inBuffer.add(instruction);

		// debug nothing should be in the socket buffers
		System.out.println("debug nothing should be in the socket buffers");

	}

	@Override
	public void run() {
		try {
			while (true) {
				process();
			}
		} catch (Exception e) {
			// Exceptions cannot be thrown from within run()
			// TODO: Handle exception
			e.printStackTrace();
		}
	}

	// reads from socket, places parsed instructions in inbound buffer then
	// reads from outbound buffer, sends instructions to client
	private void process() {
		while (true) {

			try {

				if (!Engine.outBuffers.get(playerID).isEmpty()) {
					// if queue isn't empty
					int size = Engine.outBuffers.get(playerID).size();
					out.writeInt(size);
					for (int i = 0; i < size; i++) {// thread safety by not just
													// emptying
						OutBufferInstruction instruction = Engine.outBuffers.get(playerID).remove();
						// TODO make ifs method calls
						if (instruction.type == 1) {
							nameMessage(instruction);
						}// end 1 name msg

						else if (instruction.type == 2) {
							tankMoveMessage(instruction);
						}// end 2 tank move msg
						
						else if (instruction.type == 3) {
							terrainMessage(instruction);
						}// end 3 terrain msg

						else {
							System.out.println("mtsock error!");
						}// end else

						// TODO end
					}
				} else {
					out.writeInt(0);// number of messages

				}// end

				int type = in.readInt();
				if (type != -1)
					System.out.println("debug read from socket: " + type);

				switch (type) {
				case -1:
					// System.out.println("MT parsing(not really) nothing message");
					break;
				case 0:
					System.out.println("MT parsing tank move");
					Engine.inBuffer.add(parseAsMove());
					break;
				case 1:
					System.out.println("MT parsing tank attack");
					Engine.inBuffer.add(parseAsAttack());
					break;
				case 2:
					System.out.println("MT parsing chat");
					Engine.inBuffer.add(parseAsChat());
					break;

				default:
					System.out.println("not a valid message parsed: serverMTSock");
					break;
				}
				// check to see if next outbuffer message is for this thread

				// //parse messages into MTInstructions

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private InBufferInstruction parseAsMove() {
		int type = 0; // move
		int x = -1;
		int y = -1;
		try {
			x = in.readInt();
			System.out.println(x);
			y = in.readInt();
			System.out.println(y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InBufferInstruction temp = new InBufferInstruction(type, x, y, "none", playerID, -1);

		return temp;
	}

	private InBufferInstruction parseAsAttack() {
		int type = 1; // attack
		int x = -1;
		int y = -1;
		try {
			x = in.readInt();
			y = in.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InBufferInstruction temp = new InBufferInstruction(type, x, y, "none", playerID, -1);

		return temp;
	}

	private InBufferInstruction parseAsChat() {
		int type = 2;
		String message = "default text:error";

		try {
			message = in.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InBufferInstruction temp = new InBufferInstruction(type, -1, -1, message, playerID, -1);
		return temp;
	}

	// if, else-if logic in methods
	private void nameMessage(OutBufferInstruction instruction) {
		try {
			System.out.println("debug in serverMTSock sending Type= " + instruction.type);// displaying this instead of debug
			System.out.println("debug writing to socket: " + instruction.type);
			out.writeInt(instruction.type);
			System.out.println("debug writing to socket: " + instruction.playerNumber);
			out.writeInt(instruction.playerNumber);
			System.out.println("debug writing to socket: " + instruction.playerName);
			out.writeUTF(instruction.playerName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void tankMoveMessage(OutBufferInstruction instruction) {
		try {
			System.out.println("debug in serverMTSock sending move, msgType= " + instruction.type);
			out.writeInt(instruction.type);
			out.writeInt(instruction.playerNumber);// of moving tank
			out.writeInt(instruction.x);
			out.writeInt(instruction.y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void terrainMessage(OutBufferInstruction instruction) {
		try {
			System.out.println("debug in serverMTSock sending terrain, msgType= " + instruction.type);
			out.writeInt(instruction.type);
			out.writeInt(instruction.x);
			out.writeInt(instruction.y);
			out.writeChar(instruction.base);
			out.writeChar(instruction.top);
			out.writeChar(instruction.style);
			out.writeChar(instruction.corner);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
