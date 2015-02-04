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


public class TurnTanks extends JPanel implements ActionListener {
	
	private JList PlayerList;
	
	public TurnTanks() {
		
		
		Player[] Players = new Player[8];
		
		PlayerList = new JList(Players);
		PlayerList.setVisibleRowCount(-1);
		
		//JPane PLPane = new JPane(PlayerList);
		
		JPanel PlayerPanel = new JPanel();
		GridBagLayout PlayerPanelLayout = new GridBagLayout();
		GridBagConstraints GBConstraint = new GridBagConstraints();
		
		PlayerPanel.setLayout(PlayerPanelLayout);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
	
	// Create the frame
	private static void createClientWindow() {
		
		JFrame frame = new JFrame("TURN TANKS!!ONE!11!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		frame.add(new TurnTanks());		
		frame.setSize(600, 600);
		//frame.pack();
		frame.setVisible(true);
		
	}
	
	
	public static void main(String args[]) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createClientWindow();
			}
		});
		
		
	}//end of main

	
	
}
