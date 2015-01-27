package team3;
import javax.swing.*;
import java.awt.*;

public class TankGame {

	public static void main(String args[]) {
		
		//makes the player number 3
		int myNumber = 3;
		
		Point[] lastSeen = {new Point(-1,-1), new Point(-1,-1), new Point(-1,-1), new Point(-1,-1), new Point(-1,-1), new Point(-1,-1), new Point(5,24), new Point(-1,-1)};
		
		//sets up the array of players
		Player[] players= new Player[8];
		for(int i = 0; i < 8; i++) {
			players[i] = new Player(i + 1);
		}//end of for
		
		//sets the locations of each player
		players[0].setLocation(new Point(0, 0));
		players[1].setLocation(new Point(0, 8));
		players[2].setLocation(new Point(0, 16));
		players[3].setLocation(new Point(0, 24));
		players[4].setLocation(new Point(63, 63));
		players[5].setLocation(new Point(43, 21));
		players[6].setLocation(new Point(5, 24));
		players[7].setLocation(new Point(63, 0));
		
		//sets where the player has last seen each opponent
		players[myNumber - 1].setSeen(lastSeen);
		
		//creates the arrays that will be displayed
		Object[] display = new String[16];
		Object[] otherDisplay = new String[18];
		
		//adds the information to the gameinfo display
		otherDisplay[0] = "GAME INFO";
		otherDisplay[1] = "\n";
		otherDisplay[2] = "Status: In Progress";
		otherDisplay[3] = "\n";
		otherDisplay[4] = "Server: 10.229.154.17";
		otherDisplay[5] = "\n";
		otherDisplay[6] = "Players left: 6";
		otherDisplay[7] = "\n";
		otherDisplay[8] = "MY INFO";
		otherDisplay[9] = "\n";
		otherDisplay[10] = "Number: " + myNumber;
		otherDisplay[11] = "\n";
		otherDisplay[12] = "Health: " + players[myNumber - 1].getHealth() + "/50";
		otherDisplay[13] = "\n";
		otherDisplay[14] = "Position: " + players[myNumber - 1].getLocation().toString();
		otherDisplay[15] = "\n";
		otherDisplay[16] = "State: Wait";
		otherDisplay[17] = "\n";
		
		//creates the display of players
		//if the player is the same as myNumber, display me rather than when the player was last seen
		for(int i = 0; i < 8; i++) {
			if(i + 1 == myNumber){
				display[i * 2] = "Player " + myNumber + ": Me";
			}//end of if
			else{
				display[i * 2] = "Player " + (i + 1) + ": Last seen:\n" + players[myNumber - 1].getSeen()[i].toString(); 
			}//end of else
			display[(i * 2) + 1] = "\n";
		}//end of for
		

		//creates the lists, adds them to a panel, and adds the panel to a JFrame
		JList list = new JList(display);
		JList otherList = new JList(otherDisplay);
		list.setBackground(Color.BLACK);
		list.setForeground(Color.WHITE);
		otherList.setBackground(Color.BLACK);
		otherList.setForeground(Color.WHITE);
		JPanel p = new JPanel(new BorderLayout());
		p.add(list, BorderLayout.WEST);	
		p.add(otherList, BorderLayout.EAST);
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(p);
		frame.setSize(800, 400);
		frame.setVisible(true);
	}
}
