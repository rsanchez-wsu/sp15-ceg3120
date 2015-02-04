/*
 *  Copyright (C) <2015>  <Brad Reynolds> - reynolds.0345@gmail.com
 *  					 ADD names/emails here
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
package team4;

import java.awt.Point;

/**
 * Basic outline for person class. edit as needed
 * 
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

	public String getLocationString() {
		return "(" + ingamePosition.x + ", " + ingamePosition.y + ")";
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

	public Object[] getModelPlayerObject() { //Returns the object array of values useful for JTable.
		Object[] returnThis = { this.getIpAdress(), this.getGameID(),
				this.getPlayerNumber(), this.getHealth(),
				this.getLocationString(), this.getIngameState() };
		return returnThis;
	}

	@Override
	public String toString() {
		return "Player " + playerNumber + " [IP=" + ipAdress + " ] Health : "
				+ health + "/50" + " | Position=" + ingamePosition.toString()
				+ " | State : " + ingameState;
	}

}
