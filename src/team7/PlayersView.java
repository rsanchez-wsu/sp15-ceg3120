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

package team7;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

// (JTC)  This will be the JSplitPane that will pop up when a player is clicked.
// More than likely we will want a JTabbed pane/JSplit Pane hybrid with the focussed
// tab being the player that was clicked.

public class PlayersView extends JFrame{
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 300;
	
	private JTabbedPane tabbedPane;
	
	public PlayersView(String player, ClientView cv)
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// Listens for when the window closes and informs the ClientView
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        cv.removePlayersView();
		    }
		});
		
		tabbedPane = new JTabbedPane();
		
		ImageIcon icon = new ImageIcon("tank.png", "Tank Icon");
		
		tabbedPane.addTab("Player 1", icon, null);
		tabbedPane.addTab("Player 2", icon, null);
		tabbedPane.addTab("Player 3", icon, null);
		tabbedPane.addTab("Player 4", icon, null);
		tabbedPane.addTab("Player 5", icon, null);
		tabbedPane.addTab("Player 6", icon, null);
		tabbedPane.addTab("Player 7", icon, null);
		tabbedPane.addTab("Player 8", icon, null);
		
		final int playerIndex = getPlayerIndex(player);
		JPanel playerPanel = new JPanel();
		playerPanel.add(new JLabel(player, icon, SwingConstants.LEADING));
		JToggleButton playerCheckBox = new JCheckBox();
		
		playerCheckBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tabbedPane.remove(playerIndex);
			}
		});
		
		playerPanel.add(playerCheckBox);
		tabbedPane.setTabComponentAt(playerIndex, playerPanel);
		add(tabbedPane, "Center");
		
		tabbedPane.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				// check if this tab still has a null component
				if(tabbedPane.getSelectedComponent() == null)
				{
					// set component to image icon
					int n = tabbedPane.getSelectedIndex();
					loadTab(n);
				}
			}
		});
		
		loadTab(0);
	}
	
	public int getPlayerIndex(String p)
	{
		return this.tabbedPane.indexOfTab(p);
	}
	
	public void loadTab(int n)
	{
		String title = tabbedPane.getTitleAt(n);
		// (JTC) The following line will replace the pIcon in use once dynamic player icons are implemented
		// ImageIcon pIcon = new ImageIcon(getClass().getResource(title + ".png"));
		ImageIcon pIcon = new ImageIcon("tank.png", "Tank Icon");
		tabbedPane.setComponentAt(n, new JLabel(pIcon));
	}
}
