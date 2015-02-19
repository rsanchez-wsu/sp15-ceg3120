package team6;
import java.io.*;
import java.util.*;
import java.net.*;

public class serverNetcode extends Thread {
	 
	private static int port;
	    private final ServerSocket serverSocket;

	    public serverNetcode(int port) throws IOException {
	        serverSocket = new ServerSocket(port);
	        serverSocket.setSoTimeout(20000);
	    }

	    @Override
	    public void run() {
	        while (true) {
	            try {
	                System.out.println("Waiting for client on port "
	                        + serverSocket.getLocalPort() + "...");
	                Socket server = serverSocket.accept();
	                System.out.println("Just connected to "
	                        + server.getRemoteSocketAddress());
	                DataInputStream in
	                        = new DataInputStream(server.getInputStream());
	                String gameMessage = in.readUTF();
	                DataOutputStream out
	                        = new DataOutputStream(server.getOutputStream());

	                if (gameMessage.equals("CONNECT")) {
	                    Scanner input = new Scanner(System.in);
	                    System.out.print("Enter your player name: ");
	                    String player = input.next();
	                    out.writeUTF("Welcome "+player+" 1 "+"location: 5,7");
	                    input.close();
	                }
	                if (gameMessage.startsWith("MOVE")) {
	                    out.writeUTF("THE TANK WILL MOVE");
	                }
	                if (gameMessage.startsWith("ATTACK")) {

	                    out.writeUTF("THE TANK WILL ATTACK");
	                }
	                if (gameMessage.startsWith("PASS")) {

	                    out.writeUTF("THE PLAYER PASSES");
	                }
	                if (gameMessage.startsWith("CHAT")) {

	                    out.writeUTF("CHAT");
	                }

	                if (gameMessage.equals("QUIT")) {
	                    out.writeUTF("Thank you for playing");
	                    server.close();
	                }

	            } catch (SocketTimeoutException s) {
	                System.out.println("Socket timed out!");
	                break;
	            } catch (IOException e) {
	                break;
	            }
	        }
	    }

	    public static void main(String[] args) throws IOException {
	        {
	            port = 8080;
	            try {
	                Thread t = new serverNetcode(port);
	                t.start();
	            } catch (IOException e) {
	            }
	        }

	    }
}
