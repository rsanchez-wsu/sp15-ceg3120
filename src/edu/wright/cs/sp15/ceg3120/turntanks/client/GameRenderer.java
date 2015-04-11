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

package edu.wright.cs.sp15.ceg3120.turntanks.client;

import java.awt.*;

import javax.swing.*;

import edu.wright.cs.sp15.ceg3120.turntanks.GameInstance;

// ????? Pass tileSize from driver ?????

@SuppressWarnings("serial")
public class GameRenderer extends JPanel {
	
	private GameInstance gameInstance;
	
	private int mapXSize = 64;
	private int mapYSize = 64;
	private int xFov = 24;  //not used yet
	private int yFov = 16; //not used yet
	private int tileSize = 50;  //must be updated here and in driver
	private double[][] gradient;
	
	//temp fake constuctor
	public GameRenderer() {
		gameInstance = new GameInstance();
	}

	// TODO : Needs to be changed, need more parameters
	public GameRenderer(GameInstance instance) {
		this.gameInstance = instance;
	}
	
	private void fieldOfView(int x, int y, double grad) {
		double value = 0;
		//if(gradient[x][y] < .5) {
			char terrainType = gameInstance.gameMap.topLayer[x][y];
			if (terrainType == 't' || terrainType == 'h') {
				value = .2;
			} else if (terrainType == 'w' || terrainType == 'g' || terrainType == 'u') {
				value = .1;
			} else {
				value = 1;
			}
			System.out.println(value + " ");
			System.out.println(value + grad);
			if (grad + value < gradient[x][y] && grad + value < .5) {
				gradient[x][y] = grad + value;
				if (x > 0) {
					fieldOfView(x - 1, y, gradient[x][y]);
				}
				if (y > 0) {
					fieldOfView(x, y - 1, gradient[x][y]);
				}
				if (x < mapXSize - 1) {
					fieldOfView(x + 1, y, gradient[x][y]);
				}
				if (y < mapYSize - 1) {
					fieldOfView(x, y + 1, gradient[x][y]);
				}
				
			} else {
				gradient[x][y] = grad + value;
			}
				
		//}//end of if
	}
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		Image tile = null;
		gradient = new double[mapXSize][mapYSize];
		
		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapYSize; j++) {
				gradient[i][j] = 1;
				}
			}
		
		//create the FOV, will need to get what tank number the player is, currently just using tank 0
		gradient[gameInstance.tanks.get(0).xCoord][gameInstance.tanks.get(0).yCoord] = 0;
		int x = gameInstance.tanks.get(0).xCoord;
		int y = gameInstance.tanks.get(0).yCoord;
		if (x > 0) {
			fieldOfView(x - 1, y, 0);
		}
		if (y > 0) {
			fieldOfView(x, y - 1, 0);
		}
		if (x < mapXSize - 1) {
			fieldOfView(x + 1, y, 0);
		}
		if (y < mapYSize - 1) {
			fieldOfView(x, y + 1, 0);
		}
		
		// Draw terrain
		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapYSize; j++) {
				// Draw baseLayer
				tile = gameInstance.gameMap.getTerrain('a', gameInstance.gameMap.baseLayer[i][j], '\0');
				if(tile != null) {
					g2d.drawImage(tile, j * tileSize, i * tileSize, tileSize, tileSize, null);
				} else {//bad color
					g2d.setColor(Color.BLACK);
					g2d.fillRect(j * tileSize, i * tileSize, tileSize, tileSize);
				}
				
				// Draw TopLayer
				tile = gameInstance.gameMap.getTerrain('b', gameInstance.gameMap.topLayer[i][j], 
						gameInstance.gameMap.spriteStyle[i][j]);
				
				g2d.drawImage(tile, j * tileSize, i * tileSize, tileSize, tileSize, null);
				
				
				// Draw Corners
				tile = gameInstance.gameMap.getCorner(i, j);
				
				if(tile != null)
					g2d.drawImage(tile, j * tileSize, i * tileSize, tileSize, tileSize, null);
				
				//draw fog
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, (float)gradient[i][j]));
				g2d.fillRect(j * tileSize, i * tileSize, tileSize, tileSize);
			}
		}
		
		// Draw Tanks
		for (int i = 0; i < 7; i++) {
			//int x = 0;
			//int y = 0;
			x = gameInstance.tanks.get(i).xCoord;
			y = gameInstance.tanks.get(i).yCoord;
			g.drawImage(gameInstance.gameMap.getTank(i), x * tileSize, y * tileSize, tileSize, tileSize, null);
		}
		
	}

}
