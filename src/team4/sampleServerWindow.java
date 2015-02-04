/*
 *  Copyright (C) <2015>  <Brad Reynolds> - reynolds.0345@gmail.com
 *  					 ADD names/emails here
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

package team4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Point;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class sampleServerWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sampleServerWindow window = new sampleServerWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sampleServerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. Modify here.
	 */
	private void initialize() {
		// r0345
		// Generate 8 random games with random information and generated
		// players.
		// Use this information to have a gameList which is shown in the JTree.
		// when one of the games is chosen within the tree the player list from
		// that game is displayed.

		// as of 2/3/2015 I've gotten to the point of generating all the
		// necesarry information however the treemodel needs to be implemented.
		// Haven't planned that out yet.

		Game[] gameList = new Game[8];
		for (int i = 0; i < 8; i++) { // Generate 8 games
			Person[] personList = new Person[8];
			int gameNumber = (int) (Math.random() * 500);
			int playersTurn = (int) (Math.random() * 8);
			for (int j = 0; j < 8; j++) {// Generate 8 players per game

				Point ingamePosition = new Point((int) (Math.random() * 50),
						(int) (Math.random() * 50));
				int health = (int) (Math.random() * 50);
				String ipAdress = (int) (Math.random() * 255) + "."
						+ (int) (Math.random() * 255) + "."
						+ (int) (Math.random() * 255) + "."
						+ (int) (Math.random() * 255);
				Person.State ingameState;

				if (health > 0) {
					ingameState = Person.State.Waiting;
				} else {
					ingameState = Person.State.Dead;
				}
				if (j == playersTurn) {
					ingameState = Person.State.Active;
				}
				Person toAdd = new Person(ipAdress, gameNumber, j, health,
						ingamePosition, ingameState);
				personList[j] = toAdd;
			}

			Game.State gameStatus;
			if (Math.random() * 2 > 1) {// Determine game state
				gameStatus = Game.State.Active;
			} else {
				gameStatus = Game.State.Inactive;
			}
			Person winningPlayer = (personList[((int) (Math.random() * 7))]);

			Date dateStart = new Date((long) Math.abs(System
					.currentTimeMillis() - Math.random() * 500000));

			Date dateEnd = new Date((long) Math.abs(System.currentTimeMillis()
					- Math.random() * 500000));

			Game newGame = new Game(gameNumber, gameStatus, personList,
					dateStart, dateEnd, winningPlayer);
			gameList[i] = newGame;
		}

		String[] headings = { "IP Address", "Game Id", "Player #", "Health",
				"Position", "State" };

		frame = new JFrame();
		frame.setBounds(100, 100, 927, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// table by benjamin
		JTable playerTable = new JTable(gameList[5].getObjectPlayerData(),
				headings);
		JScrollPane scrollPane = new JScrollPane(playerTable);
		scrollPane.setBounds(387, 11, 514, 486);
		playerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		playerTable.setEnabled(false);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("JTree") {
			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("colors");
				node_1.add(new DefaultMutableTreeNode("blue"));
				node_1.add(new DefaultMutableTreeNode("violet"));
				node_1.add(new DefaultMutableTreeNode("red"));
				node_1.add(new DefaultMutableTreeNode("yellow"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("sports");
				node_1.add(new DefaultMutableTreeNode("basketball"));
				node_1.add(new DefaultMutableTreeNode("soccer"));
				node_1.add(new DefaultMutableTreeNode("football"));
				node_1.add(new DefaultMutableTreeNode("hockey"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("food");
				node_1.add(new DefaultMutableTreeNode("hot dogs"));
				node_1.add(new DefaultMutableTreeNode("pizza"));
				node_1.add(new DefaultMutableTreeNode("ravioli"));
				node_1.add(new DefaultMutableTreeNode("bananas"));
				add(node_1);
			}
		}));
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.putClientProperty("JTree.lineStyle", "None");
		tree.setRootVisible(false);
		JScrollPane scrollPane_1 = new JScrollPane(tree);
		scrollPane_1.setBounds(10, 11, 367, 486);
		panel.add(scrollPane_1);

		// add scrollPane to panel
		panel.add(scrollPane);
	}
}
