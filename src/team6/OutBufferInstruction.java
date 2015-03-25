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
	//TODO this class should be changed so that the constructor type sets the type value, instead of being passed.
	

	int type =-1; //0 is welcome, 1 is players present, 2 is tank move, 3 is terrain message
	int playerNumber=-1;
	int x;
	int y;
	//current used map type+ renderer requires these 4 values
	char base;
	char top;
	char style;
	char corner;
	
	String playerName="none";

	public OutBufferInstruction(int type, int playerNumber, String playerName) {//should be type 1
		super();
		this.type = type;
		this.playerNumber = playerNumber;
		this.playerName = playerName;
		System.out.println("debug out instruction created. type= "+ type +" playerNumber= "+playerNumber+ " playername= "+ playerName );
	}
	
	public OutBufferInstruction(int type, int playerNumber, int x, int y) {//should be type 2 tank move message constructor
		
		this.type = type;
		this.playerNumber=playerNumber;
		this.x=x;
		this.y=y;				
		
		System.out.println("debug out instruction created. type= "+ type +" playerNumber= "+playerNumber+ " cords "+ x+", "+y );
		
	}
	
	public OutBufferInstruction(int type,  char base, char top, char style, char corner) {//should be type 3 terrain message constructor
		super();
		this.type = type;
		this.playerNumber = -1;
		this.playerName = "";
		this.base=base;
		this.top=top;
		this.style=style;
		this.corner=corner;
		System.out.println("debug out instruction created. type= "+ type + "base-top-style-corner"+base+top+style+corner );
	}
	

	

}

