/*
 *  Copyright (C) <2015>  
 *  Josh Crank - crank.5@wright.edu
 *  // Aditional People
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

package team7;

public class Player {
	String name;
	int maxHealth = 50;
	int dmgTaken = 0;
	int posX;
	int posY;
	int state = 1; // 1: active, 2: wait, 3: dead
	int playerNum;
	
	public Player(String name, int x, int y)
	{
		this.name = name;
		this.posX = x;
		this.posY = y;
	}

	//(JTC) Getters and Setters
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getMaxHealth()
	{
		return maxHealth;
	}

	public int getDmgTaken()
	{
		return dmgTaken;
	}

	public void takeDmg(int dmgTaken)
	{
		this.dmgTaken += dmgTaken;
	}

	public int getPosX()
	{
		return posX;
	}

	public void setPosX(int posX)
	{
		this.posX = posX;
	}

	public int getPosY()
	{
		return posY;
	}

	public void setPosY(int posY)
	{
		this.posY = posY;
	}

	public int getState()
	{
		return state;
	}

	public void setState(int state)
	{
		this.state = state;
	}

	public int getPlayerNum(){
		return playerNum;
	}	
		
	public void setPlayerNum(int playerNum)	{
		this.playerNum = playerNum;
	}
	
}

