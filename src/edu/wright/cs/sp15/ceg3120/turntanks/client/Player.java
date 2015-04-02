/*
 * Copyright (C) 2015 - Jason Gonzalez, Josh Crank, Marie Hucke, Kristen Schwaiger, Kyle Wintermute, Kyle Wood, Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker, and Matthew J Lents. 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package edu.wright.cs.sp15.ceg3120.turntanks.client;

/**
 * Set up the Object for each player
 */
public class Player {

	// Variable declarations
	private int number;

	public enum Status {

		ALIVE, DEAD, WAITING
	}

	private Status status;
	private int health;
	private Pair location;
	private Pair lastSeenLocation;

	/**
	 * Default constructor
	 *
	 */
	public Player(int number) {
		this.number = number;
		this.health = 50;
	}

	/**
	 * Sets player number
	 */
	public void setPlayerNumber(int number) {
		this.number = number;
	}

	/**
	 * Gets player number
	 */
	public int getPlayerNumber() {
		return number;
	}

	/**
	 * Sets player status
	 */
	public void setPlayerStatus(Status status) {
		this.status = status;
	}

	/**
	 * Gets player status
	 */
	public Status getPlayerStatus() {
		return status;
	}

	/**
	 * Sets player health
	 */
	public void setPlayerHealth(int health) {
		this.health = health;
	}

	/**
	 * Gets player health
	 */
	public int getPlayerHealth() {
		return health;
	}

	/**
	 * Sets player location
	 */
	public void setPlayerLocation(Pair location) {
		this.location = location;
	}

	/**
	 * Gets player location
	 */
	public Pair getPlayerLocation() {
		return location;
	}

	/**
	 * Sets last seen player location
	 */
	public void setLastSeenPlayerLocation(Pair lastSeenLocation) {
		this.lastSeenLocation = lastSeenLocation;
	}

	/**
	 * Gets last seen player location
	 */
	public Pair getLastSeenPlayerLocation() {
		return lastSeenLocation;
	}
	@SuppressWarnings("incomplete-switch") // Warning suppressed due to the fact that Status must be one of these 3 items.
	@Override
	public String toString() {
		String state = "";

		switch (getPlayerStatus()) {
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
		return "My info - #: " + getPlayerNumber() + " | Health: " + getPlayerHealth() + "/50 | Position "
			+ getPlayerLocation() + " | State: " + state;
	}
}