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

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// (JTC)  This will be the JSplitPane that will pop up when a player is clicked.
// More than likely we will want a JTabbed pane/JSplit Pane hybrid with the focussed
// tab being the player that was clicked.

public class PlayersView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8754354875447521537L;
	
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 300;
	
	private JTabbedPane tabbedPane;
	
	public PlayersView(String player, final ClientView cv)
	{
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        ClientView.removePlayersView();// Adjusted cv to be final to get rid of error message.
		    }
		});
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		tabbedPane = new JTabbedPane();
        ImageIcon icon = new ImageIcon("tank.png", "Tank Icon");
        
        JComponent p1 = makePlayerPanel("Player 1");
        tabbedPane.addTab("Player 1", icon, p1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JComponent p2 = makePlayerPanel("Player 2");
        tabbedPane.addTab("Player 2", icon, p2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        JComponent p3 = makePlayerPanel("Player 3");
        tabbedPane.addTab("Player 3", icon, p3);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        
        JComponent p4 = makePlayerPanel("Player 4");
        tabbedPane.addTab("Player 4", icon, p4);
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        JComponent p5 = makePlayerPanel("Player 5");
        tabbedPane.addTab("Player 5", icon, p5);
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
        
        JComponent p6 = makePlayerPanel("Player 6");
        tabbedPane.addTab("Player 6", icon, p6);
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);
        
        JComponent p7 = makePlayerPanel("Player 7");
        tabbedPane.addTab("Player 7", icon, p7);
        tabbedPane.setMnemonicAt(6, KeyEvent.VK_7);
        
        JComponent p8 = makePlayerPanel("Player 8");
        tabbedPane.addTab("Player 8", icon, p8);
        tabbedPane.setMnemonicAt(7, KeyEvent.VK_8);
        
        //(JTC) Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //(JTC) Set up tab preferences
        tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        int pIndex = tabbedPane.indexOfTab(player);
        tabbedPane.setSelectedIndex(pIndex);
        
	}
	
	
	public void changeTab(int i)
	{
		tabbedPane.setSelectedIndex(i);
	}
	
	private JComponent makePlayerPanel(String p)
	{
		JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(p);
        filler.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
	}
	
	private void loadTab(int n)
	{
		String title = tabbedPane.getTitleAt(n);
		// (JTC) The following line will replace the pIcon in use once dynamic player icons are implemented
		// ImageIcon pIcon = new ImageIcon(getClass().getResource(title + ".png"));
		ImageIcon pIcon = new ImageIcon("tank.png", "Tank Icon");
		tabbedPane.setComponentAt(n, new JLabel(pIcon));
	}
}
