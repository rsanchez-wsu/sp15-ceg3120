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
import java.io.*;
import java.net.*;

public class ServerClient {

	private Socket socket;
	private ConnectRequest request;
	private boolean connected;

	private final boolean DEBUG = true; // Debug Flag

	public ServerClient(Socket socket) {
		this.socket = socket;
		connected = true;
		// Construct an object to process the request message.
		request = new ConnectRequest();
		// Create a new thread to process the request.
		Thread thread = new Thread(request);
		// Start the thread.
		thread.start();
		if (DEBUG) {
			System.out.println("DEBUG: New Client"); 
		}
	}

	private class ConnectRequest implements Runnable {


		// Implement the run() method of the Runnable interface.
		@Override
		public void run() {
			// run processRequest in a thread
			try {
				processRequest();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// end of method run

		private void processRequest() throws Exception {
			// Get a reference to the socket's input and output streams.
			InputStream is = socket.getInputStream();
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			// Set up stream filters
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			// Process input messages
			while (connected) {
				if (br.ready() && br.readLine() != null) {
					String requestLine = br.readLine();
					if (DEBUG) {
						System.out.println(requestLine);
					}
					if (requestLine.equalsIgnoreCase("QUIT")) {
						os.writeUTF("BYE");
						closeConnection();
					}
					else{
						os.writeUTF(requestLine);
					}
				}
				Thread.sleep(2000);
			}

		}

		public void closeConnection() throws Exception {
			connected = false;
			socket.close();
		}
	}
}
