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

public class Player
{
	
	private int health;
	private int[] position;
	
	public Player()
	{
		health = 50;
		position = new int[2];
	}
	
	public void attack()
	{
		
	}

	public void move()
	{
		
	}
	
	public void pass()
	{
		
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
	
}
