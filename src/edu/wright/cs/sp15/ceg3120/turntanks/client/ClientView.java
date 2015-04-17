/*
 *  Copyright (C) <2015>  
 *  Josh Crank - crank.5@wright.edu
 *  // Aditional People
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import edu.wright.cs.sp15.ceg3120.turntanks.Player;

//(JTC) This is the client view, the main game panel.

public class ClientView extends JFrame {
	/**
	 * Random generated serial version UID
	 */
	private static final long serialVersionUID = -6763963976364615259L;

	// (JTC) Window Size
	private static final int DEFAULT_WIDTH = 1024;
	private static final int DEFAULT_HEIGHT = 768;
	private static PlayersView currentPlayersView;
	private static ClientView self = null;

	private String localName = null;
	private Map<String,Player> players;

	public ClientView() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		setTitle("Turn Tanks: Ultimate Destruction!!!!11!!111!ONE!1!!");

		// (kwood) When the program starts, Open a dialog to ask the player for
		// their name.
		localName = JOptionPane.showInputDialog(null,
				"Please enter your Player name", "Player Name",
				JOptionPane.PLAIN_MESSAGE);
		if (localName == null) {
			System.exit(0);
		}
		
		// Exit the program if the window is closed
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to close?", "Close?",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		// (JTC) Setup map area and title
		final JLabel mapTitle = new JLabel("Game Map", SwingConstants.CENTER);
		final JLabel map = new JLabel();
		map.setBackground(Color.BLACK);
		map.setOpaque(true);
		map.setMinimumSize(new Dimension(1024, 500));

		// (JTC) Setup player status area
		final JLabel statusLabel = new JLabel("Status", SwingConstants.CENTER);
		statusLabel.setMinimumSize(new Dimension(65, 65));
		final JLabel status = new JLabel(
				"<html>&nbsp&nbsp&nbsp Game Info - Status: In Progress | Server: 10.229.154.17 | Players left: 6<br>"
						+ "&nbsp&nbsp&nbsp My Info - #: 6 | Health: 11/50 | Position: (60,25) | State: Wait");

		// (JTC) Set up icons for player buttons
		final ImageIcon tankIcon = new ImageIcon("tank.png", "Tank Icon");
		Image image = tankIcon.getImage();
		// image.getWidth(null)/2 ; image.getHeight(null)/2
		image = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		tankIcon.setImage(image);

		// (JTC) Set up player buttons

		// create button
		final JButton p1 = new JButton("<html>" + players.get(0).getName()
				+ "<br>Last Seen:<br>(never)</html>", tankIcon);
		p1.setVerticalTextPosition(SwingConstants.BOTTOM);
		p1.setHorizontalTextPosition(SwingConstants.CENTER);
		// (JTC) add button listener to open the player status panel for that
		// player. PlayersView takes
		// in "Player #" where # is the player number.
		p1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPlayersView == null) {
					PlayersView playersWindow = new PlayersView("Player 1",
							self);
					currentPlayersView = playersWindow;
					playersWindow.setVisible(true);
					playersWindow.setResizable(false);
				} else {
					currentPlayersView.changeTab(0);
					currentPlayersView.toFront();
				}
			}
		});

		final JButton p2 = new JButton("<html>" + players.get(1).getName()
				+ "<br>Last Seen:<br>(30, 29)</html>", tankIcon);
		p2.setVerticalTextPosition(SwingConstants.BOTTOM);
		p2.setHorizontalTextPosition(SwingConstants.CENTER);
		p2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPlayersView == null) {
					PlayersView playersWindow = new PlayersView("Player 2",
							self);
					currentPlayersView = playersWindow;
					playersWindow.setVisible(true);
					playersWindow.setResizable(false);
				} else {
					currentPlayersView.changeTab(1);
					currentPlayersView.toFront();
				}
			}
		});

		final JButton p3 = new JButton("<html>" + players.get(2).getName()
				+ "<br>Last Seen:<br>(12, 33)</html>", tankIcon);
		p3.setVerticalTextPosition(SwingConstants.BOTTOM);
		p3.setHorizontalTextPosition(SwingConstants.CENTER);
		p3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPlayersView == null) {
					PlayersView playersWindow = new PlayersView("Player 3",
							self);
					currentPlayersView = playersWindow;
					playersWindow.setVisible(true);
					playersWindow.setResizable(false);
				} else {
					currentPlayersView.changeTab(2);
					currentPlayersView.toFront();
				}
			}
		});

		final JButton p4 = new JButton("<html>" + players.get(3).getName()
				+ "<br>Last Seen:<br>(never)</html>", tankIcon);
		p4.setVerticalTextPosition(SwingConstants.BOTTOM);
		p4.setHorizontalTextPosition(SwingConstants.CENTER);
		p4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPlayersView == null) {
					PlayersView playersWindow = new PlayersView("Player 4",
							self);
					currentPlayersView = playersWindow;
					playersWindow.setVisible(true);
					playersWindow.setResizable(false);
				} else {
					currentPlayersView.changeTab(3);
					currentPlayersView.toFront();
				}
			}
		});

		final JButton p5 = new JButton("<html>" + players.get(4).getName()
				+ "<br>Last Seen:<br>(22, 34)</html>", tankIcon);
		p5.setVerticalTextPosition(SwingConstants.BOTTOM);
		p5.setHorizontalTextPosition(SwingConstants.CENTER);
		p5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPlayersView == null) {
					PlayersView playersWindow = new PlayersView("Player 5",
							self);
					currentPlayersView = playersWindow;
					playersWindow.setVisible(true);
					playersWindow.setResizable(false);
				} else {
					currentPlayersView.changeTab(4);
					currentPlayersView.toFront();
				}
			}
		});

		final JButton p6 = new JButton("<html>" + players.get(5).getName()
				+ "<br>Last Seen:<br>(never)</html>", tankIcon);
		p6.setVerticalTextPosition(SwingConstants.BOTTOM);
		p6.setHorizontalTextPosition(SwingConstants.CENTER);
		p6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPlayersView == null) {
					PlayersView playersWindow = new PlayersView("Player 6",
							self);
					currentPlayersView = playersWindow;
					playersWindow.setVisible(true);
					playersWindow.setResizable(false);
				} else {
					currentPlayersView.changeTab(5);
					currentPlayersView.toFront();
				}
			}
		});

		final JButton p7 = new JButton("<html>" + players.get(6).getName()
				+ "<br>Last Seen:<br>(never)</html>", tankIcon);
		p7.setVerticalTextPosition(SwingConstants.BOTTOM);
		p7.setHorizontalTextPosition(SwingConstants.CENTER);
		p7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPlayersView == null) {
					PlayersView playersWindow = new PlayersView("Player 7",
							self);
					currentPlayersView = playersWindow;
					playersWindow.setVisible(true);
					playersWindow.setResizable(false);
				} else {
					currentPlayersView.changeTab(6);
					currentPlayersView.toFront();
				}
			}
		});

		final JButton p8 = new JButton("<html>" + players.get(7).getName()
				+ "<br>Last Seen:<br>(never)</html>", tankIcon);
		p8.setVerticalTextPosition(SwingConstants.BOTTOM);
		p8.setHorizontalTextPosition(SwingConstants.CENTER);
		p8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPlayersView == null) {
					PlayersView playersWindow = new PlayersView("Player 8",
							self);
					currentPlayersView = playersWindow;
					playersWindow.setVisible(true);
					playersWindow.setResizable(false);
				} else {
					currentPlayersView.changeTab(7);
					currentPlayersView.toFront();
				}
			}
		});

		// (JTC) Create the panes for a nested JSplitPane
		// (JTC) Status Pane (label and player status)
		JSplitPane statusPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				statusLabel, status);
		statusPane.setDividerLocation(0.3);
		statusPane.setMinimumSize(new Dimension(1024, 65));
		statusPane.setEnabled(false);
		statusPane.setDividerSize(1);

		// (JTC) Map pane (map and title) ***Note this will likely contain a map
		// JPanel object of its own once gameBoard is implemented ***
		JSplitPane mapPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				mapTitle, map);
		mapPane.setEnabled(false);
		mapPane.setDividerSize(1);

		// (JTC) This is the pane that contains the status and map areas
		JSplitPane topPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mapPane,
				statusPane);
		// topPane.setDividerLocation(0.1);
		topPane.setBorder(null);
		topPane.setEnabled(false);
		topPane.setDividerSize(1);

		// (JTC) These are the panes that hold the player buttons in a single
		// horizontal line
		JSplitPane p1p2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		p1p2.setBorder(null);
		p1p2.setResizeWeight(0.5);
		p1p2.setEnabled(false);
		p1p2.setDividerSize(1);

		JSplitPane p3p4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p3, p4);
		p3p4.setBorder(null);
		p3p4.setResizeWeight(0.5);
		p3p4.setEnabled(false);
		p3p4.setDividerSize(1);

		JSplitPane p5p6 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p5, p6);
		p5p6.setBorder(null);
		p5p6.setResizeWeight(0.5);
		p5p6.setEnabled(false);
		p5p6.setDividerSize(1);

		JSplitPane p7p8 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p7, p8);
		p7p8.setBorder(null);
		p7p8.setResizeWeight(0.5);
		p7p8.setEnabled(false);
		p7p8.setDividerSize(1);

		JSplitPane p1p2p3p4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1p2,
				p3p4);
		p1p2p3p4.setBorder(null);
		p1p2p3p4.setResizeWeight(0.5);
		p1p2p3p4.setEnabled(false);
		p1p2p3p4.setDividerSize(1);

		JSplitPane p5p6p7p8 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p5p6,
				p7p8);
		p5p6p7p8.setBorder(null);
		p5p6p7p8.setResizeWeight(0.5);
		p5p6p7p8.setEnabled(false);
		p5p6p7p8.setDividerSize(1);

		JSplitPane allPlayers = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				p1p2p3p4, p5p6p7p8);
		allPlayers.setBorder(null);
		allPlayers.setResizeWeight(0.5);
		allPlayers.setEnabled(false);
		allPlayers.setDividerSize(1);

		// (JTC) This is the full view, bringing all panes nested together.
		JSplitPane fullView = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				topPane, allPlayers);
		fullView.setDividerLocation(0.2);
		fullView.setEnabled(false);
		fullView.setDividerSize(1);

		// (JTC) Add the JSplitPane to the layout
		add(fullView, BorderLayout.CENTER);

	}

	public static void removePlayersView() {
		currentPlayersView = null;
	}
	
	void setPlayers(Map<String,Player> playerList) {
		this.players = playerList;
	}
	
	public String getLocalName () {
		return this.localName;
	}
	
}