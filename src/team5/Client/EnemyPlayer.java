package team5.Client;

import team5.PlayerObject.Pair;
import team5.PlayerObject.Player;

public class EnemyPlayer extends Player{

	private Pair position = null;
	
	// Default Constructor
		public EnemyPlayer() {

		}

		// Player Constructor
		public EnemyPlayer(int playerNumber, int health, Pair position, State state) {
			super();
			this.setPlayerNumber(playerNumber);
			this.position = position;
		}
		
		public Pair getPosition(){
			return position;
		}
		public void setPosition(Pair position){
			this.position = position;
		}
		
		
}
