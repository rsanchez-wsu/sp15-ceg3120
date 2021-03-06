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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;
//
//Messy dont blame us, we were assigned server code, this started as just a test bench
//

public class driverClient {
	private static String serverName;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
		String ip = "104.231.9.131";
		/*
		 * GameMap currentMap = new GameMap();//test to ensure client can
		 * function off gameInstance currentMap.generateMap(); GameInstance
		 * clientGame= new GameInstance(Calendar.getInstance(), currentMap);
		 */

		GameInstance clientGame = new GameInstance(); // contains blank map, and
														// all tanks at 0/0
		///////////// TODO make this a method call/////////////////////
		JFrame gameFrame = new JFrame("game renderer Demo");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		// renderer section
		GameRenderer renderer = new GameRenderer(clientGame) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(64 * 50, 64 * 50);
			}
		};
		gameFrame.setSize(640, 480);
		gameFrame.getContentPane().add(new JScrollPane(renderer),
				BorderLayout.CENTER);
		gameFrame.setVisible(true);
		// TODO end make renderer method
		////////////////////////////////////////////////////
		
		////////////////////////////////////////////////////
		/////////// jtable debug
		JFrame tableFrame = new JFrame();
		String[] colnames = { "Tank Image", "Name", "IP", "x coord", "y coord",
				"Health", "Status" };
		Object[][] data = new Object[8][];
		for (int i = 0; i < 8; i++) {
			data[i] = clientGame.tanks.get(i).toStringArray();
		}
		JTable table = new JTable(data, colnames);// yeah its bad, fail me; i do
													// know about models
		tableFrame.add(table);
		tableFrame.setSize(500, 300);
		tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tableFrame.setVisible(true);
		/////////////// end jtable debug/////////
		
		/////////////controls/////////////////////
		JFrame controlFrame = new JFrame("game controls");
		ClientControls controls=new ClientControls();
		controlFrame.add(controls);
		controlFrame.setSize(150, 150);
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.setVisible(true);
		
		
		///////////////////////////////////
		Scanner input = new Scanner(System.in);

		int port = 6666;
		try {
			System.out.println("local: Connecting to " + ip + " on port "
					+ port);
			try (Socket client = new Socket(ip, port)) {

				System.out.println("local: Just connected to "
						+ client.getRemoteSocketAddress());
				// set up streams
				OutputStream outToServer = client.getOutputStream();
				InputStream inFromServer = client.getInputStream();
				DataOutputStream out = new DataOutputStream(outToServer);
				DataInputStream in = new DataInputStream(inFromServer);
				// loop var becomes false in several exceptions and on quit
				boolean loop = true;

				String name = "";
				// Take in the name and store it in the variable, name.
				System.out.println("enter name: ");
				name = input.next();

				out.writeUTF(name);
				int playerID = -1;
				playerID = in.readInt();
				System.out.println("debug client read in playerID as "
						+ playerID);

				// debug nothing should be in the socket buffers
				System.out
						.println("debug nothing should be in the socket buffers");

				while (loop) {

					Scanner scanner = new Scanner(System.in);
					int numMsg=in.readInt();
					if(numMsg!=0)
					System.out.println("debug number of message to expect "+numMsg);
					for (int i = 0 ; i < numMsg; i++) {
						//System.out.println("loop");
						int msgType = in.readInt();
						// TODO make each if a single method call
						
						if (msgType == 1) {// player name message
							inboundNameMessage(in, clientGame);
						}// end 1
						
						else if (msgType == 2) {
							inboundMoveMessage(in, clientGame, renderer);
						}// end 2

						else if (msgType == 3) {
							inboundTerrainMessage(in, clientGame, renderer);
						}//end 3
						
						else {
							System.out.println("debug the inbound messagetype was" + msgType);// should only ever be -1
						} // end else
						// TODO end make each if a method call
					}// end for that parses x number of messages
					//
					///////user input section
					//
					//System.out.println("Enter a 0 to move , 1 to attack, 2 to chat , or -1 to do nothing(do this alot)");
					int userInput = -1;					
					//temp user interface code
					int xCoord=controls.getInputX();
					int yCoord=controls.getInputY();					
					
					if (!(xCoord==0 && yCoord==0)){
						userInput=0;
					}
					
					//
					// TODO make each if a method call
					if (userInput == -1) {
						doNothing(out);
					} else if (userInput == 2) {
						chat(out, scanner, userInput);
					} else if (userInput == 0 || userInput == 1) {
						action(out, userInput, xCoord, yCoord, playerID, clientGame);
					}// end else if
					else {
						System.out.print("invalid choice, sending -1");
						out.writeInt(-1);
					}
					// TODO end make each if a method call
					//renderer.repaint();
					//updateTable(table, clientGame);
				}// end while
			}

		} catch (IOException e) {
			System.out.println("local: Failed to conect. Is Server running?");
		}

		System.out.println("local: Exiting");
	}// end main
	
	static public void debugGUIElements(){
		
		
		
		
		
		
		
		
	}
	
		// temp method for table update without model
	static public void updateTable(JTable table, GameInstance game) {
		String[] colnames = { "Tank Image", "Name", "IP", "x coord", "y coord",
				"Health", "Status" };
		Object[][] data = new Object[8][];

		for (int i = 0; i < 8; i++) {
			data[i] = game.tanks.get(i).toStringArray();
		}
		// removed debugging info
		table.setModel(new DefaultTableModel(data, colnames));
	}// updateTable
	
	static private void inboundNameMessage(DataInputStream in, GameInstance clientGame){
		try {
		System.out.println("debug inbound name message");
		int nameMsgPlayerID = in.readInt();
		String nameMsgPlayerName = in.readUTF();
		clientGame.tanks.get(nameMsgPlayerID).Name = nameMsgPlayerName;
		System.out.println("debug player number"
				+ nameMsgPlayerID + " is "
				+ nameMsgPlayerName);
		} catch(IOException e) {
			e.printStackTrace();
		}//end try catch
	}//end inboundNameMessage
	
	static private void inboundMoveMessage(DataInputStream in, GameInstance clientGame, GameRenderer renderer){
		try {
			System.out.println("debug inbound move message");
			int moveMsgPlayerID = in.readInt();
			int x = in.readInt();
			int y = in.readInt();
			clientGame.tanks.get(moveMsgPlayerID).xCoord = x;
			clientGame.tanks.get(moveMsgPlayerID).yCoord = y;
			renderer.repaint();
			System.out.println("debug " + moveMsgPlayerID
					+ " tank moved to " + x + ", " + y);
		} catch(IOException e) {
			e.printStackTrace();
		}//end try catch
	}//end inboundMoveMessage
	
	static private void inboundTerrainMessage(DataInputStream in, GameInstance clientGame, GameRenderer renderer){
		try {
			//System.out.println("debug inbound terrain message");
			int x = in.readInt();
			int y = in.readInt();
			char base = in.readChar();
			char top = in.readChar();
			char style = in.readChar();
			char corner = in.readChar();
			clientGame.gameMap.baseLayer[y][x] = base;
			clientGame.gameMap.topLayer[y][x] = top;
			clientGame.gameMap.spriteStyle[y][x] = style;
			clientGame.gameMap.corners[y][x] = corner;
			renderer.repaint();
			//System.out.println("debug tile " + x + " , " + y
			//		+ " btsc " + base + top + style + corner);
		} catch(IOException e) {
			e.printStackTrace();
		}//end try catch
	}//end inboundTerrainMessage
	
	static private void doNothing(DataOutputStream out) {
		try {
			out.writeInt(-1);
			// System.out.println("You have chosen to do nothing.");
		} catch(IOException e) {
			e.printStackTrace();
		}//end of try-catch
	}//end of doNothing
	
	static private void chat(DataOutputStream out, Scanner scanner, int userInput) {
		try {
			// System.out.println("chat type sent, enter message");
			out.writeInt(userInput);
			System.out.print("Enter the message: ");
			scanner.next();
			String message = scanner.nextLine();
			out.writeUTF(message);
		} catch(IOException e) {
			e.printStackTrace();
		}//end of try-catch
	}//end of chat
	
	static private void action(DataOutputStream out, int userInput, int xCoord, int yCoord, int playerID, GameInstance clientGame) {
		try {
			out.writeInt(userInput);
			int temp1=(xCoord+clientGame.tanks.get(playerID).xCoord);
			int temp2=(yCoord+clientGame.tanks.get(playerID).yCoord);
			out.writeInt(temp1);
			out.writeInt(temp2);
			System.out.println(userInput);
			System.out.println(temp1);
			System.out.println(temp2);
			System.out.println("if complete");		
		} catch(IOException e) {
			e.printStackTrace();
		}//end of try-catch
	}//end of action

}
