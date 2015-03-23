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
import java.net.*;
import java.util.*;

public class ClientNetcode {
	   private static String serverName;

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	    	GameInstance clientGame= new GameInstance();
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
	                    System.out.println("local: Enter command:   ");

	                    Scanner scanner = new Scanner(System.in);
	                    
	                    	int temp=in.readInt();
	                    	
	                    	if (temp==1){
	                    	System.out.println("debug inbound message");		
	                    	System.out.println(in.readInt()+" :debug should be player number");	
	                    	System.out.println(in.readUTF()+" :debug should be player name");	
	                    	}
	                    	
	                    	else	                    		
	                        System.out.println("the inbound messagetype was"+temp);//wait for the -1
	                    	
	                    	System.out.println(" server wants a message"); 
	                        System.out.println("Enter a 0 to move your tank, enter 1 to attack another tank,\nenter 2 to send a chat message, or enter -1 to do nothing.");
	                        int userInput = scanner.nextInt();                        
	                        out.writeInt(userInput);
	                        if (userInput==-1){
	                        	out.writeInt(-1);
	                            //System.out.println("nothing to send message sent");
	                           System.out.println("You have chosen to do nothing.");
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
	                            System.out.print("Enter the coordinates for your chosen action: ");
	                        userInput = scanner.nextInt();
	                        out.writeInt(userInput);
	                        userInput = scanner.nextInt();
	                        out.writeInt(userInput);
	                        }//end else if
	                        else{
	                        	System.out.print("invalid choice, you broke the client for now");
	                        }

	                }//end while
	            }


	        } catch (IOException e) {
	            System.out.println("local: Failed to conect. Is Server running?");
	        }

	        System.out.println("local: Exiting");
	    }//end main	
		
		
		
		
	    
	}
