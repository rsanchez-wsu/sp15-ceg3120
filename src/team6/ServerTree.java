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

		//Date gameDate = new Date();
		// create the root node
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Games");
		// create the child nodes
		// ????? Eclipse told me to make final ?????
		final HashMap<String, GameInstance> gameList = new HashMap<>();
		for (int i = 0; i < 8; i++) {
			root.add(new DefaultMutableTreeNode("Game " + i));
		}
		for (int i = 0; i < root.getChildCount(); i++) {
			GameInstance tempVar = new GameInstance();

			gameList.put(root.getChildAt(i).toString(), tempVar);
		}

		// create the tree by passing in the root node
		tree = new JTree(root);

		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {

				DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
						.getPath().getLastPathComponent();

				GameInstance gi = gameList.get(node.toString());

				System.out.println(gi.tanks.get(0).toString());				
				
				ServerGUI gui = ServerGUI.getInstance();
				
				
//				TankObject[] tanks = gi.getAllTanks();

//				Object[][] data = new Object[tanks.length][];
//				for (int i = 0; i < data.length; i++) {
//					data[i] = tanks[i].toStringArray();
//
//				}
//				gui.updateTable(data);
				gui.updateTable(gi);
			}
		}

		);

		add(tree);

		// for (int i = 0; i < currentGames.tanks.size(); i++) {
		// if (currentGames.tanks.)
		// }

	}
}
