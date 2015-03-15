/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 *  Copyright (C) <2015>  <Team 6>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package team6;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameMap {

	int mapXSize = 64;
	int mapYSize = 64;
	char[][] baseLayer = new char[mapXSize][mapYSize];
	char[][] topLayer = new char[mapXSize][mapYSize];
	char[][] spriteStyle = new char[mapXSize][mapYSize];	
	
	int timesExpanded = 0;// used to limit recursive terrain feature growth
	boolean[][] expanded = new boolean[mapXSize][mapYSize];// used for recursive growth limiting
	int debugCounter = 0;
	
	Image tank = null;
	Image grass = null;
	Image mud = null;
	
	Image treeTL = null;
	Image treeTM = null;
	Image treeTR = null;
	Image treeML = null;
	Image treeMM = null;	
	Image treeMR = null;
	Image treeBL = null;
	Image treeBM = null;
	Image treeBR = null;
	Image treeAA = null;
	Image treeAT = null;
	Image treeAR = null;
	Image treeAL = null;
	Image treeAB = null;
	Image treeUDT = null;
	Image treeLRT = null;

	Image waterTL = null;
	Image waterTM = null;
	Image waterTR = null;
	Image waterML = null;
	Image waterMM = null;
	Image waterMR = null;
	Image waterBL = null;
	Image waterBM = null;
	Image waterBR = null;
	Image waterAA = null;
	Image waterAT = null;
	Image waterAL = null;
	Image waterAR = null;
	Image waterAB = null;
	Image waterLRT = null;
	Image waterUDT = null;
	
	Image waterCBL = null;
	Image waterCBR = null;
	Image waterCTL = null;
	Image waterCTR = null;
	
	Image mountainTL = null;
	Image mountainTM = null;
	Image mountainTR = null;
	Image mountainML = null;
	Image mountainMM = null;
	Image mountainMR = null;
	Image mountainBL = null;
	Image mountainBM = null;
	Image mountainBR = null;
	
	public GameMap(){
		
		findFiles();
		buildBaseLayer();
		buildTopLayer();
		buildSpriteStyle();
	}// end GameMap()
	
	
	private void findFiles(){
		
		try {                
	        tank = ImageIO.read(new File("./src/team6/images/tank.png"));
	        grass = ImageIO.read(new File("./src/team6/images/grass.jpg"));
	        mud = ImageIO.read(new File("./src/team6/images/mud.jpg"));
	        
	        treeTL = ImageIO.read(new File("./src/team6/images/tree_tl.jpg"));
	        treeTM = ImageIO.read(new File("./src/team6/images/tree_tm.jpg"));
	        treeTR = ImageIO.read(new File("./src/team6/images/tree_tr.jpg"));
	        treeML = ImageIO.read(new File("./src/team6/images/tree_ml.jpg"));
	        treeMM = ImageIO.read(new File("./src/team6/images/tree_mm.jpg"));
	        treeMR = ImageIO.read(new File("./src/team6/images/tree_mr.jpg"));
	        treeBL = ImageIO.read(new File("./src/team6/images/tree_bl.jpg"));
	        treeBM = ImageIO.read(new File("./src/team6/images/tree_bm.jpg"));
	        treeBR = ImageIO.read(new File("./src/team6/images/tree_br.jpg"));
	        treeAA = ImageIO.read(new File("./src/team6/images/tree_aa.jpg"));
	        treeAT = ImageIO.read(new File("./src/team6/images/tree_at.jpg"));
	        treeAL = ImageIO.read(new File("./src/team6/images/tree_al.jpg"));
	        treeAR = ImageIO.read(new File("./src/team6/images/tree_ar.jpg"));
	        treeAB = ImageIO.read(new File("./src/team6/images/tree_ab.jpg"));
	        treeUDT = ImageIO.read(new File("./src/team6/images/tree_udt.jpg"));
	        treeLRT = ImageIO.read(new File("./src/team6/images/tree_lrt.jpg"));
	        
	        waterTL = ImageIO.read(new File("./src/team6/images/water_tl.jpg"));
	        waterTM = ImageIO.read(new File("./src/team6/images/water_tm.jpg"));
	        waterTR = ImageIO.read(new File("./src/team6/images/water_tr.jpg"));
	        waterML = ImageIO.read(new File("./src/team6/images/water_ml.jpg"));
	        waterMM = ImageIO.read(new File("./src/team6/images/water_mm.jpg"));
	        waterMR = ImageIO.read(new File("./src/team6/images/water_mr.jpg"));
	        waterBL = ImageIO.read(new File("./src/team6/images/water_bl.jpg"));
	        waterBM = ImageIO.read(new File("./src/team6/images/water_bm.jpg"));
	        waterBR = ImageIO.read(new File("./src/team6/images/water_br.jpg"));
	        waterAA = ImageIO.read(new File("./src/team6/images/water_aa.jpg"));
	        waterAT = ImageIO.read(new File("./src/team6/images/water_at.jpg"));
	        waterAL = ImageIO.read(new File("./src/team6/images/water_al.jpg"));
	        waterAR = ImageIO.read(new File("./src/team6/images/water_ar.jpg"));
	        waterAB = ImageIO.read(new File("./src/team6/images/water_ab.jpg"));
	        waterLRT = ImageIO.read(new File("./src/team6/images/water_lrt.jpg"));
	    	waterUDT = ImageIO.read(new File("./src/team6/images/water_udt.jpg"));
	    	
	    	waterCBL = ImageIO.read(new File("./src/team6/images/water_cbl.png"));
	    	waterCBR = ImageIO.read(new File("./src/team6/images/water_cbr.png"));
	    	waterCTL = ImageIO.read(new File("./src/team6/images/water_ctl.png"));
	    	waterCTR = ImageIO.read(new File("./src/team6/images/water_ctr.png"));
	        
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
	}// end findFiles()

	private void buildBaseLayer() {
		
		for (int i = 0; i < mapXSize; i++){
			for (int j = 0; j < mapYSize; j++){
				
				int rand = (int)(Math.random() * 1000);
				if(rand < 5)
					baseLayer[i][j] = 'u';
				else
					baseLayer[i][j] = 'g';
			}
		}
			
		expandFeature('u', baseLayer, 70, 5);
		
	}// end buildBaseLayer()

	private void buildTopLayer(){
		/*
		 * 		TERRAIN TYPE TABLE
		 * 	-char-			   -type-
		 * 	  t					tree
		 *    m					mountain
		 * 	  u					mud
		 * 	  w					water
		 * 	  g					grass
		 */
		
		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapYSize; j++) {

				int rand = (int)(Math.random() * 1000);// generate random terrain

				if(rand > 0 && rand < 4) 		// tree
					topLayer[i][j] = 't';
				else if(rand > 100 && rand < 104)	// mountain
					topLayer[i][j] = 'm';
				else if(rand > 200 && rand < 204)	// water
					topLayer[i][j] = 'w';
				else
					topLayer[i][j] = baseLayer[i][j];
			}
		}// end for loop

		expandFeature('m', topLayer, 80, 5);
		expandFeature('w', topLayer, 75, 5);
		expandFeature('t', topLayer, 70, 5);
	}// end buildTopLayer()
	
	private void buildSpriteStyle(){
		/*
		 *  TERRAIN STYLE TABLE:
		 *	-char-		   -MEANING-
		 *	  q				Top-Left
		 *    w				Top-Middle
		 *    e				Top-Right
		 *    a				Middle-Right
		 *    s				Middle-Middle
		 *    d				Middle-Right
		 *    z				Bottom-Left
		 *    x				Bottom-Middle
		 *    c				Bottom-Right
		 *    v				Alone-Alone
		 *    r				Alone-Top
		 *    t				Alone-Left
		 *    y				Alone-Right
		 *    u				Alone-Bottom
		 *    f				Left-Right Tunnel
		 *    g				Up-Down Tunnel
		 */
		
		boolean isT = false;
		boolean isR = false;
		boolean isB = false;
		boolean isL = false;
		
		// step through map array checking if neighboring terrain matches current terrain
		for(int i = 0; i < mapXSize; i++){
			for(int j = 0; j < mapYSize; j++){
				
				isT = (j == 0 || topLayer[i][j] != topLayer[i][j - 1]);
				isR = (i == mapXSize - 1 || topLayer[i][j] != topLayer[i + 1][j]);
				isB = (j == mapYSize - 1 || topLayer[i][j] != topLayer[i][j + 1]);
				isL = (i == 0 || topLayer[i][j] != topLayer[i - 1][j]);
				
				if(isT)
					if(isR)
						if(isB)
							if(isL)// AA
								spriteStyle[i][j] = 'v';
							else	// AR
								spriteStyle[i][j] = 'y';
						else
							if(isL)// AT
								spriteStyle[i][j] = 'r';
							else	// TR
								spriteStyle[i][j] = 'e';
					else
						if(isB)
							if(isL)// AL
								spriteStyle[i][j] = 't';
							else	// LRT
								spriteStyle[i][j] = 'f';
						else
							if(isL)// TL
								spriteStyle[i][j] = 'q';
							else	// TM
								spriteStyle[i][j] = 'w';
				else
					if(isR)
						if(isB)
							if(isL)// AB
								spriteStyle[i][j] = 'u';
							else	// BR
								spriteStyle[i][j] = 'c';
						else
							if(isL)// UDT
								spriteStyle[i][j] = 'g';
							else	// MR
								spriteStyle[i][j] = 'd';
					else
						if(isB)
							if(isL)// BL
								spriteStyle[i][j] = 'z';
							else	// BM
								spriteStyle[i][j] = 'x';
						else
							if(isL)// ML
								spriteStyle[i][j] = 'a';
							else	// MM
								spriteStyle[i][j] = 's';
							
				isT = false;
				isR = false;
				isB = false;
				isL = false;
				
			}
		}// end for loop
	}// end buildSpriteStyle()
	
	private void expandFeature(char type, char[][] layer, int randomBase, int randomIncrease) {
		zeroRecursiveVars();

		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapXSize; j++) {
				if (layer[i][j] == type) {
					recursiveTrees(i, j, 0, type, layer, randomBase, randomIncrease);                                     
				}
			}// end
		}// end
	}// end expandFeature()

	private void recursiveTrees(int y, int x, int count, char type, char[][] layer, int randomBase,int randomIncrease) {
		
		if (y < 0 || x < 0 || y > mapYSize - 1 || x > mapXSize - 1)
			return;
		if (!expanded[y][x]) {
			layer[y][x]=type;
			for (int k = -1; k <= 1; k++) {
				for (int l = -1; l <= 1; l++) {
					int rand = (int) (Math.random() * 100);
					if (rand > randomBase+(4*count)){
						recursiveTrees(k+y, l+x, count++, type,layer,randomBase, randomIncrease);//increments count
						if (!(k+y<0 || l+x<0 ||k+y>mapYSize-1||l+x>mapXSize-1))
							expanded[k+y][l+x] = true;
						debugCounter++;}//end if
				}//end inner for
			}//end outer for
		}// end if
	}// end recursiveTrees()

	private void zeroRecursiveVars() {
		timesExpanded = 0;
		for (int i = 0; i < mapYSize; i++) {
			for (int j = 0; j < mapXSize; j++) {
				expanded[i][j] = false;
			}
		}// end for loop
	}// zeroRecursiveVars()

	public Image getTerrain(char mapPos, char style){
		
		Image result = null;
		
		if(mapPos == 't'){// terrain is trees
			switch(style){
				case 'q' : result = treeTL;
							break;
				case 'w' : result = treeTM;
							break;
				case 'e' : result = treeTR;
							break;
				case 'a' : result = treeML;
							break;
				case 's' : result = treeMM;
							break;
				case 'd' : result = treeMR;
							break;
				case 'z' : result = treeBL;
							break;
				case 'x' : result = treeBM;
							break;
				case 'c' : result = treeBR;
							break;
				case 'v' : result = treeAA;
							break;
				case 'r' : result = treeAT;
							break;
				case 't' : result = treeAL;
							break;
				case 'y' : result = treeAR;
							break;
				case 'u' : result = treeAB;
							break;
				case 'f' : result = treeLRT;
							break;
				case 'g' : result = treeUDT;
							break;
				default : result = treeMM;
			}
		}
		else if(mapPos == 'w'){// terrain is water
			switch(style){
				case 'q' : result = waterTL;
							break;
				case 'w' : result = waterTM;
							break;
				case 'e' : result = waterTR;
							break;
				case 'a' : result = waterML;
							break;
				case 's' : result = waterMM;
							break;
				case 'd' : result = waterMR;
							break;
				case 'z' : result = waterBL;
							break;
				case 'x' : result = waterBM;
							break;
				case 'c' : result = waterBR;
							break;
				case 'v' : result = waterAA;
							break;
				case 'r' : result = waterAT;
							break;
				case 't' : result = waterAL;
							break;
				case 'y' : result = waterAR;
							break;
				case 'u' : result = waterAB;
							break;
				case 'f' : result = waterLRT;
							break;
				case 'g' : result = waterUDT;
							break;
				default : result = waterMM;
			}
		}
		else if(mapPos == 'm'){// terrain is mountain
			switch(style){
				case 'q' : result = mountainTL;
							break;
				case 'w' : result = mountainTM;
							break;
				case 'e' : result = mountainTR;
							break;
				case 'a' : result = mountainML;
							break;
				case 's' : result = mountainMM;
							break;
				case 'd' : result = mountainMR;
							break;
				case 'z' : result = mountainBL;
							break;
				case 'x' : result = mountainBM;
							break;
				case 'c' : result = mountainBR;
							break;
				default : result = mountainMM;
			}
		}
		else if(mapPos == 'g'){// terrain is grass
			result = grass;
		}
		else if(mapPos == 'u'){// terrain is mud
			result = mud;
		}
		
		return result;
	}// end getTerrain()
	
	public Image getTank(int playerNum){
	
		return tank;
	}

}// end GameMap Class
