package team6;

import java.awt.*;
import javax.swing.*;

//This class will render a 64x64 array representing a map, and a array
//of TankObjects, representing players.  

public class GameRenderer extends JPanel {

	char[][] map = new char[64][64];

	GameInstance players;

	public void GameRenderer() {
		for(int i=0; i<63 ; i++){
			for (int j=0; j<63; j++){
				
				map[i][j]='g';
			}
			
			
		}
		
		players=new GameInstance(); //temp fake constructor

	}

	public void GameRenderer(char[][] map, GameInstance players) {
		this.map = map;
		this.players = players;

	}

	// @override
	public void paint(Graphics g) {
		for (int i = 0; i < 63; i++) {
			for (int j = 0; j < 63; j++) {

				if (map[i][j] == 'g')// grass
					g.setColor(Color.GREEN);
				else if (map[i][j] == 'l')
					g.setColor(Color.BLUE);//lake
				else if (map[i][j] == 'm')//mountain
					g.setColor(Color.darkGray);
				else if (map[i][j] == 'h')//hill
					g.setColor(Color.lightGray);
				else
					g.setColor(Color.ORANGE);//bad color
				g.fillRect(i * 5, j * 5, i * 5 + 5, j * 5 + 5);
				
				
			}
		}

		/*for (int i=0; i<7;i++){
			int x=0;
			int y=0;
			x=players.tanks.get(i).xCoord;
			y=players.tanks.get(i).yCoord;
			g.setColor(Color.MAGENTA);
			g.fillRect(x*10, y*10, 10, 10);
		}*/
	}

}
