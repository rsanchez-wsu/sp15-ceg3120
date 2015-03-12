package team2;
/*
 * Copyright (C) <2015> <Team 2>
 * 
 * Will Hatfield
 * Kevin Alig
 * Alyssa Ramsey
 * Anthony Lamping
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
import java.net.*;
import java.util.*;

public class ServerListen implements Runnable {

	protected ArrayList<ServerClient> clients = new ArrayList<>();
	private ServerSocket serverSocket;
	private Socket socket;
	private static final int PORT = 6667;
	private static final boolean DEBUG = true;

	public ServerListen() throws Exception {

		serverSocket = new ServerSocket(PORT); // setup the listen socket.
		Thread t = new Thread(this);
		t.start();
		
	}

	// Implement the run() method of the Runnable interface.
	@Override
	public void run() {
		// run processConnection in a thread
		try {
			processConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of method run

	private void processConnection() throws Exception {

		while (true) {
			socket = serverSocket.accept(); // listen for connection
			if (DEBUG) {
				String connectionIP = new String(socket.getInetAddress().toString());
				System.out.println("DEBUG: Client connected with IP: " + connectionIP);
			}
			clients.add(new ServerClient(socket));
		}
	}

}