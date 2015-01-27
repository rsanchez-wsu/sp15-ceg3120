/*
 *  Copyright (C) <year>  <name of author>
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
package team5.PlayerObject;

/**
 * @author hitchens6
 */
public class Pair {
	// Pair Variables
	private int xPos;
	private int yPos;

	// Defualt Constructor
	public Pair() {

	}

	// Position Constructor
	public Pair(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	// getters and setters
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	@Override
	public String toString() {
		return "(" + getxPos() + ", " + getyPos() + ")";
	}
}
