/*
 *  Copyright (C) <2015>  <Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker>
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

package team5.Client;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import team5.PlayerObject.Player;

public class PlayerTabs extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rows;
	private int columns;
	private Vector<Player> playerList;
	JFrame playerTabsFrame;
	
	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	

	
	public PlayerTabs(Vector<Player> playerList){
		this.columns = 0;
		/**
		this.playerList = playerList;
		
		playerTabsFrame = new JFrame();
		
		playerTabsFrame.add(tabs);
	    tabs.setEnabled(false);
		playerTabsFrame.setSize(300, 300);
		playerTabsFrame.setAlwaysOnTop(true);
		playerTabsFrame.setLocationRelativeTo(null);
		
		if(tabs.isEnabled()){	
			tabs.setSelectedIndex(column);
		}else{
		
		System.out.println(column);
		playerTabsFrame.setVisible(true);
		for(Player player : playerModel){
			Player temp = player;
			String tabTitle = "Player " + temp.getPlayerNumber();
			JLabel playerInfo = new JLabel();
			
			infoString = temp.toString();
			playerInfo.setText(infoString);
			
			tabs.addTab(tabTitle, playerInfo);
			tabs.setSelectedIndex(column);
			tabs.setEnabled(true);
			**/
	}

}
