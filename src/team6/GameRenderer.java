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

// ????? Pass tileSize from driver ?????

@SuppressWarnings("serial")
public class GameRenderer extends JPanel {
	
	GameInstance gameInstance;
	
	int mapXSize = 64;
	int mapYSize = 64;
	int xFov = 24;  //not used yet
	int yFov = 16; //not used yet
	int tileSize = 50;  //must be updated here and in driver
	
	//temp fake constuctor
	public GameRenderer() {
		gameInstance = new GameInstance();
	}

	// TODO : Needs to be changed, need more parameters
	public GameRenderer(GameInstance instance) {
		this.gameInstance = instance;
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		Image tile = null;
		
		// Draw terrain
		for (int i = 0; i < mapXSize; i++){
			for (int j = 0; j < mapYSize; j++){
		
				// Draw baseLayer
				tile = gameInstance.gameMap.getTerrain(gameInstance.gameMap.baseLayer[i][j], ' ');
				
				if(tile != null)
					g.drawImage(tile, j * tileSize, i * tileSize, tileSize, tileSize, null);
				else{//bad color
					g.setColor(Color.BLACK);
					g.fillRect(j * tileSize, i * tileSize, tileSize, tileSize);
				}
				
				// Draw TopLayer
				tile = gameInstance.gameMap.getTerrain(gameInstance.gameMap.topLayer[i][j], 
						gameInstance.gameMap.spriteStyle[i][j]);
				if(tile != null)
					g.drawImage(tile, j * tileSize, i * tileSize, tileSize, tileSize, null);
				else{//bad color
					g.setColor(Color.BLACK);
					g.fillRect(j * tileSize, i * tileSize, tileSize, tileSize);
				}
				
				// Draw Corners
				tile = gameInstance.gameMap.getCorner(i, j);
				
				if(tile != null)
					g.drawImage(tile, j * tileSize, i * tileSize, tileSize, tileSize, null);
					
			}
		}// end for loop
		
		// Draw Tanks
		for (int i = 0; i < 7; i++){
			int x = 0;
			int y = 0;
			x = gameInstance.tanks.get(i).xCoord;
			y = gameInstance.tanks.get(i).yCoord;
			g.drawImage(gameInstance.gameMap.getTank(i), x * tileSize, y * tileSize, tileSize, tileSize, null);
		}
		
	}// end paint()

}// end GameRenderer Class
