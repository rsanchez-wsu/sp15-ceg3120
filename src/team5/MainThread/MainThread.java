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
package team5.MainThread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import team5.Client.ClientJTable;
import team5.Client.EnemyPlayer;
import team5.PlayerObject.Pair;
import team5.PlayerObject.Player;

/**
 * @author Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker
 */
public class MainThread extends Thread {

	Vector<Player> playerList = new Vector<Player>();

	/**
	 * Runs Main Thread
	 */
	public void run() {
		// Run Variables
		Player actualPlayer;
		JPanel gameBoard;
		JFrame frame;
		JPanel gamePanel;
		JPanel statusPanel;
		JLabel status;
		JLabel info;
		JSplitPane splitPane;
		JSplitPane splitFrame;
		final JTextField titleBar;
		ClientJTable playerTable;
		
		// Method to create dummy players
		initializePlayers();

		// Get the client player
		actualPlayer = playerList.get(2);
		
		// Create the Title Bar
	    titleBar = new JTextField();
		titleBar.setText("Game Map");
		titleBar.setHorizontalAlignment(JTextField.CENTER);
		titleBar.setEditable(false);

		// Create the gameBoard Panel 
		gameBoard = new JPanel();
		gameBoard.setBackground(Color.BLACK);
		gameBoard.add(titleBar, BorderLayout.NORTH);
		
		// Create JList for Status Implementation
		gamePanel = new JPanel();
		gamePanel.setOpaque(true);
		gamePanel.setLayout(new GridLayout(1,0));
		
		statusPanel = new JPanel();
		statusPanel.setLayout(new GridLayout(1,0));
		
		status = new JLabel();
		status.setText("Status");
		status.setHorizontalAlignment(JLabel.CENTER);
		
		info = new JLabel();
		info.setText(actualPlayer.toString());
		info.setHorizontalAlignment(JLabel.CENTER);
		
		playerTable = new ClientJTable(playerList, actualPlayer);
	
		gamePanel.add(gameBoard);
		
		statusPanel.add(status, BorderLayout.WEST);
		statusPanel.add(info, BorderLayout.EAST);
		
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.add(statusPanel, JSplitPane.TOP);
		splitPane.add(playerTable, JSplitPane.BOTTOM);
		
		splitFrame = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitFrame.add(gamePanel, JSplitPane.TOP);
		splitFrame.add(splitPane, JSplitPane.BOTTOM);
		
		// Add Objects to Frame, Frame properties and open Frame.
		frame = new JFrame("ClientJList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(1,0));
		frame.setTitle("Turn Tanks");
		frame.add(splitFrame);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
	}

	/**
	 * creates players
	 */
	protected void initializePlayers() {
		int x = 1;
		int y = 1;
		Player.State state = Player.State.WAITING;
		Pair position = new Pair(x, y);
		
		Player player = new EnemyPlayer( 0, 25, position, state);
		playerList.addElement(player);
		x = 10;
		y = 10;
		position = new Pair(x, y);
		state = Player.State.ALIVE;
		player = new EnemyPlayer(1, 20, position, state);
		playerList.addElement(player);
		
		x = 10;
		y = 10;
		state = Player.State.WAITING;
		position = new Pair(x,y);
		player = new Player(2, 50, position, state);
		playerList.addElement(player);
		
		x = 11;
		y = 41;
		state = Player.State.DEAD;
		position = new Pair(x, y);
		player = new EnemyPlayer(3, 0, position, state);
		playerList.addElement(player);
//		
//		x = 15;
//		y = 15;
//		state = Player.State.WAITING;
//		position = new Pair(x, y);
//		player = new EnemyPlayer(4, 50, position, state);
//		
//		playerList.addElement(player);
//		x = 11;
//		y = 41;
//		state = Player.State.DEAD;
//		position = new Pair(x, y);
//		player = new EnemyPlayer(5, 0, position, state);
//		playerList.addElement(player);
//		
//		x = 30;
//		y = 15;
//		state = Player.State.WAITING;
//		position = new Pair(x, y);
//		player = new EnemyPlayer(6, 50, position, state);
//		
//		x = 40;
//		y = 15;
//		state = Player.State.WAITING;
//		position = new Pair(x, y);
//		player = new EnemyPlayer(7, 50, position, state);
//		
	}

	// Creates and starts the main thread
	public static void main(String[] args) {
		(new MainThread()).start();
	}

}
