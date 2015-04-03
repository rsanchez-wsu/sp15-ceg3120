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
package team5.client;

/**
 * @author Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker
 */
public class GameStatus {

	public enum StatusEnum {
		IN_PROGRESS, COMPLETED, WAITING
	}

	private int playersLeft;

	private String serverIP;

	private StatusEnum status;

	// GameStatus Constructor
	public GameStatus() {

	}

	/**
	 * sets game status per player
	 * @param serverIP
	 * @param playersLeft
	 * @param status
	 */
	public GameStatus(String serverIP, int playersLeft, StatusEnum status) {

		this.serverIP = serverIP;
		this.playersLeft = playersLeft;
		this.status = status;
	}

	
	@Override
	public String toString() {
		String status = "";

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
				+ " | Players left: " + getPlayersLeft() + "\n ";
	}
	
	public StatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;

	}

	public int getPlayersLeft() {
		return playersLeft;
	}

	public void setPlayersLeft(int playersLeft) {
		this.playersLeft = playersLeft;
	}
}
