package team1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class TurnTanks extends JPanel implements ActionListener {
	
	public TurnTanks() {
		
		JPanel PlayerList = new JPanel();
		GridBagLayout PlayerListLayout = new GridBagLayout();
		GridBagConstraints GBConstraint = new GridBagConstraints();
		
		PlayerList.setLayout(PlayerListLayout);
		
		JLabel title = new JLabel("TURN TANKS");
		
		PlayerList.add(title);
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
