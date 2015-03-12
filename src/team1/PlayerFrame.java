/*
 *  Copyright (C) <2015>  Marie Hucke, Kristen Schwaiger, Kyle Wintermute, Kyle Wood
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


package team1;

import java.awt.*;

import javax.swing.*;

public class PlayerFrame extends JFrame 
{
	private JTabbedPane playerDisplay;
	private static final long serialVersionUID = 1L;
	
	public PlayerFrame() 
	{
		createComponents();
		this.setSize(400, 300);
	}//end constructor
	
	private void createComponents()
	{
		//create the main panel that will contain all other panels
		playerDisplay = new JTabbedPane();
		add(playerDisplay);
	}
	
	
	public void addPlayer(Player playerAdded, JLabel information)
	{
		playerDisplay.addTab(playerAdded.getName(),information);
		
	}
}
