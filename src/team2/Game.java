package team2;

import javax.swing.JFrame;

public class Game {

	private static void createAndShowGUI() {

        JFrame frame = new JFrame("Game Title Here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ServerGUI server = new ServerGUI();
        frame.getContentPane().add(server.getGUI());
        frame.pack();
        frame.setVisible(true);
        
    }
	
	public static void main(String[] args) {

		createAndShowGUI();
		
	}

}
