/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 *  Copyright (C) <2015>  <Team 6>
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
//
package team6;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
//import java.awt.*;
import java.util.*;

@SuppressWarnings("serial")
public class ServerTree extends JPanel {

	JTree tree;
	HashMap<String, GameInstance> gameList;

	public ServerTree() {

		// Date gameDate = new Date();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("invisible root");		
		// create the root node
		DefaultMutableTreeNode historyRoot = new DefaultMutableTreeNode("Past Games");
		
		DefaultMutableTreeNode currentGame = new DefaultMutableTreeNode("Current Game");
		
		
		// create the child nodes		
		final HashMap<String, GameInstance> gameList = new HashMap<>();
		for (int i = 0; i < 8; i++) {
			historyRoot.add(new DefaultMutableTreeNode("Game " + i));
		}
		for (int i = 0; i < historyRoot.getChildCount(); i++) {
			GameInstance tempVar = new GameInstance();

			gameList.put(historyRoot.getChildAt(i).toString(), tempVar);
		}

		// create the tree by passing in the root node
		root.add(currentGame);
		root.add(historyRoot);
		
		tree = new JTree(root); //creates the tree, with out added root node
		tree.setRootVisible(false);
		add(tree);// adds tree to pane
		
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {

				DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
						.getPath().getLastPathComponent();
				GameInstance gi;
				if (node.toString().equals("Past Games"))
					return; //return if root node was clicked
				else if (node.toString().equals("Current Game"))
					gi=ServerGUI.getInstance().game; //pulls the game instance from the serverGUI class
				else
				gi = gameList.get(node.toString());

				ServerGUI.getInstance().updateTable(gi);
			}
		}

		);


	}//end constructor
}//end class
