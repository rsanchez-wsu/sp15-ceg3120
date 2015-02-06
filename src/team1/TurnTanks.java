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
import javax.swing.event.*;


public class TurnTanks extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList PlayerList;
	private DefaultListModel PlayerModel;
	
	public TurnTanks() {
		
		PlayerModel = new DefaultListModel();
		
		for(int i = 0; i < 8; i++){
			PlayerModel.addElement(new Player());
		}
		
		PlayerList = new JList(PlayerModel);
		PlayerList.setVisibleRowCount(8);
		JScrollPane PLPane =new JScrollPane(PlayerList);
		
		
		JPanel PLPanel = new JPanel();
		
		JPanel PlayerPanel = new JPanel();
		//GridBagLayout PlayerPanelLayout = new GridBagLayout();
		//GridBagConstraints GBConstraint = new GridBagConstraints();
		
		PlayerPanel.setLayout(new BorderLayout());
		PlayerPanel.add(PLPane, BorderLayout.SOUTH);
		
		
		
		add(PlayerPanel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	} 
	
	// Create the frame
	private static void createClientWindow() {
		
		JFrame frame = new JFrame("TURN TANKS!!ONE!11!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		JComponent newContentPane = new TurnTanks();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		
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
