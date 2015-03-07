package team6;

import java.io.*;
//import java.io.*;
import java.net.*;
//import java.util.*;
//This class implements run, and will be the primary worker parsing messages
//and sending instructions to the thread safe queue

public class ServerMTSock implements Runnable {
	Socket socket;
	int playerID;
	DataInputStream in;
	DataOutputStream out;

	public ServerMTSock(Socket socket) throws Exception {
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
		out= new DataOutputStream(socket.getOutputStream());
		playerID=ServerMTSockListen.socketList.size();
		
	}// end const

	public void run() {
		try { // run interface doesnt allow for throwable exceptions
			while (true) {
				process();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}// end run

	// reads from socket, places parsed instructions in inbound buffer then
	// reads from outbound buffer, sends instructions to client
	private void process() {
		while (true) {
			

			try {
				
				out.writeInt(-1);				
				int type=in.readInt();
				System.out.println("debug "+type);
				
				switch (type) {
				case -1: System.out.println("MT do nothing");				
				case 0:  System.out.println("MT parsing tank move");
						ServerMT.inBuffer.add(parseAsMove());  break;
		        case 1:  System.out.println("MT parsing tank attack");
		        		ServerMT.inBuffer.add(parseAsAttack()); break;
		        case 2:  System.out.println("MT parsing chat");
		        		ServerMT.inBuffer.add(parseAsChat()); break;

		        default: System.out.println("not a valid message parsed: serverMTSock");break;
		    }
				//check to see if next outbuffer message is for this thread
				
				
				////parse messages into MTInstructions

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}// end while

	} // end process
	
	private ServerMTInstruction parseAsMove(){		
		int type=0; //move
		int x=-1;
		int y=-1;		
		try {
			 x=in.readInt();
			 y=in.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServerMTInstruction temp = new ServerMTInstruction(type,x,y,"none",playerID, -1);
		
		return temp;
	}
	
	private ServerMTInstruction parseAsAttack(){		
		int type=1; //attack
		int x=-1;
		int y=-1;		
		try {
			 x=in.readInt();
			 y=in.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServerMTInstruction temp = new ServerMTInstruction(type,x,y,"none",playerID, -1);
		
		return temp;
	}
	
	private ServerMTInstruction parseAsChat(){
		int type=2;
		String message="default text:error";
		try {
			message=in.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServerMTInstruction temp = new ServerMTInstruction(type,-1,-1,message,playerID, -1);
		return temp;
	}

}
