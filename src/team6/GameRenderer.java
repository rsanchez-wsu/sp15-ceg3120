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

import java.awt.*;
import javax.swing.*;

//This class will render a 64x64 array representing a map, and a array
//of TankObjects, representing players.

//will update to render only 24x16 squares at a time, scrollable through arrowkeys.

// ????? Pass tileSize from driver ?????

@SuppressWarnings("serial")
public class GameRenderer extends JPanel {
	
	GameMap gameMap;
	
	int mapXSize = 64;
	int mapYSize = 64;
	
	GameInstance players;
	int xFov = 24;  //not used yet
	int yFov = 16; //not used yet
	int tileSize = 50;  //must be updated here and in driver
	
	public GameRenderer() {
		
		gameMap = new GameMap();
		players = new GameInstance(); //temp fake constructor
	}

	// TODO : Needs to be changed, need more parameters
	public GameRenderer(char[][] map, GameInstance players) {
		gameMap.topLayer = map;
		this.players = players;
	}
	
	// @override
	public void paint(Graphics g) {
		
		Image tile = null;
		
		// Draw baseLayer
		for (int i = 0; i < mapXSize; i++){
			for (int j = 0; j < mapYSize; j++){
		
				tile = gameMap.getTerrain(gameMap.baseLayer[i][j], ' ');
				g.drawImage(tile, i * tileSize, j * tileSize, tileSize, tileSize, null);
			}
		}
		
		// Draw topLayer
		for (int i = 0; i < mapXSize; i++){
			for (int j = 0; j < mapYSize; j++){
				
				tile = gameMap.getTerrain(gameMap.topLayer[i][j], gameMap.spriteStyle[i][j]);

				if(tile != null)
					g.drawImage(tile, i * tileSize, j * tileSize, tileSize, tileSize, null);
				else{//bad color
					g.setColor(Color.BLACK);
					g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
				}
			}
		}// end for loop
		
		/*
		 * Demo for corners issue.
		g.drawImage(gameMap.waterBM, 10 * tileSize, 10 * tileSize, tileSize, tileSize, null);
		g.drawImage(gameMap.waterBR, 9 * tileSize, 11 * tileSize, tileSize, tileSize, null);
		g.drawImage(gameMap.waterMM, 9 * tileSize, 10 * tileSize, tileSize, tileSize, null);
		g.drawImage(gameMap.waterCBR, 9 * tileSize, 10 * tileSize, tileSize, tileSize, null);
		*/
		
		// Draw Tanks
		for (int i = 0; i < 7; i++){
			int x = 0;
			int y = 0;
			x = players.tanks.get(i).xCoord;
			y = players.tanks.get(i).yCoord;
			g.drawImage(gameMap.getTank(i), x * tileSize, y * tileSize, tileSize, tileSize, null);
		}
		
	}// end paint()

}// end GameRenderer Class
