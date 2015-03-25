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
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	    	
	    	/*GameMap currentMap = new GameMap();//test to ensure client can function off gameInstance
			currentMap.generateMap();
	    	GameInstance clientGame= new GameInstance(Calendar.getInstance(), currentMap);
	    	*/
	    	
	    	GameInstance clientGame= new GameInstance(); //contains blank map, and all tanks at 0/0
	    	//TODO make this a method call
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
			//TODO end make renderer method
			//
			//jtable debug
			JFrame tableFrame=new JFrame();
			String[] colnames= {"Tank Image", "Name", "IP",
		            "x coord", "y coord", "Health","Status"};
			Object[][] data = new Object[8][];
	        for (int i=0;i<8;i++){
	        	data[i]=clientGame.tanks.get(i).toStringArray();
	        }
			JTable table=new JTable(data, colnames);//yeah its bad, fail me; i do know about models
			tableFrame.add(table);
			tableFrame.setSize(500, 300);
			tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tableFrame.setVisible(true);
			
			
			//end jtable debug
			//
	    	Scanner input = new Scanner(System.in);
	        String sName = "104.231.9.131";
	        if (0 < args.length) {
	            sName = args[0];
	        }

	        int port = 6666;
	        try {
	            System.out.println("local: Connecting to " + sName
	                    + " on port " + port);
	            try (Socket client = new Socket(sName, port)) {

	                System.out.println("local: Just connected to "
	                        + client.getRemoteSocketAddress());
	                //set up streams
	                OutputStream outToServer = client.getOutputStream();
	                InputStream inFromServer = client.getInputStream();
	                DataOutputStream out = new DataOutputStream(outToServer);
	                DataInputStream in = new DataInputStream(inFromServer);
	                //loop var becomes false in several exceptions and on quit
	                boolean loop = true;	                
	                
	                String name = "";
	                //Take in the name and store it in the variable, name.
	                System.out.println("enter name: ");
	                name = input.next();
	                
	                out.writeUTF(name);
	                int playerID=-1;
	                playerID=in.readInt();
	                System.out.println("debug client read in playerID as "+playerID);
	                
	                //debug nothing should be in the socket buffers
	        		System.out.println("debug nothing should be in the socket buffers");	        		
	        		
	                
	                
	                while (loop) {	                    

	                    Scanner scanner = new Scanner(System.in);
	                    
	                    	int msgType=in.readInt();
	                    	//TODO make each if a single method call
	                    	if (msgType==1){//player name message
	                    	System.out.println("debug inbound name message");
	                    	int nameMsgPlayerID= in.readInt();	                    		
	                    	String nameMsgPlayerName = in.readUTF();	                    	
	                    	clientGame.tanks.get(nameMsgPlayerID).Name=nameMsgPlayerName;	                    	
	                    	System.out.println("debug player number"+nameMsgPlayerID+" is "+nameMsgPlayerName);
	                    	}//end 1
	                    	else if(msgType==2){
	                    	System.out.println("debug inbound move message");
	                    	int moveMsgPlayerID= in.readInt();
	                    	int x=in.readInt();
	                    	int y=in.readInt();
	                    	clientGame.tanks.get(moveMsgPlayerID).xCoord=x;
	                    	clientGame.tanks.get(moveMsgPlayerID).yCoord=y;
	                    	renderer.repaint();
	                    	System.out.println("debug "+moveMsgPlayerID +" tank moved to "+ x + ", "+y);
	                    	}//end 2
	                    	
	                    	else if(msgType==3){
	                    		System.out.println("debug inbound terrain message");
		                    	int x= in.readInt();
		                    	int y= in.readInt();
		                    	char base = in.readChar();
		                    	char top = in.readChar();
		                    	char style = in.readChar();
		                    	char corner = in.readChar();
		                    	clientGame.gameMap.baseLayer[y][x]=base;
		                    	clientGame.gameMap.topLayer[y][x]=top;
		                    	clientGame.gameMap.spriteStyle[y][x]=style;
		                    	clientGame.gameMap.corners[y][x]=corner;
		                    	renderer.repaint();
		                    	System.out.println("debug tile "+x +" , "+ y+" btsc "+base+top+style+corner);
	                    	}
	                    	else	                    		
	                        System.out.println("debug the inbound messagetype was"+msgType);//should only ever be -1 for now, will upgrade to a better system like exception throwing(lol not really)
	                    	//TODO end make each if a method call	                    	
	                    	
	                    	
	                        System.out.println("Enter a 0 to move , 1 to attack, 2 to chat , or -1 to do nothing(do this alot)");
	                        int userInput = scanner.nextInt();                        
	                        out.writeInt(userInput);
	                        
	                        //TODO make each if a method call
	                        if (userInput==-1){
	                        	out.writeInt(-1);	                         
	                           //System.out.println("You have chosen to do nothing.");
	                        }
	                        else if (userInput==2){
	                            //System.out.println("chat type sent, enter message");
	                            System.out.print("Enter the message: ");
	                            scanner.next();
	                            String message = scanner.nextLine();
	                            out.writeUTF(message); 
	                        }
	                        else if(userInput==0||userInput==1){
	                            //System.out.println("move or attack type sent, enter two coords");   
	                            System.out.print("Enter the coordinates: ");
	                        userInput = scanner.nextInt();
	                        out.writeInt(userInput);
	                        userInput = scanner.nextInt();
	                        out.writeInt(userInput);
	                        }//end else if
	                        else{
	                        	System.out.print("invalid choice, sending -1");
	                        	out.writeInt(-1);
	                        }
	                        //TODO end make each if a method call
	                        renderer.repaint();
	                        updateTable(table,clientGame);
	                }//end while
	            }
	            
	            

	        } catch (IOException e) {
	            System.out.println("local: Failed to conect. Is Server running?");
	        }

	        System.out.println("local: Exiting");
	    }//end main	
		//temp method for table update without model
	    static public void updateTable(JTable table,GameInstance game)
	    {  
	    	String[] colnames= {"Tank Image", "Name", "IP",
		            "x coord", "y coord", "Health","Status"};
			Object[][] data = new Object[8][];
	    	
	    	for (int i=0;i<8;i++){
	        	data[i]=game.tanks.get(i).toStringArray();
	        }
	    	//removed debugging info   	
	       table.setModel(new DefaultTableModel(data,colnames ));       
	    }//updateTable	
		
		
	    
	}
