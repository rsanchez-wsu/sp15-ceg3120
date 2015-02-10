package team6;

import java.awt.*;
import javax.swing.*;
import java.util.*;
//This class will render a 64x64 array representing a map, and a array
//of TankObjects, representing players.

//will update to render only 24x16 squares at a time, scrollable through arrowkeys.


public class GameRenderer extends JPanel {

	char[][] map = new char[64][64];
	GameInstance players;
	int xFov=24;
	int yFov=16;
	int tileSize=50;


	public GameRenderer() {
		for(int i=0; i<64 ; i++){
			for (int j=0; j<64; j++){
				
				int temp= (int) (Math.random()*30);
				System.out.println(temp);
				if (temp<=15)				
				map[i][j]='g';
				else if (temp<=23)
					map[i][j]='h';
				else if (temp<=26)
					map[i][j]='m';
				else
					map[i][j]='l';
			}
		}		
		players=new GameInstance(); //temp fake constructor
	}

	public GameRenderer(char[][] map, GameInstance players) {
		this.map = map;
		this.players = players;

	}

	// @override
	public void paint(Graphics g) {
		for (int i = 0; i < 64; i++) {
			for (int j = 0; j < 64; j++) {
				
				if (map[i][j] == 'g')
					g.setColor(new Color(10,100,26));// grass
				else if (map[i][j] == 'l')
					g.setColor(new Color(25,35,165));//lake
				else if (map[i][j] == 'm')
					g.setColor(new Color(90,95,100));//mountain
				else if (map[i][j] == 'h')
					g.setColor(new Color(125,90,65));//hill
				else
					g.setColor(Color.BLACK);//bad color
				
				
				g.fillRect(i * tileSize, j * tileSize, tileSize,tileSize);				
			}
		}

		for (int i=0; i<7;i++){
			int x=0;
			int y=0;
			x=players.tanks.get(i).xCoord;
			y=players.tanks.get(i).yCoord;
			g.setColor(Color.RED);
			g.fillRect(x*tileSize, y*tileSize, tileSize, tileSize);
		}
	}

}
