package team7;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class JTableTest {

	public static void main(String[] args) {
		// Player player1 = new Player("Player 1", 3, 5);
		// Player player2 = new Player("Player 2", 8, 7);
		// Player player3 = new Player("Player 3", 2, 5);
		// Player player4 = new Player("Player 4", 4, 6);
		// Player player5 = new Player("Player 5", 1, 9);
		// Player player6 = new Player("Player 6", 0, 0);
		// Player player7 = new Player("Player 7", 0, 1);
		// Player player8 = new Player("Player 8", 6, 6);
		// Player player9 = new Player("Player 9", 7, 6);
		// Player player10 = new Player("Player 10", 0, 9);
		
		ArrayList<Player> players = new ArrayList<>();
		
		players.add(new Player("Player 1", 3, 5));
		players.add(new Player("Player 2", 8, 7));
		players.add(new Player("Player 3", 2, 5));
		players.add(new Player("Player 4", 4, 6));
		players.add(new Player("Player 5", 1, 9));
		players.add(new Player("Player 6", 0, 0));
		players.add(new Player("Player 7", 0, 1));
		players.add(new Player("Player 8", 6, 6));
		players.add(new Player("Player 9", 7, 6));
		players.add(new Player("Player 10", 0, 9));
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new PlayerTableFrame(players);
				frame.setTitle("Turn Tanks");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
