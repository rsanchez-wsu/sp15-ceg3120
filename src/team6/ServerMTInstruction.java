package team6;
//this class represents instructions that will sit in the concurrent queue, to be processed by
//ServerMT.  Likely created by a MTSock parsing a network message that was parsed.
public class ServerMTInstruction {

	public int type; //0 is move, 1 is attack, 2 is chat
	public int id; //the id of the tank/thread, lets try and make it the same list position
	public int x; // position moving to, or attacking 
	public int y; //
	public String message;// used for chat 
	
	
}
