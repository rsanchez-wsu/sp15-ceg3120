package team5.client.socket;

import java.net.*;
import java.io.*;
public class SocketServer extends Thread
{
   private static int port;
   private final ServerSocket serverSocket;
   public SocketServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(20000);
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
            DataOutputStream out =
                 new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to "
              + server.getLocalSocketAddress() + "\nGoodbye!");
            server.close();
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
