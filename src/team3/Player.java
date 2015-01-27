package team3;
import java.awt.Point;

public class Player {
	
	private int playerNumber;
	private int health;
	private Point location;
	private Point[] seen;
	
	public Player(int playerNumber){
		this.playerNumber = playerNumber;
		health = 50;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Point[] getSeen() {
		return seen;
	}

	public void setSeen(Point[] seen) {
		this.seen = seen;
	}
	

}
