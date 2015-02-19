package team6;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class gameNetCode {
	 //private static String serverName;//not used yet
	   

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        String sName = "localhost";
	        if (0 < args.length) {
	            sName = args[0];

	        }
	        //Scanner input = new Scanner(System.in);//not used debugging
	        int port = 8080;
	        try {
	            System.out.println("Connecting to " + sName
	                    + " on port " + port);
	            try (Socket client = new Socket(sName, port)) {
	                System.out.println("Just connected to "
	                        + client.getRemoteSocketAddress());
	                OutputStream outToServer = client.getOutputStream();
	                DataOutputStream out
	                        = new DataOutputStream(outToServer);


	                String command = userInput();
	                out.writeUTF(command);

	                out.writeUTF("Hello"
	                        + client.getLocalSocketAddress());
	                InputStream inFromServer = client.getInputStream();
	                DataInputStream in
	                        = new DataInputStream(inFromServer);
	                System.out.println(in.readUTF());
	            }
	        } catch (IOException e) {
	            System.out.println("Failed to conect. Is Server running?");
	        }

	        System.out.println("Exiting");
	    }

	    public static String userInput() {

	        Scanner input = new Scanner(System.in);
	        
	        System.out.print("Enter a command: ");
	        String command = input.next();

	        if (command.equals("CONNECT")) {
	            
	            System.out.print("Welcome ");   
	            
	        }
	        if (command.equals("MOVE")) {
	            System.out.println("ACTION MOVE");
	        }
	        if (command.equals("ATTACK")) {
	            System.out.println("ACTION ATTACK");
	        }
	        if (command.equals("PASS")) {
	            System.out.println("ACTION PASS");
	        }
	        if (command.equals("CHAT")) {
	            System.out.println("LETS CHAT");
	        }
	        
	        
	        input.close();
	        return command;
	        
	    }


}
