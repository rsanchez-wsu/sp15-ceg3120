/*
 * License tbd
 * @author hitchens6
 */
package team5.MainThread;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import team5.Client.ClientJList;
import team5.PlayerObject.Pair;
import team5.PlayerObject.Player;

public class MainThread extends Thread {

	Vector<Player> playerList = new Vector<Player>();

	public void run() {
		Player actualPlayer;

		final JPanel titleBar = new JPanel();
		JLabel titleLabel = new JLabel("Game Map");
		titleBar.add(titleLabel);

		initializePlayers();

		actualPlayer = playerList.get(1);
		JFrame frame = new JFrame("ClientJList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent playersList = new ClientJList(playerList, actualPlayer);

		playersList.setOpaque(true);
		frame.setTitle("Turn Tanks");
		frame.add(titleBar, BorderLayout.NORTH);
		frame.add(playersList, BorderLayout.SOUTH);
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
				position, "wait");
		playerList.addElement(player);
		x = 10;
		y = 10;
		position = new Pair(x, y);
		player = new Player("1.1.1.1", "In Progress", 3, 1, 20, position,
				"Active");
		playerList.addElement(player);
		x = 15;
		y = 15;
		position = new Pair(x, y);
		player = new Player("1.1.1.1", "In Progress", 3, 2, 50, position,
				"Wait");
		playerList.addElement(player);
		x = 11;
		y = 41;
		position = new Pair(x, y);
		player = new Player("1.1.1.1", "In Progress", 3, 3, 0, position, "Dead");
		playerList.addElement(player);
	}

	// Creates and starts the main thread
	public static void main(String[] args) {
		(new MainThread()).start();
	}

}
