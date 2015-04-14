/*
 *  Copyright (C) <2015>  Team 4
 *  					<Brad Reynolds> - reynolds.0345@gmail.com
 *  					 <Benjamin Hansen> - hansen.21@wright.edu
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
package edu.wright.cs.sp15.ceg3120.turntanks;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Generic class for game. Modified to work with Player and GameMap.
 * 
 * @author Team 4
 *
 */
public class Game implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum State {
		Active, Inactive
	}

	private State gameStatus;
	private ArrayList<Player> playerList;
	private Date dateStart;
	private Date dateEnd;
	private Player winningPlayer;
	private int gameNumber;
	private GameMap gameMap;

	
	public Game() {
		super();
	}

	public Game(int gameNumber, State gameStatus, ArrayList<Player> playerList,
			Date dateStart, Date dateEnd, Player winningPlayer, GameMap gameMap) {
		super();
		this.gameNumber = gameNumber;
		this.gameStatus = gameStatus;
		this.playerList = playerList;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.winningPlayer = winningPlayer;
		this.gameMap = gameMap;
	}

	public GameMap getGameMap() {
		return gameMap;
	}

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

	public State getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(State gameStatus) {
		this.gameStatus = gameStatus;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Player getWinningPlayer() {
		return winningPlayer;
	}

	public void setWinningPlayer(Player winningPlayer) {
		this.winningPlayer = winningPlayer;
	}

	/**
	 * Print Data about game time and day
	 * Might be useful for serverside representation
	 */
	public String datePlayed() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		return "[" + gameStatus + "][" + df.format(dateEnd)
				+ "][Game " + gameNumber + "]";
	}
	
}
