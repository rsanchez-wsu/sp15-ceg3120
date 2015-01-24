package team4;

import java.awt.Point;
	/**
	 * Basic outline for person class. edit as needed
	 * @author Brad
	 *
	 */
public class Person {
	public enum State {
		Waiting, Active, Dead
	}

	private String ipAdress;
	private int gameID;
	private int playerNumber;
	private int health;
	private Point ingamePosition;
	private State ingameState;

	public Person() {
		super();
	}

	public Person(String ipAdress, int gameID, int playerNumber, int health,
			Point ingamePosition, State ingameState) {
		super();
		this.ipAdress = ipAdress;
		this.gameID = gameID;
		this.playerNumber = playerNumber;
		this.health = health;
		this.ingamePosition = ingamePosition;
		this.ingameState = ingameState;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
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

	public Point getIngamePosition() {
		return ingamePosition;
	}

	public void setIngamePosition(Point ingamePosition) {
		this.ingamePosition = ingamePosition;
	}

	public State getIngameState() {
		return ingameState;
	}

	public void setIngameState(State ingameState) {
		this.ingameState = ingameState;
	}

	@Override
	public String toString() {
		return "Player " + playerNumber + " [IP=" + ipAdress + " ] Health : "
				+ health + "/50"+ " | Position=" + ingamePosition.toString()
				+ " | State : " + ingameState;
	}

}
