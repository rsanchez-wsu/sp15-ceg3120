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
package edu.wright.cs.sp15.ceg3120.turntanks;

import java.awt.Point;

/**
 * Set up the Object for each player
 */
public class Player {

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
	private String ipAddr;
	private String tankPic;
	private int number;
	private int health;
	private Point location;
	private Status status;

	/**
	 * Default constructor
	 */
	public Player(int number, String name, String ipAddr) {
		this.number = number;
		this.name = name;
		this.ipAddr = ipAddr;
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
	 * Sets player name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets player name
	 */
	public String getName() {
		return name;
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
	 * Sets player IP address
	 */
	public void setPlayerIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	/**
	 * Gets player IP address
	 */
	public String getPlayerIpAddr() {
		return ipAddr;
	}
	
	/**
	 * Sets player's tank image location
	 */
	public void setPlayerTankPic(String tankPic) {
		this.tankPic = tankPic;
	}
	
	/**
	 * Gets player's tank image location
	 */
	public String getPlayerTankPic() {
		return tankPic;
	}

	@Override
	public String toString() {
		return ("<html>Player" + name + " (IP: " + ipAddr + ") | State: " + status.toString()
				+ " <br> Health: " + (health / 50) + "%" + " | Position: " + location.toString() 
				+ "<br><br><html>");
	}
}
