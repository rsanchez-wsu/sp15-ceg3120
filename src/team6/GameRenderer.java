package team6;

import java.awt.*;

import javax.swing.*;

import javax.imageio.*;
import java.io.*;
//import java.util.*;
//This class will render a 64x64 array representing a map, and a array
//of TankObjects, representing players.

//will update to render only 24x16 squares at a time, scrollable through arrowkeys.

// ????? Pass tileSize from driver ?????

@SuppressWarnings("serial")
public class GameRenderer extends JPanel {

	char[][] map = new char[64][64];
	GameInstance players;
	int xFov=24;  //not used yet
	int yFov=16; //not used yet
	int tileSize=50;  //must be updated here and in driver
	Image tank = null;
	Image grass = null;
	Image lake = null;
	Image mountain = null;
	Image hill = null;


	public GameRenderer() {
		for(int i=0; i<64 ; i++){
			for (int j=0; j<64; j++){				
				int temp= (int) (Math.random()*30);	//gen random terrain			
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
		
		try {                
	        tank = ImageIO.read(new File("./src/team6/tank.png"));
	        mountain = ImageIO.read(new File("./src/team6/mountain.png"));
	        hill = ImageIO.read(new File("./src/team6/hill.png"));
	        lake = ImageIO.read(new File("./src/team6/lake.png"));
	        grass = ImageIO.read(new File("./src/team6/grass.png"));
	       } catch (IOException ex) {
	    	   System.out.println(ex);
	    	   // handle exception...
	       } 
	}

	public GameRenderer(char[][] map, GameInstance players) {
		this.map = map;
		this.players = players;

	}

	// @override
	public void paint(Graphics g) {
		for (int i = 0; i < 64; i++) {
			for (int j = 0; j < 64; j++) {
				
				if (map[i][j] == 'g'){// grass
					//g.setColor(new Color(10,100,26));
					//g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
					g.drawImage(grass, i*tileSize, j*tileSize, tileSize, tileSize, null);
				}
				else if (map[i][j] == 'l'){//lake
					//g.setColor(new Color(25,35,165));
					//g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
					g.drawImage(lake, i * tileSize, j * tileSize, tileSize, tileSize, null);
				}
				else if (map[i][j] == 'm'){//mountain
					//g.setColor(new Color(90,95,100));
					//g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
					g.drawImage(mountain, i * tileSize, j * tileSize, tileSize, tileSize, null);
				}
				else if (map[i][j] == 'h'){//hill
					//g.setColor(new Color(125,90,65));
					//g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
					g.drawImage(hill, i * tileSize, j * tileSize, tileSize, tileSize, null);
					
				}
				else{//bad color
					g.setColor(Color.BLACK);
					g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
				}
				
								
			}
		}

		for (int i=0; i<7;i++){
			int x=0;
			int y=0;
			x=players.tanks.get(i).xCoord;
			y=players.tanks.get(i).yCoord;
			//g.setColor(Color.RED);
			//g.fillRect(x*tileSize, y*tileSize, tileSize, tileSize);
			g.drawImage(tank, x*tileSize, y*tileSize, tileSize, tileSize, null);
		}
		
		
	}

}
