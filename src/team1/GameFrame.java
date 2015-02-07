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
import java.awt.event.*;

import javax.swing.*;


public class GameFrame extends JFrame {
	
	private JList PlayerList;
	private JLabel testLabel;
	private static final long serialVersionUID = 1L;
	private DefaultListModel PlayerModel;
	
public GameFrame() {
		createComponents();
		this.setSize(800, 600);
	}//end constructor

private void createComponents(){
	
	//create the main panel that will contain all other panels
	JPanel mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	
	//create the panel to display player info
	JPanel playerDisplay = new JPanel();
	playerDisplay.setLayout(new BorderLayout());
	
	//create the panel to display game grid
	JPanel gameDisplay = new JPanel();
	gameDisplay.setLayout(new BorderLayout());
	
	//create the players and add them to the list
	Player[] Players = new Player[8];
	PlayerList = new JList(Players);
	PlayerList.setVisibleRowCount(-1);
	PlayerModel = new DefaultListModel();
	
	for(int i = 0; i < 8; i++){
		PlayerModel.addElement(new Player());
	}
	
	PlayerList = new JList(PlayerModel);
	PlayerList.setVisibleRowCount(8);
	
	//testLabel = new JLabel("TESTING");
	
	playerDisplay.add(PlayerList);
	mainPanel.add(gameDisplay, BorderLayout.NORTH);
	mainPanel.add(playerDisplay, BorderLayout.SOUTH);
	
	//GridBagLayout PlayerPanelLayout = new GridBagLayout();
	//GridBagConstraints GBConstraint = new GridBagConstraints();
	
	this.add(mainPanel);
	
	
	//JPane PLPane = new JPane(PlayerList);
	
	//playerDisplay.setLayout(PlayerPanelLayout);
}//end of createComponents
}//end of class