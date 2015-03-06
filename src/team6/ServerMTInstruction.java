package team6;
//this class represents instructions that will sit in the concurrent queue, to be processed by
//ServerMT.  Likely created by a MTSock parsing a network message that was parsed.
public class ServerMTInstruction {

	public int type; //-1 is no instruction(if read from stream, nothing else will be parsed),0 is move, 1 is attack, 2 is chat
	public int sourceID; //the id of the tank/thread, lets try and make it the same list position
	public int x=-1; // position moving to, or attacking 
	public int y=-1; //
	public String message="empty";// used for chat 
	public int destID=-1;
	
	public ServerMTInstruction(){}
	
	public ServerMTInstruction(int type,  int x, int y, String message, int sourceID, int destID){
		
		this.type=type;		
		this.x=x;
		this.y=y;
		this.message=message;
		this.sourceID=sourceID;
		this.destID=destID;
	}//end conts
	
}
