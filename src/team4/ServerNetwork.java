/*
 *  Copyright (C) <2015>  <Benjamin Hansen> - hansen.21@wright.edu
 *  <Brad Reynolds> - reynolds.0345@gmail.com
 *  					 ADD names/emails here
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
package team4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerNetwork {

	public static void main(String[] args) {
		// Create a server socket
		try {
			@SuppressWarnings("unused")
			int threadNum = 1;
			// Create a server socket (socket not specified yet)
			@SuppressWarnings("resource")
			ServerSocket sSocket = new ServerSocket(7777);

			// Create Threaded Sockets
			System.out.println("Created Server. Running on port "
					+ sSocket.getLocalPort());
			while (true) {
				Socket incoming = sSocket.accept();
				Runnable run = new GameThreadHandler(incoming);
				Thread thread = new Thread(run);
				thread.start();
				threadNum++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Handler for a Game thread
 */
class GameThreadHandler implements Runnable {
	private Socket incoming;

	public GameThreadHandler(Socket incoming) {
		this.incoming = incoming;
	}

	public void run() {
		try {
			try {

				// Get Input and Output Streams
				InputStream clientStream = incoming.getInputStream();
				OutputStream serverStream = incoming.getOutputStream();

				// Create a scanner and writer for the streams
				@SuppressWarnings("resource")
				Scanner in = new Scanner(clientStream);
				PrintWriter out = new PrintWriter(serverStream, true);

				// print welcome message (maybe we create a method to generate
				// messages?)
				System.out.println("User Connected");
				out.println("WELCOME USER");
				
				// Process client messages
				boolean done = false;
				while (!done && in.hasNextLine()) {
					String clientMessage = in.nextLine();
					System.out.println(clientMessage);
					out.println("Thanks For Sending : " + clientMessage);

					// need processing methods
					if (clientMessage.trim().equals("CONNECT")) {
					}
					if (clientMessage.trim().equals("ACTION MOVE")) {

					}
					if (clientMessage.trim().equals("ACTION ATTACK")) {

					}
					if (clientMessage.trim().equals("ACTION PASS")) {

					}
					if (clientMessage.trim().equals("CHAT")) {

					}
					if (clientMessage.trim().equals("QUIT")) {
						done = true;
					}
				}

			} finally {
				incoming.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
