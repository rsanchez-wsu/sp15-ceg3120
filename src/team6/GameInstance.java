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
	
	//public all the things	
	public 	Calendar time;
	public ArrayList<TankObject> tanks= new ArrayList(); 
	
	//default test constructor
	public GameInstance(){
		time= time.getInstance();
			
        tanks.add( new TankObject("green.jpg", "Matt", "178.224.102.99",
                12, 34, 40, 45, "wait"));
        tanks.add( new TankObject("green.jpg", "Jeff", "211.87.23.81",
                44, 12, 10, 55, "wait"));
        tanks.add( new TankObject("green.jpg", "Gary", "73.23.144.17",
                55, 27, 20, 74, "wait"));
        tanks.add( new TankObject("green.jpg", "Stu", "141.55.12.201",
                14, 12, 0, 102, "dead"));
        tanks.add( new TankObject("green.jpg", "Jill", "51.122.77.2",
                11, 47, 15, 82, "wait"));
        tanks.add( new TankObject("green.jpg", "Kent", "134.11.3.210",
                33, 22, 35, 102, "wait"));
        tanks.add( new TankObject("green.jpg", "Scot", "178.224.102.99",
                24, 22, 60, 10, "wait"));
        tanks.add( new TankObject("red.jpg", "xXKi113R69Xx", "192.168.1.1",
                99, 99, 65535, 65535, "Active"));
	}
	
	
	//creates a gameinstance from a arraylist of tanks
	public GameInstance(ArrayList<TankObject> tanks, Calendar time){
		this.time=time;
		this.tanks=tanks;
	}

	public void add(TankObject player){
		tanks.add(player);
		
	}
}
