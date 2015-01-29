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
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import team5.Client.ClientJTable;
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
		JPanel statusBar;
		JTextField status;
		JTextArea info;
		final JTextField titleBar;
		ClientJTable playerTable;
		
		// Method to create dummy players
		initializePlayers();

		// Get the client player
		actualPlayer = playerList.get(1);

		// Create the gameBoard Panel 
		gameBoard = new JPanel();
		gameBoard.setBackground(Color.BLACK);
		
		
		// Create the Title Bar
	    titleBar = new JTextField();
		titleBar.setText("Game Map");
		titleBar.setHorizontalAlignment(JTextField.CENTER);
		titleBar.setEditable(false);
		
		// Create JList for Status Implementation
		statusBar = new JPanel();
		statusBar.setOpaque(true);
		
		status = new JTextField();
		status.setText("Status");
		status.setHorizontalAlignment(JTextField.CENTER);
		status.setEditable(false);
		
		info = new JTextArea();
		actualPlayer = playerList.get(0);
		info.setText(actualPlayer.toString());
		info.setEditable(false);
		
		statusBar.add(status);
		statusBar.add(info);
		
		playerTable = new ClientJTable(playerList, actualPlayer);
		
		// Add Objects to Frame, Frame properties and open Frame.
		frame = new JFrame("ClientJList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Turn Tanks");
		frame.add(titleBar, BorderLayout.NORTH);
		frame.add(statusBar, BorderLayout.CENTER);
		//frame.add(gameBoard, BorderLayout.CENTER);
		frame.add(playerTable, BorderLayout.SOUTH);
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
		
		Player player = new Player( 0, 25,position, state);
		playerList.addElement(player);
		x = 10;
		y = 10;
		position = new Pair(x, y);
		state = Player.State.ALIVE;
		player = new Player(1, 20, position, state);
		playerList.addElement(player);
		
		x = 15;
		y = 15;
		state = Player.State.WAITING;
		position = new Pair(x, y);
		player = new Player(2, 50, position, state);
		
		playerList.addElement(player);
		x = 11;
		y = 41;
		state = Player.State.DEAD;
		position = new Pair(x, y);
		player = new Player(3, 0, position, state);
		playerList.addElement(player);
	}

	// Creates and starts the main thread
	public static void main(String[] args) {
		(new MainThread()).start();
	}

}
