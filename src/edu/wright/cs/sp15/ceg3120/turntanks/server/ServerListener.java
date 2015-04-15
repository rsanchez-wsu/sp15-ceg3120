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

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
//This class will act like a traditional multithreaded server socket class
//it will maintain references to all threads it makes

import edu.wright.cs.sp15.ceg3120.turntanks.Configuration;

public class ServerListener implements Runnable {
	
	protected static ArrayList<ServerNetcode> socketList = new ArrayList<>();
	private static boolean listenLoop = true;

	public ServerListener() {
	}

	@Override
	public void run() {
		try {
			process();
		} catch (Exception e) {
			// Exceptions cannot be thrown from within run()
			// TODO: Handle exception
			e.printStackTrace();
		}
	}

	private void process() {
		int port = Configuration.getListenPort();
		// Establish the listen socket.
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (listenLoop) {
				// Listen
				System.out.println("listening");
				Socket socket = serverSocket.accept();
				// Construct an object to process the socket connection
				ServerNetcode connection = new ServerNetcode(socket);
				socketList.add(connection);//keeps references to each thread
				Engine.outBuffers.add(new ConcurrentLinkedQueue<OutBufferInstruction>());
				Thread thread = new Thread(connection);
				// Start the thread.
				thread.start();
			}
			serverSocket.close();
		}
		catch (Exception e) {
			// TODO: Handle exception
			e.printStackTrace();
		}
	}

}
