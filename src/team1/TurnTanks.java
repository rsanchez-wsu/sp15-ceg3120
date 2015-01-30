package team1;

import java.math.*;
import java.awt.*;
import java.beans.*;
import javax.swing.*;


public class TurnTanks {
	
	// Create the frame
	private static void createClientWindow(){
		
		JFrame frame = new JFrame("TURN TANKS!!ONE!11!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		
		
		frame.pack();
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
