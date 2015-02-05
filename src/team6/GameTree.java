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
import javax.swing.tree.*;

public class GameTree extends JPanel {

	private JTree tree;

	public GameTree() {
		// create the root node
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Games");
		// create the child nodes
		DefaultMutableTreeNode game1Node = new DefaultMutableTreeNode("Game 1");
		DefaultMutableTreeNode game2Node = new DefaultMutableTreeNode("Game 2");
		DefaultMutableTreeNode game3Node = new DefaultMutableTreeNode("Game 3");
		DefaultMutableTreeNode game4Node = new DefaultMutableTreeNode("Game 4");
		DefaultMutableTreeNode game5Node = new DefaultMutableTreeNode("Game 5");
		DefaultMutableTreeNode game6Node = new DefaultMutableTreeNode("Game 6");
		DefaultMutableTreeNode game7Node = new DefaultMutableTreeNode("Game 7");
		DefaultMutableTreeNode game8Node = new DefaultMutableTreeNode("Game 8");
		// add the child nodes to the root node
		root.add(game1Node);
		root.add(game2Node);
		root.add(game3Node);
		root.add(game4Node);
		root.add(game5Node);
		root.add(game6Node);
		root.add(game7Node);
		root.add(game8Node);

		// create the tree by passing in the root node
		tree = new JTree(root);
		add(tree);

	}
}
