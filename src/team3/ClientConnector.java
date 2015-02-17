package team3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientConnector {

	Socket client;
	DataOutputStream toServer;
	DataInputStream fromServer;
	
	//creates a ClientConnector
	public ClientConnector(String name, int port) {
		try {
			client = new Socket(name, port);
			toServer = new DataOutputStream(client.getOutputStream());
			fromServer = new DataInputStream(client.getInputStream());
		}//end of try
		catch(Exception e) {
			System.err.println("ERROR: could not connect to port " + port);
		}//end of catch
	}//end of constructor
	
	//sends a message to the server
	public void sendMessage(String message) {
		try {
		toServer.writeUTF(message);
		}//end of try
		catch(Exception e) {
			System.err.println("ERROR: could not send message to port " + client.getPort());
		}//end of catch
	}//end of sendMessage
	
	//receives a message from the server
	public String recieveMessage() {
		try {
			return fromServer.readUTF();
		}//end of try
		catch(Exception e) {
			System.err.println("ERROR: could not recieve message from port " + client.getPort());
		}//end of catch
		return null;
	}//end of recieveMessage
}//end of class
