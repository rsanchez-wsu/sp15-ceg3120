/*
 * License tbd
 * @author hitchens6
 */
package team5.PlayerObject;


public class Player {

	// Player Variables
	final int totalHealth = 50;
	private String serverIP;
	private String status;
	public enum State {DEAD, ALIVE, WAITING};
	State state;
	private int health;
	private int playersLeft;
	private int playerNumber;
	private Pair position;

	// Default Constructor
	public Player() {

	}

	// Player Constructor
	public Player(String serverIP, String status, int playersLeft,
			int playerNumber, int health, Pair position, State state) {

		this.serverIP = serverIP;
		this.status = status;
		this.playersLeft = playersLeft;
		this.setPlayerNumber(playerNumber);
		this.health = health;
		this.position = position;
		this.state = State.WAITING;
	}

	@Override
	public String toString() {
		return "Game Info - Status: " + getStatus() + " | Server: "
				+ getServerIP() + " | Players left: " + getPlayersLeft()
				+ "\n " + "My Info - #: " + getPlayerNumber() + " | Health: "
				+ getHealth() + "/" + getTotalHealth() + " | Position: "
				+ getPosition().toString() + " | State: " + getState();

	}

	// Getters and Setters

	public int getTotalHealth() {
		return totalHealth;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = State.DEAD;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getPlayersLeft() {
		return playersLeft;
	}

	public void setPlayersLeft(int playersLeft) {
		this.playersLeft = playersLeft;
	}

	public Pair getPosition() {
		return position;
	}

	public void setPosition(Pair position) {
		this.position = position;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
}
