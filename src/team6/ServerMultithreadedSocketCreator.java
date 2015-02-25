package team6;

//import java.io.*;
import java.net.*;
import java.util.*;
//This class will act like a traditional multithreaded server socket class
//it will maintain references to all threads it makes

public class ServerMultithreadedSocketCreator {
	
	ArrayList<Socket> socketList = new ArrayList<Socket>();

	public ServerMultithreadedSocketCreator() {
		int port = 6789;
		
		try {
			// Set the port number.
			
			ServerSocket serverSocket;
			// Establish the listen socket.
			serverSocket = new ServerSocket(port);
			// Process HTTP service requests in an infinite loop.
			boolean listenLoop=true;
			while (listenLoop) {
				// Listen for a TCP connection request.
				Socket socket = serverSocket.accept();
				// Construct an object to process the socket connection
				ServerMultithreadedSocket connection = new ServerMultithreadedSocket(
						socket);
				// Create a new thread to process the request.
				Thread thread = new Thread(connection);
				// Start the thread.
				thread.start();
			}// end while
			serverSocket.close();
		}// end try
		catch (Exception e) {
			System.out.println(e);
		}// end catch
		
		
		
	}// end constructor

}// end ServerMultithreadedSocketCreator
