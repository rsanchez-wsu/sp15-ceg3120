package team2;
/*
 * Copyright (C) <2015> <Team 2>
 * 
 * Will Hatfield
 * Kevin Alig
 * Alyssa Ramsey
 * Anthony Lamping
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */

//Associated with ServerListen and ServerClient......
// coded an idea... not sure exactly if it'll work like I think it will.
// has issues with input and exiting nicely.
// needs work

//This is a temp class to test ServerListen and ServerClient classes
public class Server {

	public static void main(String[] args) {

		try {
			@SuppressWarnings("unused")
			ServerListen test = new ServerListen();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
