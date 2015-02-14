/*
 *  Copyright (C) <2015>  <Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker>
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
package team5.client.socket;

import java.io.*;
import java.net.*;
/**
 *
 * @author erik
 */
public class SocketClient {
    private static String serverName;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sName = "localhost";
        if(0 < args.length) {
           sName = args[0];
        }
        
        int port = 8080;
        try {
            System.out.println("Connecting to " + sName
                    + " on port " + port);
            try (Socket client = new Socket(sName, port)) {
                System.out.println("Just connected to "
                        + client.getRemoteSocketAddress());
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out
                        = new DataOutputStream(outToServer);
                out.writeUTF("Hello from "
                        + client.getLocalSocketAddress());
                InputStream inFromServer = client.getInputStream();
                DataInputStream in
                        = new DataInputStream(inFromServer);
                System.out.println("Server says " + in.readUTF());
            }
        } catch (IOException e) {
            System.out.println("Failed to conect. Is Server running?");
        }
        
        System.out.println("Exiting");
    }
	public static String getServerName() {
		return serverName;
	}
	public static void setServerName(String serverName) {
		SocketClient.serverName = serverName;
	}
}
