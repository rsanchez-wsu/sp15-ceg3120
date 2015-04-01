package edu.wright.cs.sp15.ceg3120.turntanks.server;

/*
 * Copyright (C) <2015> <Team 2>
 * 
 * Will Hatfield
 * Kevin Alig
 * Alyssa Ramsey
 * Anthony Lamping
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
import java.awt.*;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import team2.Player;

public class ServerGUI extends JPanel implements TreeSelectionListener {

	private static final long serialVersionUID = 1L;

	private JSplitPane serverSplitPane;
	private JPanel gameDetailsPanel;
	private JPanel gameHistoryPanel;

	// details vars
	private JList<Player> playerList;
	private DefaultListModel<Player> model;

	// history vars
	private JTree gameTree;
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
	private DefaultMutableTreeNode current = new DefaultMutableTreeNode(
			"Current");
	private DefaultMutableTreeNode previous = new DefaultMutableTreeNode(
			"Previous");

	public ServerGUI() {

		// Create Game Details Pane
		// <--
		gameDetailsPanel = new JPanel(new BorderLayout());

		JLabel detailsHeader = new JLabel("Game Details");
		JLabel detailsFooter = new JLabel(
				"Game Status: [Waiting/In Progress/Complete]");

		playerList = new JList<Player>();
		JScrollPane playerListScroll = new JScrollPane(playerList);
		model = new DefaultListModel<Player>();
		playerList.setModel(model);

		addRandomPlayers();

		gameDetailsPanel.add(detailsHeader, BorderLayout.NORTH);
		gameDetailsPanel.add(playerListScroll, BorderLayout.CENTER);
		gameDetailsPanel.add(detailsFooter, BorderLayout.SOUTH);
		// -->

		// Create Game History Pane
		// <--
		gameHistoryPanel = new JPanel(new BorderLayout());

		JLabel historyHeader = new JLabel("Game History");
		JLabel historyFooter = new JLabel("DB Status: [Green/Yellow/Red]");

		root.add(current);
		root.add(previous);
		addGameNodes();

		gameTree = new JTree(root);
		JScrollPane gameTreeScroll = new JScrollPane(gameTree);
		gameTree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		gameTree.setRootVisible(false);
		gameTree.setShowsRootHandles(true);
		gameTree.addTreeSelectionListener(this);
		gameTree.expandRow(1);//expand previous

		gameHistoryPanel.add(historyHeader, BorderLayout.NORTH);
		gameHistoryPanel.add(gameTreeScroll, BorderLayout.CENTER);
		gameHistoryPanel.add(historyFooter, BorderLayout.SOUTH);
		// -->

		// Create Split Pane
		serverSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				gameHistoryPanel, gameDetailsPanel);
		serverSplitPane.setPreferredSize(new Dimension(500, 400));
		serverSplitPane.setDividerLocation(150);
		Dimension minimumSize = new Dimension(50, 50);
		gameHistoryPanel.setMinimumSize(minimumSize);
		gameDetailsPanel.setMinimumSize(minimumSize);

	}

	public JSplitPane getGUI() {
		return this.serverSplitPane;
	}

	public void addRandomPlayers() {
		// make 8 dummy players
		for (int i = 0; i < 7; i++) {
			model.addElement(new Player());
		}
	}

	public void clearListModel() {
		// clear the player list
		model.clear();
	}

	private void addGameNodes() {
		// generated for testing
		for (int i = 0; i < 4; i++) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode("Game "
					+ i);
			previous.add(node);
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		//
		if (e.getNewLeadSelectionPath().getLastPathComponent().equals(previous)){
			return;
		}
		clearListModel();
		addRandomPlayers();
		playerList.setModel(model);
		
	}
}
