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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Sample client to test with. Still getting some issues with this. Sending
 * multiple messages and getting messages back.
 * 
 * @author Brad
 *
 */
public class clientStructure {
	public static void main(String args[]) throws UnknownHostException,
			IOException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		Socket clientSocket = new Socket("localhost", 7777);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		boolean stayConnected = true;
		while (stayConnected) {
			System.out.print("User Input : ");
			String userIn = in.nextLine();
			if (userIn == "-1") {
				stayConnected = false;
			} else {
				outToServer.writeBytes(userIn);
				String dataBack = inFromServer.readLine();
				System.out.println("FROM SERVER: " + dataBack);
			}
		}
		clientSocket.close();
	}

}