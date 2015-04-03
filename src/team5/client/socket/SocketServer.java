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

import java.net.*;
/**
 * start of server side
 */
import java.io.*;
public class SocketServer extends Thread
{
   private static int port;
   private final ServerSocket serverSocket;
   public SocketServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
     
   }
   @Override
   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " +
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("Just connected to "
                  + server.getRemoteSocketAddress());
            DataInputStream in =
                  new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
//            DataOutputStream out =
//                 new DataOutputStream(server.getOutputStream());
//            out.writeUTF("Thank you for connecting to "
//              + server.getLocalSocketAddress() + "\nGoodbye!");
//            server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            break;
         }
      }
   }
   
   
   public static void main(String [] args)
   {
      port=8080;
      try
      {
         Thread t = new SocketServer(port);
         t.start();
      }catch(IOException e)
      {
      }
   }
}
