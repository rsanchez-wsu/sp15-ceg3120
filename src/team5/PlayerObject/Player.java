/*
 *  Copyright (C) <2015>  <Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker>
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
package team5.PlayerObject;

/**
 * @author Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker
 */
public class Player {

	// Player Variables
	final int totalHealth = 50;
	private String serverIP;

	public enum Status {
		IN_PROGRESS, COMPLETED, WAITING
	};

	private Status status;

	public enum State {
		DEAD, ALIVE, WAITING
	};

	private State state;
	private int health;
	private int playersLeft;
	private int playerNumber;
	private Pair position;

	// Default Constructor
	public Player() {

	}

	// Player Constructor
	public Player(String serverIP, Status status, int playersLeft,
			int playerNumber, int health, Pair position, State state) {

		this.serverIP = serverIP;
		this.status = status;
		this.playersLeft = playersLeft;
		this.setPlayerNumber(playerNumber);
		this.health = health;
		this.position = position;
		this.state = state;
	}

	@Override
	public String toString() {
		String state = "";
		String status = "";

		switch (getState()) {
		case DEAD:
			state = "Dead";
			break;
		case ALIVE:
			state = "Alive";
			break;
		case WAITING:
			state = "Waiting";
			break;
		}

		switch (getStatus()) {
		case IN_PROGRESS:
			status = "In Progress";
			break;
		case COMPLETED:
			status = "Completed";
			break;
		case WAITING:
			status = "Waiting";
			break;
		}

		return "Game Info - Status: " + status + " | Server: " + getServerIP()
				+ " | Players left: " + getPlayersLeft() + "\n "
				+ "My Info - #: " + getPlayerNumber() + " | Health: "
				+ getHealth() + "/" + getTotalHealth() + " | Position: "
				+ getPosition().toString() + " | State: " + state;

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

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
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
