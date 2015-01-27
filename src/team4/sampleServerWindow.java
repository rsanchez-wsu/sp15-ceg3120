/*
 *  Copyright (C) <2015>  <Team 4>
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
import javax.swing.ListModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		// Changed to array

		Person player1 = new Person("10.131.22.8", 1, 1, 22, new Point(7, 2),
				Person.State.Waiting);
		Person player2 = new Person("10.131.22.3", 1, 2, 50, new Point(1, 3),
				Person.State.Waiting);
		Person player3 = new Person("10.131.22.4", 1, 3, 12, new Point(25, 52),
				Person.State.Waiting);
		Person player4 = new Person("10.131.22.5", 1, 4, 23, new Point(25, 44),
				Person.State.Active);
		Person player5 = new Person("10.131.22.66", 1, 5, 0, new Point(44, 52),
				Person.State.Dead);
		Person player6 = new Person("10.131.22.250", 1, 6, 16,
				new Point(44, 23), Person.State.Waiting);
		Person player7 = new Person("10.131.22.230", 1, 7, 50,
				new Point(55, 13), Person.State.Waiting);
		Person player8 = new Person("10.131.22.150", 1, 8, 42,
				new Point(66, 1), Person.State.Waiting);

		// Table view from benjamin
		Object[][] personList = {
				{ player1.getIpAdress(), player1.getGameID(),
						player1.getPlayerNumber(), player1.getHealth(),
						player1.getLocationString(), player1.getIngameState() },
				{ player2.getIpAdress(), player2.getGameID(),
						player2.getPlayerNumber(), player2.getHealth(),
						player2.getLocationString(), player2.getIngameState() },
				{ player3.getIpAdress(), player3.getGameID(),
						player3.getPlayerNumber(), player3.getHealth(),
						player3.getLocationString(), player3.getIngameState() },
				{ player4.getIpAdress(), player4.getGameID(),
						player4.getPlayerNumber(), player4.getHealth(),
						player4.getLocationString(), player4.getIngameState() },
				{ player5.getIpAdress(), player5.getGameID(),
						player5.getPlayerNumber(), player5.getHealth(),
						player5.getLocationString(), player5.getIngameState() },
				{ player6.getIpAdress(), player6.getGameID(),
						player6.getPlayerNumber(), player6.getHealth(),
						player6.getLocationString(), player6.getIngameState() },
				{ player7.getIpAdress(), player7.getGameID(),
						player7.getPlayerNumber(), player7.getHealth(),
						player7.getLocationString(), player7.getIngameState() },
				{ player8.getIpAdress(), player8.getGameID(),
						player8.getPlayerNumber(), player8.getHealth(),
						player8.getLocationString(), player8.getIngameState() } };
		String[] headings = { "IP Address", "Game Id", "Player #", "Health",
				"Position", "State" };

		frame = new JFrame();
		frame.setBounds(100, 100, 927, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// table by benjamin
		JTable playerTable = new JTable(personList, headings);
		JScrollPane scrollPane = new JScrollPane(playerTable);
		playerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		playerTable.setEnabled(false);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		// add scrollPane to panel
		panel.add(scrollPane);
	}

}
