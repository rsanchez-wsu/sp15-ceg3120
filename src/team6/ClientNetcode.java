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
	        String sName = "localhost";
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
	                
	                
	                
	                
	                while (loop) {
	                    System.out.println("local: Enter command:   ");

	                    Scanner scanner = new Scanner(System.in);
	                    
	                    
	                    
	                        System.out.println(in.readInt()+" server wants a message");//wait for the -1
	                        int userInput = scanner.nextInt();                        
	                        out.writeInt(userInput);
	                        if (userInput==-1){
	                            System.out.println("nothing to send message sent");
	                        }
	                        else if (userInput==2){
	                            System.out.println("chat type sent, enter message");
	                            scanner.next();
	                            String temp = scanner.nextLine();
	                            out.writeUTF(temp);
	                        }
	                        else{
	                            System.out.println("move or atttack type sent, enter two coords");                            
	                        userInput = scanner.nextInt();
	                        out.writeInt(userInput);
	                        userInput = scanner.nextInt();
	                        out.writeInt(userInput);
	                        }//end else

	                }//end while
	            }


	        } catch (IOException e) {
	            System.out.println("local: Failed to conect. Is Server running?");
	        }

	        System.out.println("local: Exiting");
	    }//end main	
		
		
		
		
	    
	}
