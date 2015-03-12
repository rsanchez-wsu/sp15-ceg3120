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
	
	int mapXSize = 64;
	int mapYSize = 64;
	char[][] map = new char[mapXSize][mapYSize];
	char[][] mapDetails = new char[mapXSize][mapYSize];
	GameInstance players;
	int xFov=24;  //not used yet
	int yFov=16; //not used yet
	int tileSize=50;  //must be updated here and in driver
	Image tank = null;
	Image grass = null;
	Image lake = null;
	Image mountain = null;
	Image hill = null;
	
	Image treeTL = null;
	Image treeTM = null;
	Image treeTR = null;
	Image treeML = null;
	Image treeMM = null;	
	Image treeMR = null;
	Image treeBL = null;
	Image treeBM = null;
	Image treeBR = null;

	Image grassTL = null;
	Image grassTM = null;
	Image grassTR = null;
	Image grassML = null;
	Image grassMM = null;
	Image grassMR = null;
	Image grassBL = null;
	Image grassBM = null;
	Image grassBR = null;

	Image mudTL = null;
	Image mudTM = null;
	Image mudTR = null;
	Image mudML = null;
	Image mudMM = null;
	Image mudMR = null;
	Image mudBL = null;
	Image mudBM = null;
	Image mudBR = null;
	
	Image waterTL = null;
	Image waterTM = null;
	Image waterTR = null;
	Image waterML = null;
	Image waterMM = null;
	Image waterMR = null;
	Image waterBL = null;
	Image waterBM = null;
	Image waterBR = null;
	
	Image mountainTL = null;
	Image mountainTM = null;
	Image mountainTR = null;
	Image mountainML = null;
	Image mountainMM = null;
	Image mountainMR = null;
	Image mountainBL = null;
	Image mountainBM = null;
	Image mountainBR = null;
	
	public GameRenderer() {
		
		buildBasicMap();
		buildDetailMap();
		players = new GameInstance(); //temp fake constructor
		
		try {                
	        tank = ImageIO.read(new File("./src/team6/images/tank.png"));
	        mountain = ImageIO.read(new File("./src/team6/images/mountain.png"));
	        hill = ImageIO.read(new File("./src/team6/images/hill.png"));
	        lake = ImageIO.read(new File("./src/team6/images/lake.png"));
	        grass = ImageIO.read(new File("./src/team6/images/grass.png"));
	        
	        
	        treeTL = ImageIO.read(new File("./src/team6/images/tree_tl.jpg"));
	        treeTM = ImageIO.read(new File("./src/team6/images/tree_tm.jpg"));
	        treeTR = ImageIO.read(new File("./src/team6/images/tree_tr.jpg"));
	        treeML = ImageIO.read(new File("./src/team6/images/tree_ml.jpg"));
	        treeMM = ImageIO.read(new File("./src/team6/images/tree_mm.jpg"));
	        treeMR = ImageIO.read(new File("./src/team6/images/tree_mr.jpg"));
	        treeBL = ImageIO.read(new File("./src/team6/images/tree_bl.jpg"));
	        treeBM = ImageIO.read(new File("./src/team6/images/tree_bm.jpg"));
	        treeBR = ImageIO.read(new File("./src/team6/images/tree_br.jpg"));
	        
	        grassTL = ImageIO.read(new File("./src/team6/images/grass_tl.jpg"));
	        grassTM = ImageIO.read(new File("./src/team6/images/grass_tm.jpg"));
	        grassTR = ImageIO.read(new File("./src/team6/images/grass_tr.jpg"));
	        grassML = ImageIO.read(new File("./src/team6/images/grass_ml.jpg"));
	        grassMM = ImageIO.read(new File("./src/team6/images/grass_mm.jpg"));
	        grassMR = ImageIO.read(new File("./src/team6/images/grass_mr.jpg"));
	        grassBL = ImageIO.read(new File("./src/team6/images/grass_bl.jpg"));
	        grassBM = ImageIO.read(new File("./src/team6/images/grass_bm.jpg"));
	        grassBR = ImageIO.read(new File("./src/team6/images/grass_br.jpg"));
	        
	        mudTL = ImageIO.read(new File("./src/team6/images/mud_tl.jpg"));
	        mudTM = ImageIO.read(new File("./src/team6/images/mud_tm.jpg"));
	        mudTR = ImageIO.read(new File("./src/team6/images/mud_tr.jpg"));
	        mudML = ImageIO.read(new File("./src/team6/images/mud_ml.jpg"));
	        mudMM = ImageIO.read(new File("./src/team6/images/mud_mm.jpg"));
	        mudMR = ImageIO.read(new File("./src/team6/images/mud_mr.jpg"));
	        mudBL = ImageIO.read(new File("./src/team6/images/mud_bl.jpg"));
	        mudBM = ImageIO.read(new File("./src/team6/images/mud_bm.jpg"));
	        mudBR = ImageIO.read(new File("./src/team6/images/mud_br.jpg"));

	        waterTL = ImageIO.read(new File("./src/team6/images/water_tl.jpg"));
	        waterTM = ImageIO.read(new File("./src/team6/images/water_tm.jpg"));
	        waterTR = ImageIO.read(new File("./src/team6/images/water_tr.jpg"));
	        waterML = ImageIO.read(new File("./src/team6/images/water_ml.jpg"));
	        waterMM = ImageIO.read(new File("./src/team6/images/water_mm.jpg"));
	        waterMR = ImageIO.read(new File("./src/team6/images/water_mr.jpg"));
	        waterBL = ImageIO.read(new File("./src/team6/images/water_bl.jpg"));
	        waterBM = ImageIO.read(new File("./src/team6/images/water_bm.jpg"));
	        waterBR = ImageIO.read(new File("./src/team6/images/water_br.jpg"));
	        
	        mountainTL = ImageIO.read(new File("./src/team6/images/mountain_tl.jpg"));
	        mountainTM = ImageIO.read(new File("./src/team6/images/mountain_tm.jpg"));
	        mountainTR = ImageIO.read(new File("./src/team6/images/mountain_tr.jpg"));
	        mountainML = ImageIO.read(new File("./src/team6/images/mountain_ml.jpg"));
	        mountainMM = ImageIO.read(new File("./src/team6/images/mountain_mm.jpg"));
	        mountainMR = ImageIO.read(new File("./src/team6/images/mountain_mr.jpg"));
	        mountainBL = ImageIO.read(new File("./src/team6/images/mountain_bl.jpg"));
	        mountainBM = ImageIO.read(new File("./src/team6/images/mountain_bm.jpg"));
	        mountainBR = ImageIO.read(new File("./src/team6/images/mountain_br.jpg"));
	        
	       } catch (IOException ex) {
	    	   System.out.println(ex);
	    	   // handle exception...
	       } 
	}

	public GameRenderer(char[][] map, GameInstance players) {
		this.map = map;
		this.players = players;

	}
	
	private void buildBasicMap(){
		
		for(int i = 0; i < mapXSize; i++){
			for (int j = 0; j < mapYSize; j++){
				
				int rand = (int)(Math.random() * 100);	//generate random terrain			
				
				// movable terrain   : 60%
				// immovable terrain : 40%
				if(rand < 20)	  // tree
					map[i][j] = 't';
				else if(rand < 40)// grass
					map[i][j] = 'g';
				else if(rand < 60)// mud
					map[i][j] = 'u';
				else if(rand < 80)// water
					map[i][j] = 'w';
				else			  // mountain
					map[i][j] = 'm';
			}
		}
	}// end buildBasiceMap()
	
	private void buildDetailMap(){
		
		boolean isT = false;
		boolean isR = false;
		boolean isB = false;
		boolean isL = false;
		
		// step through map array checking if neighboring terrain matches current terrain
		for(int i = 0; i < mapXSize; i++){
			for(int j = 0; j < mapYSize; j++){
				
				// check up
				if(j == 0 || map[i][j] != map[i][j - 1]){
					isT = true;
				}
				// check right
				if(i == mapXSize - 1 || map[i][j] != map[i + 1][j]){
					isR = true;
				}
				// check bottom
				if(j == mapYSize - 1 || map[i][j] != map[i][j + 1])
					isB = true;
				
				// check left
				if(i == 0 || map[i][j] != map[i - 1][j])
					isL = true;
				
				if(isT)
					if(isR)
						if(isB)
							if(isL)// lonely all (fill with TM)
								mapDetails[i][j] = 'w';
							else	// lonely right (MR)
								mapDetails[i][j] = 'd';
						else
							if(isL)// TM
								mapDetails[i][j] = 'w';
							else	// TR
								mapDetails[i][j] = 'e';
					else
						if(isB)
							if(isL)// lonely left (fill with ML)
								mapDetails[i][j] = 'a';
							else	// LR tunnel (fill with BM)
								mapDetails[i][j] = 'x';
						else
							if(isL)// TL
								mapDetails[i][j] = 'q';
							else	// lonely top (fill with TM)
								mapDetails[i][j] = 'w';
				else
					if(isR)
						if(isB)
							if(isL)// lonely bottom (fill with BM)
								mapDetails[i][j] = 'x';
							else	// BR
								mapDetails[i][j] = 'c';
						else
							if(isL)// TB tunnel (fill with ML)
								mapDetails[i][j] = 'a';
							else	// lonely right (fill with MR)
								mapDetails[i][j] = 'd';
					else
						if(isB)
							if(isL)// BL
								mapDetails[i][j] = 'z';
							else	// BM
								mapDetails[i][j] = 'x';
						else
							if(isL)// ML
								mapDetails[i][j] = 'a';
							else	// MM
								mapDetails[i][j] = 's';
							
				isT = false;
				isR = false;
				isB = false;
				isL = false;
				
			}
		}// end for loop
	}// end buildDetailMap()
	
	// @override
	public void paint(Graphics g) {
		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapYSize; j++) {
				
				if(map[i][j] == 't'){// terrain is trees
					if(mapDetails[i][j] == 'q')
						g.drawImage(treeTL, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'w')
						g.drawImage(treeTM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'e')
						g.drawImage(treeTR, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'a')
						g.drawImage(treeML, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 's')
						g.drawImage(treeMM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'd')
						g.drawImage(treeMR, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'z')
						g.drawImage(treeBL, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'x')
						g.drawImage(treeBM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'c')
						g.drawImage(treeBR, i * tileSize, j * tileSize, tileSize, tileSize, null);
				}
				else if(map[i][j] == 'g'){// terrain is grass
					if(mapDetails[i][j] == 'q')
						g.drawImage(grassTL, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'w')
						g.drawImage(grassTM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'e')
						g.drawImage(grassTR, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'a')
						g.drawImage(grassML, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 's')
						g.drawImage(grassMM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'd')
						g.drawImage(grassMR, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'z')
						g.drawImage(grassBL, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'x')
						g.drawImage(grassBM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'c')
						g.drawImage(grassBR, i * tileSize, j * tileSize, tileSize, tileSize, null);
				}
				else if(map[i][j] == 'u'){// terrain is mud
					if(mapDetails[i][j] == 'q')
						g.drawImage(mudTL, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'w')
						g.drawImage(mudTM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'e')
						g.drawImage(mudTR, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'a')
						g.drawImage(mudML, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 's')
						g.drawImage(mudMM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'd')
						g.drawImage(mudMR, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'z')
						g.drawImage(mudBL, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'x')
						g.drawImage(mudBM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'c')
						g.drawImage(mudBR, i * tileSize, j * tileSize, tileSize, tileSize, null);
				}
				else if(map[i][j] == 'w'){// terrain is water
					if(mapDetails[i][j] == 'q')
						g.drawImage(waterTL, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'w')
						g.drawImage(waterTM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'e')
						g.drawImage(waterTR, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'a')
						g.drawImage(waterML, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 's')
						g.drawImage(waterMM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'd')
						g.drawImage(waterMR, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'z')
						g.drawImage(waterBL, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'x')
						g.drawImage(waterBM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'c')
						g.drawImage(waterBR, i * tileSize, j * tileSize, tileSize, tileSize, null);
				}
				else if(map[i][j] == 'm'){// terrain is mountain
					if(mapDetails[i][j] == 'q')
						g.drawImage(mountainTL, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'w')
						g.drawImage(mountainTM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'e')
						g.drawImage(mountainTR, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'a')
						g.drawImage(mountainML, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 's')
						g.drawImage(mountainMM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'd')
						g.drawImage(mountainMR, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'z')
						g.drawImage(mountainBL, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'x')
						g.drawImage(mountainBM, i * tileSize, j * tileSize, tileSize, tileSize, null);
					else if(mapDetails[i][j] == 'c')
						g.drawImage(mountainBR, i * tileSize, j * tileSize, tileSize, tileSize, null);
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
		
		
	}// end paint()

}
