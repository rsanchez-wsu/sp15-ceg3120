/*
 * License tbd
 * @author hitchens6
 */
package team5.MainThread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import team5.Client.ClientJList;
import team5.PlayerObject.Pair;
import team5.PlayerObject.Player;

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
		JComponent statusBar;
		final JTextField titleBar;

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
		statusBar = new ClientJList(playerList, actualPlayer);
		statusBar.setOpaque(true);
		
		// Add Objects to Frame, Frame properties and open Frame.
		frame = new JFrame("ClientJList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Turn Tanks");
		frame.add(titleBar, BorderLayout.NORTH);
		frame.add(statusBar, BorderLayout.SOUTH);
		frame.add(gameBoard, BorderLayout.CENTER);
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
		Pair position = new Pair(x, y);
		Player player = new Player("1.1.1.1", "In Progress", 3, 0, 25,
				position, Player.State.WAITING);
		playerList.addElement(player);
		x = 10;
		y = 10;
		position = new Pair(x, y);
		player = new Player("1.1.1.1", "In Progress", 3, 1, 20, position, 		
				Player.State.ALIVE);
		playerList.addElement(player);
		x = 15;
		y = 15;
		position = new Pair(x, y);
		player = new Player("1.1.1.1", "In Progress", 3, 2, 50, position,
				Player.State.WAITING);
		playerList.addElement(player);
		x = 11;
		y = 41;
		position = new Pair(x, y);
		player = new Player("1.1.1.1", "In Progress", 3, 3, 0, position, Player.State.DEAD);
		playerList.addElement(player);
	}

	// Creates and starts the main thread
	public static void main(String[] args) {
		(new MainThread()).start();
	}

}
