package team6;

import java.awt.*;
import javax.swing.*;

//This class will render a 64x64 array representing a map, and a array
//of TankObjects, representing players.  

public class GameRenderer extends JPanel {

	char[][] map = new char[64][64];

	GameInstance players;

	public void GameRenderer() {

	}

	public void GameRenderer(char[][] map, GameInstance players) {
		this.map = map;
		this.players = players;

	}

	// @override
	public void paint(Graphics g) {
		for (int i = 0; i < 63; i++) {
			for (int j = 0; i < 63; j++) {

				if (map[i][j] == 'g')// grass
					g.setColor(Color.GREEN);
				else if (map[i][j] == 'l')
					g.setColor(Color.BLUE);
				else if (map[i][j] == 'm')
					g.setColor(Color.darkGray);
				else if (map[i][j] == 'h')
					g.setColor(Color.lightGray);
				else
					g.setColor(Color.BLACK);
				g.fillRect(i * 10, i * 10, i * 10 + 10, j * 10 + 10);
				
				
			}
		}

		for (int i=0; i<7;i++){
			int x=0;
			int y=0;
			x=players.tanks.get(i).xCoord;
			y=players.tanks.get(i).yCoord;
			g.setColor(Color.MAGENTA);
			g.fillRect(x*10, y*10, 10, 10);
		}
	}

}
