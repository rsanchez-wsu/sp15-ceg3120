/*
 *  Copyright (C) <2015>  Marie Hucke, Kristen Schwaiger, Kyle Wintermute, Kyle Wood
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
 
package team1;

import java.math.*;

public class Player
{
	
	private int health;
	private int[] position;
	private String name;
	private PLAYER_STATUS status;
	
	public Player()
	{
		health = 50;
		position = new int[2];
		status = PLAYER_STATUS.ALIVE;
		name = randomNameGenerator();
	}
	
	public Player(String name)
	{
		health = 50;
		position = new int[2];
		status = PLAYER_STATUS.ALIVE;
		this.name = name;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int[] getPosition()
	{
		return position;
	}
	
	public void setHealth(int newHealth)
	{
		health = newHealth;
	}
	
	public void setPosition(int[] newPosition)
	{
		position = newPosition;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPlayerStatus(PLAYER_STATUS newStatus)
	{
		status = newStatus;
	}
	
	public PLAYER_STATUS getPlayerStatus()
	{
		return status;
	}
	
	public String randomNameGenerator()
	{
		int stringLength = (int) (Math.random() % 6) + 1;
		
		String newName = "Bob";
		
		for(int i = 0; i < stringLength; i++){
			char rand = 65;
	        rand += (int)Math.random() % 25;
	        newName += rand;
		}
		return newName;
	}
	
}
