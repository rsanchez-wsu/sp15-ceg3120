package team2;
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

public class GameHistoryPane extends JPanel implements TreeSelectionListener {
	// Reserved for game history pane
	// top label (Game History)
	// game tree
	// bottom label (DB status)

	private JLabel header;
	private JLabel footer;
	private JTree gameTree;

	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
	private DefaultMutableTreeNode current = new DefaultMutableTreeNode(
			"Current");
	private DefaultMutableTreeNode previous = new DefaultMutableTreeNode(
			"Previous");

	public GameHistoryPane() {

		header = new JLabel("Game History");
		footer = new JLabel("DB Status: [Green/Yellow/Red]");

		root.add(current);
		root.add(previous);
		addGameNodes();

		gameTree = new JTree(root);
		JScrollPane gameTreeScroll = new JScrollPane(gameTree);
		gameTree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		gameTree.setRootVisible(false);
		gameTree.setShowsRootHandles(true);

		setLayout(new BorderLayout());
		add(header, BorderLayout.NORTH);
		add(gameTreeScroll, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
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
	public void valueChanged(TreeSelectionEvent arg0) {
		// need to do stuff here
	}
}
