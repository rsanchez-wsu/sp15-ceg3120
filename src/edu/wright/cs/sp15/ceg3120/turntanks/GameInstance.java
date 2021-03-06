/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 *  Copyright (C) <2015>  <Team 6>
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

import java.util.ArrayList;
import java.util.Calendar;

//This class represents the state of 8 tanks in a game. It could
//represent the history of a past game, or a on going game.
//
public class GameInstance {

	
	public Calendar timeGameStarted;
	public Calendar timeTurnStarted;
	public int activePlayer=0;
	public ArrayList<TankObject> tanks = new ArrayList<>();
	public GameMap gameMap = new GameMap();
	

	public GameInstance() {
		timeGameStarted = Calendar.getInstance();
		for (int i = 0; i < 8; i++) {
			tanks.add(new TankObject("red.jpg", "noName", "noIP", 0, 0, 50,
					"waiting"));
		}
		
		gameMap = new GameMap();
	}
	
	// creates a gameinstance from an arraylist of tanks
	public GameInstance(Calendar time, GameMap gameMap) {
		
		for (int i = 0; i < 8; i++) {
			tanks.add(new TankObject("red.jpg", "noName", "noIP", 2, 2, 50,
					"waiting"));
		}
		
		this.timeGameStarted = time;
		this.gameMap = gameMap;
	}

	public void add(TankObject player) {
		tanks.add(player);

	}

	public TankObject[] getAllTanks() {
		TankObject[] returnArr = new TankObject[tanks.size()];
		for (int i = 0; i < returnArr.length; i++) {
			returnArr[i] = tanks.get(i);
		}
		return returnArr;
	}

}
