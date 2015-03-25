
/*
 *  Copyright (C) <2015>  <Brandon Head, Matthew Hemker, Hien Long, Maxwell Nukpor>
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

package team8;

import java.awt.*;
import javax.swing.*;
import team8.Player.State;

class GameServer extends JFrame {
	private JFrame mainFrame;// The main frame for Game Server
	private JPanel mainPanel; // The parent panel contains other panels and
								// components
	private JPanel gameHisPanel;// Panel that contains game history
	private JPanel gameDetailsPanel;// Panel that contains game details
	private JList gameHistory; // History JList
	private JList gameDetails; // Game details JList
	private JList listbox;

	// Constructor of main frame
	public GameServer() {

		//Create 8 players and give them random attributes
		Player[] playerList = new Player[8];
		for (int i = 0; i < 8; i++) {
			playerList[i] = new Player(i + 1);
			playerList[i].setHealth(0 + (int)(Math.random()*50));
			if(playerList[i].getHealth() == 0){
				playerList[i].setPlayerState(State.DEAD);
			}
		}

		//Create an array of the attributes of all 8 players
		String[] players = new String[8];
		for (int j = 0; j < 8; j++) {
			players[j] = playerList[j].toString();
		}

		//Create a List entry consisting of all 8 players and the icon
		DefaultListModel dlm = new DefaultListModel();
		for (int k = 0; k < 8; k++) {
			dlm.addElement(new ListEntry(players[k], new ImageIcon("src/team8/tank.png")));
		}

		//Create a JList of all the players
		JList list = new JList(dlm);
		//Use a custom cell renderer to format the JList
		list.setCellRenderer(new ListEntryCellRenderer());

		//Create Labels for the Game Server
		JLabel historyLabel = new JLabel("  Game History");// initialize the label
		JLabel detailsLabel = new JLabel("  Game Details");// initialize the label
		JLabel dBStatusLabel = new JLabel("  DB Status: ");// initialize the label
		JLabel gameStatusLabel = new JLabel("  Game Status: ");// initialize the label

		//Create scroll pane for the game history and game detail
		JScrollPane historyScrollPane = new JScrollPane(list);
		JScrollPane detailsScrollPane = new JScrollPane();

		//Create a nested Split Pane to contain all of the Several panes for the game server.
		JSplitPane leftPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				historyLabel, detailsScrollPane);
		leftPane.setDividerLocation(30);
		leftPane.setEnabled(false);
		JSplitPane rightPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				detailsLabel, historyScrollPane);
		rightPane.setDividerLocation(30);
		rightPane.setEnabled(false);
		JSplitPane topPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftPane, rightPane);
		topPane.setResizeWeight(0.5);
		topPane.setDividerLocation(250);
		JSplitPane bottomPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				dBStatusLabel, gameStatusLabel);
		bottomPane.setResizeWeight(0.3);
		bottomPane.setDividerLocation(250);
		bottomPane.setEnabled(false);
		JSplitPane mainPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				topPane, bottomPane);
		mainPane.setResizeWeight(1);
		mainPane.setDividerLocation(520);
		mainPane.setEnabled(false);

		//Create a JFrame to contain the nested split panes
		JFrame frame = new JFrame("Game Server Interface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPane, BorderLayout.CENTER);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	// Main entry point for this example
	public static void main(String args[]) {
		// Create an instance of the test application
		GameServer mainFrame = new GameServer();
	}
}
