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

package team6;

import java.util.*;

//This class represents the state of 8 tanks in a game. It could
//represent the history of a past game, or a on going game.
//
public class GameInstance {

	public Calendar time;	
	public ArrayList<TankObject> tanks = new ArrayList<TankObject>();
	public GameMap gameMap = new GameMap();

	public GameInstance() {
		time = Calendar.getInstance();
		for (int i = 0; i < 8; i++) {
			tanks.add(new TankObject("red.jpg", "noName", "noIP", 0, 0, 50,
					"waiting"));
		}// end for
		
		gameMap = new GameMap();
	}
	
	// creates a gameinstance from a arraylist of tanks
	public GameInstance(Calendar time, GameMap gameMap) {
		
		for (int i = 0; i < 8; i++) {
			tanks.add(new TankObject("red.jpg", "noName", "noIP", 2, 2, 50,
					"waiting"));
		}// end for
		
		this.time = time;
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
