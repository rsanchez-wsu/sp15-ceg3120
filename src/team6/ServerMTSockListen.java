package team6;

//import java.io.*;
import java.net.*;
import java.util.*;
//This class will act like a traditional multithreaded server socket class
//it will maintain references to all threads it makes

public class ServerMTSockListen implements Runnable {

	ArrayList<Socket> socketList = new ArrayList<Socket>();

	public ServerMTSockListen() {

	}// end constructor

	public void run() {
		try { // run interface doesnt allow for throwable exceptions
			process();
		} catch (Exception e) {
			System.out.println(e);
		}

	}// end run

	private void process() {

		int port = 6789;

		try {

			ServerSocket serverSocket;
			// Establish the listen socket.
			serverSocket = new ServerSocket(port);
			boolean listenLoop = true;
			while (listenLoop) {
				// Listen
				Socket socket = serverSocket.accept();
				// Construct an object to process the socket connection
				ServerMTSock connection = new ServerMTSock(socket);
				// Create a new thread to process the request.
				Thread thread = new Thread(connection);
				// Start the thread.
				thread.start();
			}// end while
			serverSocket.close();
		}// end try
		catch (Exception e) {
			System.out.println(e);
		}//end catch
	}

}// end ServerMultithreadedSocketCreator
