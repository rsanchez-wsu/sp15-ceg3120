/*
 * Copyright (C) 2015 - Matthew J Lents mlents0929@gmail.com
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
package team9;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class playerTree extends JSplitPane implements TreeSelectionListener{

	private DefaultMutableTreeNode root;
	private JTree tree;
	private JTextArea textArea = new JTextArea();
	private JScrollPane treeView;
	private JScrollPane textView;
	
	// Default Constructor
	public playerTree(){
	}
	
	/**
	 * Constructor
	 * @param playerList the list of players to be included on the tree
	 * @param SelectedPlayer the player currently selected by the user
	 */
	public playerTree(Vector<Player> playerList, Player SelectedPlayer){
	
		// Create the root and fill the tree
		root = new DefaultMutableTreeNode("Players");			 
		createNodes(root, playerList);
		
		// Set the renderer for each tree cell
		tree = new JTree(root);
		MyTreeCellRenderer renderer = new MyTreeCellRenderer();
		tree.setCellRenderer(renderer);
		
		// Create a pane for the tree to be viewed in
		treeView = new JScrollPane(tree);
		textArea.setEditable(false);
		textView= new JScrollPane(textArea);
		
		// Display the node of the selected player
		displayNode(SelectedPlayer);
		
		// Create a selection model so that only one player can be selected
		tree.getSelectionModel().setSelectionMode
          (TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		// Add listener for tree selection
		tree.addTreeSelectionListener(this);

		// Create and fill the window 
		
		this.add(treeView, JSplitPane.LEFT);
		this.add(textArea, JSplitPane.RIGHT);
	
	}
	private void createNodes(DefaultMutableTreeNode root2, Vector<Player> playerList) {
		DefaultMutableTreeNode Player = null;
	
	    for(int i =0;i<playerList.size();i++){
	    	Player = new DefaultMutableTreeNode(playerList.elementAt(i));
	    	
	    	root.add(Player);
	    	
	    }
	}

	/**
	 * Method for changing the selected node on the tree
	 */
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                tree.getLastSelectedPathComponent();

		if (node == null) return;

		// Display contents of a leaf
		Object nodeInfo = node.getUserObject();
		if(node.isLeaf()){
			Player player = (Player)nodeInfo;
			displayNode(player);
		}

	}

	/**
	 * Displays the contents of a node
	 * @param player player currently selected
	 */
	private void displayNode(Player player){
		// Displays the player selected
		if(player != null){
			String s = player.getName()+"\nPlayer " + player.getPlayerNum()+"\nHealth: "+player.getHealth()+
					"\nLast Seen Position: "+player.getLastLoc();
			textArea.setText(s);	
		}
	}
}

/**
 * Renderer to display the contents of each cell 
 * in the appropriate way
 * @author Matthew
 *
 */
class MyTreeCellRenderer extends DefaultTreeCellRenderer{
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
			boolean expanded, boolean leaf, int row,boolean hasFocus){
		Component comp = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
	
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		node.getUserObject();
		return comp;
	}		
};