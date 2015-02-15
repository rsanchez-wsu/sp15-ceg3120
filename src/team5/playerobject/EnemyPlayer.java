/*
 *  Copyright (C) <2015>  <Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker>
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
package team5.playerobject;


public class EnemyPlayer extends Player{

	private Pair position = null;
	
	// Default Constructor
		public EnemyPlayer() {

		}

		// Player Constructor
		public EnemyPlayer(int playerNumber, int health, Pair position, State state) {
			super();
			this.setPlayerNumber(playerNumber);
			this.position = position;
		}
		
		public Pair getPosition(){
			return position;
		}
		public void setPosition(Pair position){
			this.position = position;
		}
		
		@Override
		public String toString(){
			return "Enemy - #: " + getPlayerNumber() + " | Health: " + getHealth() + "/50 | Position "
					+ getPosition() + " | State: " + getState();
		}
		
		public String printPosition(){
			if (getPosition() == null)
			{
				return "<html>Player " + getPlayerNumber() + "<br>" + "Last Seen: NEVER </html>";

			}
			return "<html>Player " + getPlayerNumber() + "<br>" + "Last Seen: " + getPosition() + "</html>";
			
		}
		
		
}
