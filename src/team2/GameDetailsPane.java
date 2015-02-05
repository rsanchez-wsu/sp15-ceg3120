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

public class GameDetailsPane extends JPanel {

	private JLabel header;
	private JLabel footer;
	private JList playerList;
	private DefaultListModel model;

	public GameDetailsPane() {

		header = new JLabel("Game Details");
		footer = new JLabel("Game Status: [Waiting/In Progress/Complete]");

		playerList = new JList();
		JScrollPane playerListScroll = new JScrollPane(playerList);
		model = new DefaultListModel();
		playerList.setModel(model);
		
		addRandomPlayers();
		
		setLayout(new BorderLayout());
		add(header, BorderLayout.NORTH);
		add(playerListScroll, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);

	}

	public void addRandomPlayers() {
		// make 8 dummy players
		for (int i = 0; i < 7; i++) {
			model.addElement(new Player());
		}
	}
	
	public void clearListModel(){
		model.clear();
	}
}
