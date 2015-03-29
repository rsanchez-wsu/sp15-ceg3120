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

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.util.Calendar;

//This class just creates a frame, and adds what ever panel we are testing
public class driverServer {

	int mapXSize = 64;
	int mapYSize = 64;
	int tileSize = 50;
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {

		GameMap currentMap = new GameMap();
		currentMap.generateMap();
		GameInstance currentGame = new GameInstance(Calendar.getInstance(), currentMap);
		
		JFrame gameFrame = new JFrame("game GUI Demo");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		center(gameFrame);

		// renderer section
		GameRenderer renderer = new GameRenderer(currentGame) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(mapXSize * tileSize, mapYSize * tileSize);
			}
		};
		gameFrame.getContentPane().add(new JScrollPane(renderer),
				BorderLayout.CENTER);
		
		// end renderer section
		
		// server gui section
		// /create Jframe, create tree, create table, and gameInstance add tree
		// and table to jframe using borerlayouts
		// serverGUI gets updated with our CurrentGame;

		ServerTree tree = new ServerTree();
		gameFrame.getContentPane().add(new JScrollPane(tree), BorderLayout.WEST);
		
		JPanel serverInfo = new JPanel(new GridLayout(2, 1));
		// create table
		ServerGUI table = ServerGUI.getInstance();
		table.updateTable(currentGame);
		//table.statusBar(gameFrame);
		//gameFrame.getContentPane().add(table, BorderLayout.SOUTH);		
		// end create table
		
		// ServerGUI.statusBar()
		JPanel statBar = new JPanel();
    	statBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
    	//gameFrame.getContentPane().add(statBar, BorderLayout.SOUTH);

    	JLabel statInfo = new JLabel("DB Status:             Game Status:");
    	statBar.add(statInfo);
		// end ServerGUI.statusBar()
    	
    	serverInfo.add(table, BorderLayout.CENTER);
    	serverInfo.add(statBar, BorderLayout.SOUTH);
    	gameFrame.getContentPane().add(serverInfo, BorderLayout.SOUTH);
    	
		gameFrame.pack();
		gameFrame.setVisible(true);
		
		// create instance of ServerMT, and give it our current game reference.
		// then infinite loop step method
		ServerMT server = new ServerMT(currentGame);

		while (true) {
			server.step();
			renderer.repaint();

		}// end while

	}// end main

	public static void center(JFrame frame) {
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		Point center = ge.getCenterPoint();
		int windowX = 512;
		int windowY = 320;
		int x = center.x - windowX / 2;
		int y = center.y - windowY / 2;
		frame.setBounds(x, y, windowX, windowY);
		frame.validate();
	}// end center()
}// end main class

