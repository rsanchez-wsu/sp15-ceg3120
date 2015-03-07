package team6;
import java.util.concurrent.*;

// This class isnt complete yet; eventually, you will pass it a Game Instance object and it will: 
// run a thread of a socket server, that creates threads out of socket connections
// keep references to all socket threads
// keep a thread safe data structure buffer, which will contain actions from parsed inbound messages
// keep a buffer of messages that need to be sent outbound to specific sockets
// have a main loop which completes the next tasks waiting in the inbound and outbound buffers
// For now, exceptions will just be printed
public class ServerMT {
	
	static ConcurrentLinkedQueue inBuffer = new ConcurrentLinkedQueue<ServerMTInstruction>();	
	static ConcurrentLinkedQueue outBuffer = new ConcurrentLinkedQueue<String>();
	ServerMTSockListen listener = new ServerMTSockListen();
	GameInstance currentGame;
	
	
	
	public ServerMT(GameInstance game){		
	Thread thread = new Thread(listener);
	thread.start();
	ServerMTInstruction temp = new ServerMTInstruction(0,  20,  20, "fucku", 0, -1);
	inBuffer.add(temp);
	currentGame=game;
	}//end constructor
	
	public void step(){

		
		
		if (!inBuffer.isEmpty())
			
		inProcess((ServerMTInstruction) inBuffer.remove());
		
		//-parse inBuffer, take action on gameInstance
		////-detect new terrain to send to tank that moved
		////-check and see if anytanks can see moved tank
		////generate tank position messages to send to those tanks
		
	}
	
	
	
	private void inProcess(ServerMTInstruction temp) {		
		
		switch (temp.type) {   
		case 0:  System.out.println("MT processing tank move");
		//check to see if tank is only moving 1 sq
		validateMove(temp);
		
		break;
        case 1:  System.out.println("MT processing tank attack");break;
        case 2:  System.out.println("MT processing chat"); break;

        default: break;
    }
		
		
		
		
	}//end serverMTInstruction
	
	private void validateMove(ServerMTInstruction temp){
		
		
		
		
	}

	private void validateAttack(ServerMTInstruction temp){
		
		
		
		
	}
	
	


	
	
	
	
	
	
	

}//end class
