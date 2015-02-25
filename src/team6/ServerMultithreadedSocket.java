package team6;
//import java.io.*;
import java.net.*;
//import java.util.*;
//This class implements run, and will be the primary worker parsing messages and sending instructions to the thread safe buffer


public class ServerMultithreadedSocket implements Runnable {
    Socket socket;

   
    public ServerMultithreadedSocket(Socket socket) throws Exception {
        this.socket = socket;
    }//end const
    
    
	   public void run() {
	        try {  //run interface doesnt allow for throwable exceptions
	            process();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        
	    }//end run	
	   
	//reads from socket, places parsed instructions in inbound buffer then reads from outbound buffer, sends instructions to client
	private void process(){
		
		
		
		
	} //end process  

	

}
