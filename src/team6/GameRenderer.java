package team6;

import java.awt.*;

import javax.swing.*;

import javax.imageio.*;
import java.io.*;
//import java.util.*;
//This class will render a 64x64 array representing a map, and a array
//of TankObjects, representing players.

//will update to render only 24x16 squares at a time, scrollable through arrowkeys.


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
	        tank = ImageIO.read(new File("/tank.png"));
	        mountain = ImageIO.read(new File("/gravel.png"));
	        hill = ImageIO.read(new File("/dirt.png"));
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
				
				if (map[i][j] == 'g'){
					//g.setColor(new Color(10,100,26));// grass
					g.drawImage(mountain, i*tileSize, j*tileSize, null);
				}
				else if (map[i][j] == 'l'){
					g.setColor(new Color(25,35,165));//lake
					g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
					//g.drawImage(mountain, i * tileSize, j * tileSize, tileSize, tileSize, null);
				}
				else if (map[i][j] == 'm'){
					g.setColor(new Color(90,95,100));//mountain
					g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
					//g.drawImage(mountain, i * tileSize, j * tileSize, tileSize, tileSize, null);
				}
				else if (map[i][j] == 'h'){
					//g.setColor(new Color(125,90,65));//hill
					//g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
					g.drawImage(hill, i * tileSize, j * tileSize, tileSize, tileSize, null);
				}
				else{
					g.setColor(Color.BLACK);//bad color
					g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
					//g.drawImage(mountain, i * tileSize, j * tileSize, tileSize, tileSize, null);
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
