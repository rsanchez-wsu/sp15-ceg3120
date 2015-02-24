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

import java.awt.*;

import javax.swing.*;



	public class Game_Map extends JPanel{

	static JPanel gameMap = new JPanel(); //create the game map jPanel
		
	int rows = 64; //number of tiles down
	int cols = 64; //number of tiles across
	
	
	public void paintComponent(Graphics g){ //painting the tiles onto the panel
		super.paintComponent(g);
		g.clearRect(0, 0, getWidth(), getHeight());
		int tileSize = 20; //pixels for each tile
		int width = cols * tileSize; //width of the jPanel
		int height = rows * tileSize; //height of the jPanel
		int panelWidth = getWidth()/cols; //setting panel width
		int panelHeight = getHeight()/rows; //seting panel height
		
		//Dimension setPreferredSize = (new Dimension(width, height)); //set the preferred size of the jPanel
		
		for (int i=0; i<rows; i++){ //loop to paint rows of tiles
			for(int j=0; j<cols; j++){ //loop to paint cols of tiles
				int w = i*panelWidth; 
				int h = j*panelHeight;
				g.setColor(Color.DARK_GRAY); //color each tile dark gray
				g.fillRect(w,h,panelWidth,panelHeight); //fill the jPanel with tiles
			}
		}
		
	}
	
	public static void main(String[] args){
		gameMap.setVisible(true); //set the game map to visible
	}
}
