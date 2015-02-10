/*
 *  Copyright (C) <2015>  <Brad Reynolds> - reynolds.0345@gmail.com
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
package team4;

import java.util.Calendar;
import java.util.Date;

public class Game {

	public enum State {
		Active, Inactive
	};

	private State gameStatus;
	private Person[] playerList;
	private Date dateStart;
	private Date dateEnd;
	private Person winningPlayer;
	private int gameNumber;

	public Game() {
		super();
	}

	public Game(int gameNumber, State gameStatus, Person[] playerList,
			Date dateStart, Date dateEnd, Person winningPlayer) {
		super();
		this.gameNumber = gameNumber;
		this.gameStatus = gameStatus;
		this.playerList = playerList;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.winningPlayer = winningPlayer;
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

	public Person[] getPlayerList() {
		return playerList;
	}

	public void setPlayerList(Person[] playerList) {
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

	public Person getWinningPlayer() {
		return winningPlayer;
	}

	public void setWinningPlayer(Person winningPlayer) {
		this.winningPlayer = winningPlayer;
	}

	public Object[][] getObjectPlayerData() {
		Object[][] playerObjectModel = new Object[playerList.length][];
		for (int i = 0; i < playerList.length; i++) {
			playerObjectModel[i] = playerList[i].getModelPlayerObject();
		}
		return playerObjectModel;
	}

	@Override
	public String toString() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateEnd);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		return "[" + gameStatus + "][" + day + "/" + month + "/" + year
				+ "][Game " + gameNumber + "]";
	}

}
