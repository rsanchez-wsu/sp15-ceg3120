package team4;

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

}
