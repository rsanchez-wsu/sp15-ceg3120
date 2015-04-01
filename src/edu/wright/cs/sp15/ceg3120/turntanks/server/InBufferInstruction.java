/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 *  Copyright (C) <2015>  <Team 6>
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

package edu.wright.cs.sp15.ceg3120.turntanks.server;
//this class represents instructions that will sit in the concurrent queue, to be processed by
//Engine.  Likely created by a MTSock parsing a network message that was parsed.
public class InBufferInstruction {

	public int type; //-1 is no instruction(if read from stream, nothing else will be parsed),0 is move, 1 is attack, 2 is chat, 3 is player name(handshake message)
	public int sourceID; //the id of the tank/thread, lets try and make it the same list position
	public int x=-1; // position moving to, or attacking 
	public int y=-1; //
	public String message="empty";// used for chat(2) and name (3)
	public int destID=-1;
	
	public InBufferInstruction(){}
	
	public InBufferInstruction(int type,  int x, int y, String message, int sourceID, int destID){
		
		this.type=type;		
		this.x=x;
		this.y=y;
		this.message=message;
		this.sourceID=sourceID;
		this.destID=destID;
	}//end conts
	
}
