/*
 * Copyright (C) 2015 - Matthew Nelson, Jason Gonzalez, Josh Crank, Marie Hucke, Kristen Schwaiger, Kyle Wintermute, Kyle Wood, Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker, and Matthew J Lents. 
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

import java.awt.Point;

/**
 * Set up the Object for each player
 */
public class Player {

	// Variable declarations
	public enum Status {

		ACTIVE, DEAD, WAITING;

		@Override
		public String toString() {
			String result = super.toString();
			result = result.substring(0, 1).toUpperCase()
					+ result.substring(1).toLowerCase();
			return result;
		}
	}
	
	private String name;
	private int number;
	private Status status;
	private int health;
	private Point location;
	private Point lastSeenLocation;
	
	// TODO: Consider how to get the IP address into here

	/**
	 * Default constructor
	 *
	 */
	public Player(int number, String name) {
		this.number = number;
		this.name = name;
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
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the player name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Sets player health, if less than or equal to 0 sets status to dead
	 */
	public void setPlayerHealth(int health) {
		if (health <= 0) {
			this.health = 0;
			this.status = Status.DEAD;
		}
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
	public void setPlayerLocation(Point location) {
		this.location = location;
	}

	/**
	 * Gets player location
	 */
	public Point getPlayerLocation() {
		return location;
	}

	/**
	 * Sets last seen player location
	 */
	public void setLastSeenPlayerLocation(Point lastSeenLocation) {
		this.lastSeenLocation = lastSeenLocation;
	}

	/**
	 * Gets last seen player location
	 */
	public Point getLastSeenPlayerLocation() {
		return lastSeenLocation;
	}
	
	/**
	 * Gets the players x coordinate
	 */
	public int getxPosition(){
		return location.x;
	}
	
	/**
	 * Sets the players x coordinate
	 */
	public void setxPosition(int xPosition){
		location.x = xPosition;
	}
	
	/**
	 * Gets the players y coordinate
	 */
	public int getyPosition(){
		return location.y;
	}
	
	/**
	 * Sets the players y coordinate
	 */
	public void setyPosition(int yPosition){
		location.y = yPosition;
	}

	@Override
	public String toString() {
		return "My info - #: " + getPlayerNumber() + " | Health: "
				+ getPlayerHealth() + "/50 | Position " + getPlayerLocation()
				+ " | State: " + status.toString();
	}
}
