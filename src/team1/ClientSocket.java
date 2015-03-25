/*
 *  Copyright (C) <2015>  Marie Hucke, Kristen Schwaiger, Kyle Wintermute, Kyle Wood
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

package team1;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientSocket implements Runnable{
	Socket client;
	DataInputStream dataInStream;
	DataOutputStream dataOutStream;
	Scanner keyboard = new Scanner(System.in);
	
	@Override
	public void run(){
		
	}
	
	public ClientSocket(){
		try{
			//System.out.print("Please enter the game server IP: ");
			
			client = new Socket("localhost", 7777);
			dataInStream = new DataInputStream(client.getInputStream());
			dataOutStream = new DataOutputStream(client.getOutputStream());
			
		} catch(Exception e){
			System.out.println("ERROR: " + e.toString());
			
		}
		
	}
	
	public void sendMessage(String s){
		try{
			dataOutStream.writeUTF(s);
		}catch(IOException e){
			System.out.println("ERROR: " + e.toString());
		}
	}
	
	public String recMessage(){
		String s = "";
		try{
			s = dataInStream.readUTF();
		}catch(IOException e){
			System.out.println("ERROR: " + e.toString());
		}
		return s;
	}
	
}
