package team6;

//import java.io.*;
import java.net.*;
import java.util.*;
//This class will act like a traditional multithreaded server socket class
//it will maintain references to all threads it makes

public class ServerMTSockListen implements Runnable {
	
	static ArrayList<ServerMTSock> socketList = new ArrayList<ServerMTSock>();

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

		int port = 6666;

		try {

			ServerSocket serverSocket;
			// Establish the listen socket.
			serverSocket = new ServerSocket(port);
			boolean listenLoop = true;
			while (listenLoop) {
				// Listen
				System.out.println("listening");
				Socket socket = serverSocket.accept();
				// Construct an object to process the socket connection
				ServerMTSock connection = new ServerMTSock(socket);
				socketList.add(connection);//keeps references to each thread
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
