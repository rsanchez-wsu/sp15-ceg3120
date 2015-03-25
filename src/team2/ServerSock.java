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
import java.io.*;

public class ServerSock implements Runnable {
	ServerSocket serverSocket;

	public ServerSock(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port "
						+ serverSocket.getLocalPort() + "...");
				Socket clientSocket = serverSocket.accept();
				System.out.println("Just connected to "
						+ clientSocket.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(
						clientSocket.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(
						clientSocket.getOutputStream());
				out.writeUTF("Thank you for connecting to "
						+ clientSocket.getLocalSocketAddress());

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}

		}
	}

	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		try {
			ServerSock server = new ServerSock(port);
			Thread t = new Thread(server);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}