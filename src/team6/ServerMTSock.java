package team6;

import java.io.DataInputStream;
import java.io.IOException;
//import java.io.*;
import java.net.*;
//import java.util.*;
//This class implements run, and will be the primary worker parsing messages
//and sending instructions to the thread safe queue

public class ServerMTSock implements Runnable {
	Socket socket;
	DataInputStream in;

	public ServerMTSock(Socket socket) throws Exception {
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
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
			ServerMTInstruction temp = new ServerMTInstruction();

			try {
				in.readInt();
				////parse messages into MTInstructions

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}// end while

	} // end process

}
