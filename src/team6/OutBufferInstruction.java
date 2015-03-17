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

public class OutBufferInstruction {
	
	

	int type =-1; //0 is welcome, 1 is players present
	int playerNumber=-1;
	String playerName="none";

	public OutBufferInstruction(int type, int playerNumber, String playerName) {
		super();
		this.type = type;
		this.playerNumber = playerNumber;
		this.playerName = playerName;
		System.out.println("out instruction created");
	}
	
	

}

