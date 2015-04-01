/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 *  Copyright (C) <2015>  <Team 6>
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

package edu.wright.cs.sp15.ceg3120.turntanks.server;

//import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.util.*;
//This class will act like a traditional multithreaded server socket class
//it will maintain references to all threads it makes

public class ServerListener implements Runnable {
	
	static ArrayList<ServerNetcode> socketList = new ArrayList<ServerNetcode>();

	public ServerListener() {

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
				ServerNetcode connection = new ServerNetcode(socket);
				socketList.add(connection);//keeps references to each thread
				Engine.outBuffers.add(new ConcurrentLinkedQueue());
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
