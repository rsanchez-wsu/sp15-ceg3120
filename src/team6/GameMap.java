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
	char[][] corners = new char[mapXSize][mapYSize];
	
	int timesExpanded = 0;// used to limit recursive terrain feature growth
	boolean[][] expanded = new boolean[mapXSize][mapYSize];// used for recursive
															// growth limiting

	private Image tank = null;
	private Image grass = null;
	private Image mud = null;

	private Image treeTL = null;
	private Image treeTM = null;
	private Image treeTR = null;
	private Image treeML = null;
	private Image treeMM = null;
	private Image treeMR = null;
	private Image treeBL = null;
	private Image treeBM = null;
	private Image treeBR = null;
	private Image treeAA = null;
	private Image treeAT = null;
	private Image treeAR = null;
	private Image treeAL = null;
	private Image treeAB = null;
	private Image treeUDT = null;
	private Image treeLRT = null;

	private Image waterTL = null;
	private Image waterTM = null;
	private Image waterTR = null;
	private Image waterML = null;
	private Image waterMM = null;
	private Image waterMR = null;
	private Image waterBL = null;
	private Image waterBM = null;
	private Image waterBR = null;
	private Image waterAA = null;
	private Image waterAT = null;
	private Image waterAL = null;
	private Image waterAR = null;
	private Image waterAB = null;
	private Image waterLRT = null;
	private Image waterUDT = null;

	private Image waterCTL = null;
	private Image waterCTR = null;
	private Image waterCBL = null;
	private Image waterCBR = null;
	private Image waterCTLTR = null;
	private Image waterCTLBL = null;
	private Image waterCTLBR = null;
	private Image waterCTRBL = null;
	private Image waterCTRBR = null;
	private Image waterCBLBR = null;
	private Image waterCTLTRBL = null;
	private Image waterCTLTRBR = null;
	private Image waterCTLBLBR = null;
	private Image waterCTRBLBR = null;
	private Image waterCTLTRBLBR = null;
	
	private Image mountainTL = null;
	private Image mountainTM = null;
	private Image mountainTR = null;
	private Image mountainML = null;
	private Image mountainMM = null;
	private Image mountainMR = null;
	private Image mountainBL = null;
	private Image mountainBM = null;
	private Image mountainBR = null;
	private Image mountainAA = null;
	private Image mountainAT = null;
	private Image mountainAR = null;
	private Image mountainAB = null;
	private Image mountainAL = null;
	private Image mountainUDT = null;
	private Image mountainLRT = null;
	
	public GameMap() {
		findFiles();
		generateBlankLayers();
		
	}// end GameMap()

	public void generateMap(){		
		
		buildBaseLayer();
		buildTopLayer();
		buildSpriteStyle();
		buildCorners();
	}// end generateMap()
	
	private void generateBlankLayers(){
		
		for(int i = 0; i < mapXSize; i++){
			for(int j = 0; j < mapYSize; j++){
				baseLayer[i][j] = '?';
				topLayer[i][j] = '?';
				spriteStyle[i][j] = '?';
				corners[i][j] = '?';
			}
		}
	}// end generateBlankLayers()
	
	private void findFiles() {

		try {
			tank = ImageIO.read(new File("./src/team6/images/tank.png"));
			grass = ImageIO.read(new File("./src/team6/images/grass.jpg"));
			mud = ImageIO.read(new File("./src/team6/images/mud.jpg"));

			treeTL = ImageIO.read(new File("./src/team6/images/tree_tl.png"));
			treeTM = ImageIO.read(new File("./src/team6/images/tree_tm.png"));
			treeTR = ImageIO.read(new File("./src/team6/images/tree_tr.png"));
			treeML = ImageIO.read(new File("./src/team6/images/tree_ml.png"));
			treeMM = ImageIO.read(new File("./src/team6/images/tree_mm.png"));
			treeMR = ImageIO.read(new File("./src/team6/images/tree_mr.png"));
			treeBL = ImageIO.read(new File("./src/team6/images/tree_bl.png"));
			treeBM = ImageIO.read(new File("./src/team6/images/tree_bm.png"));
			treeBR = ImageIO.read(new File("./src/team6/images/tree_br.png"));
			treeAA = ImageIO.read(new File("./src/team6/images/tree_aa.png"));
			treeAT = ImageIO.read(new File("./src/team6/images/tree_at.png"));
			treeAL = ImageIO.read(new File("./src/team6/images/tree_al.png"));
			treeAR = ImageIO.read(new File("./src/team6/images/tree_ar.png"));
			treeAB = ImageIO.read(new File("./src/team6/images/tree_ab.png"));
			treeUDT = ImageIO.read(new File("./src/team6/images/tree_udt.png"));
			treeLRT = ImageIO.read(new File("./src/team6/images/tree_lrt.png"));

			waterTL = ImageIO.read(new File("./src/team6/images/water_tl.png"));
			waterTM = ImageIO.read(new File("./src/team6/images/water_tm.png"));
			waterTR = ImageIO.read(new File("./src/team6/images/water_tr.png"));
			waterML = ImageIO.read(new File("./src/team6/images/water_ml.png"));
			waterMM = ImageIO.read(new File("./src/team6/images/water_mm.png"));
			waterMR = ImageIO.read(new File("./src/team6/images/water_mr.png"));
			waterBL = ImageIO.read(new File("./src/team6/images/water_bl.png"));
			waterBM = ImageIO.read(new File("./src/team6/images/water_bm.png"));
			waterBR = ImageIO.read(new File("./src/team6/images/water_br.png"));
			waterAA = ImageIO.read(new File("./src/team6/images/water_aa.png"));
			waterAT = ImageIO.read(new File("./src/team6/images/water_at.png"));
			waterAL = ImageIO.read(new File("./src/team6/images/water_al.png"));
			waterAR = ImageIO.read(new File("./src/team6/images/water_ar.png"));
			waterAB = ImageIO.read(new File("./src/team6/images/water_ab.png"));
			waterLRT = ImageIO.read(new File("./src/team6/images/water_lrt.png"));
			waterUDT = ImageIO.read(new File("./src/team6/images/water_udt.png"));

			waterCTL = ImageIO.read(new File("./src/team6/images/water_ctl.png"));
			waterCTR = ImageIO.read(new File("./src/team6/images/water_ctr.png"));
			waterCBL = ImageIO.read(new File("./src/team6/images/water_cbl.png"));
			waterCBR = ImageIO.read(new File("./src/team6/images/water_cbr.png"));
			waterCTLTR = ImageIO.read(new File("./src/team6/images/water_ctl_tr.png"));
			waterCTLBL = ImageIO.read(new File("./src/team6/images/water_ctl_bl.png"));
			waterCTLBR = ImageIO.read(new File("./src/team6/images/water_ctl_br.png"));
			waterCTRBL = ImageIO.read(new File("./src/team6/images/water_ctr_bl.png"));
			waterCTRBR = ImageIO.read(new File("./src/team6/images/water_ctr_br.png"));
			waterCBLBR = ImageIO.read(new File("./src/team6/images/water_cbl_br.png"));
			waterCTLTRBL = ImageIO.read(new File("./src/team6/images/water_ctl_tr_bl.png"));
			waterCTLTRBR = ImageIO.read(new File("./src/team6/images/water_ctl_tr_br.png"));
			waterCTLBLBR = ImageIO.read(new File("./src/team6/images/water_ctl_bl_br.png"));
			waterCBLBR = ImageIO.read(new File("./src/team6/images/water_cbl_br.png"));
			waterCTLTRBLBR = ImageIO.read(new File("./src/team6/images/water_ctl_tr_bl_br.png"));

			mountainTL = ImageIO.read(new File(
					"./src/team6/images/mountain_tl.png"));
			mountainTM = ImageIO.read(new File(
					"./src/team6/images/mountain_tm.png"));
			mountainTR = ImageIO.read(new File(
					"./src/team6/images/mountain_tr.png"));
			mountainML = ImageIO.read(new File(
					"./src/team6/images/mountain_ml.png"));
			mountainMM = ImageIO.read(new File(
					"./src/team6/images/mountain_mm.png"));
			mountainMR = ImageIO.read(new File(
					"./src/team6/images/mountain_mr.png"));
			mountainBL = ImageIO.read(new File(
					"./src/team6/images/mountain_bl.png"));
			mountainBM = ImageIO.read(new File(
					"./src/team6/images/mountain_bm.png"));
			mountainBR = ImageIO.read(new File(
					"./src/team6/images/mountain_br.png"));
			mountainAA = ImageIO.read(new File(
					"./src/team6/images/mountain_aa.png"));
			mountainAT = ImageIO.read(new File(
					"./src/team6/images/mountain_at.png"));
			mountainAR = ImageIO.read(new File(
					"./src/team6/images/mountain_ar.png"));
			mountainAB = ImageIO.read(new File(
					"./src/team6/images/mountain_ab.png"));
			mountainAL = ImageIO.read(new File(
					"./src/team6/images/mountain_al.png"));
			mountainUDT = ImageIO.read(new File(
					"./src/team6/images/mountain_udt.png"));
			mountainLRT = ImageIO.read(new File(
					"./src/team6/images/mountain_lrt.png"));

		} catch (IOException ex){
			System.out.println(ex);
			// handle exception...
		}
	}// end findFiles()

	private void buildBaseLayer(){
		/*
		 * This conditional tree picks the probability for a 'seed' of each
		 * terrain type. Each 'seed' will be expanded into a cluster of terrain
		 * during the expandFeature() calls. each 64*64 map has 4,000 squares,
		 * so each 1 range in the conditional gives the terrain 4 'seeds' which
		 * will become clusters. i.e 100-103 will lead to 12 mountain ranges
		 */
		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapYSize; j++) {

				int rand = (int) (Math.random() * 1000);
				if (rand < 5)
					baseLayer[i][j] = 'u';
				else
					baseLayer[i][j] = 'g';
			}
		}

		expandFeature('u', baseLayer, 70, 5);

	}// end buildBaseLayer()

	private void buildTopLayer() {
		/*
		 * TERRAIN TYPE TABLE -char- -type- t tree m mountain u mud w water g
		 * grass
		 */

		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapYSize; j++) {
				/*
				 * This conditional tree picks the probability for a 'seed' of
				 * each terrain type. Each 'seed' will be expanded into a
				 * cluster of terrain during the expandFeature() calls. each
				 * 64*64 map has 4,000 squares, so each 1 range in the
				 * conditional gives the terrain 4 'seeds' which will become
				 * clusters. i.e 100-103 will lead to 12 mountain ranges
				 */
				int rand = (int) (Math.random() * 1000);// generate random

				if (rand > 0 && rand < 4) // tree
					topLayer[i][j] = 't';
				else if (rand > 100 && rand < 104) // mountain
					topLayer[i][j] = 'm';
				else if (rand > 200 && rand < 204) // water
					topLayer[i][j] = 'w';
				else
					topLayer[i][j] = baseLayer[i][j];
			}
		}// end for loop

		expandFeature('m', topLayer, 80, 5);
		expandFeature('w', topLayer, 75, 5);
		expandFeature('t', topLayer, 70, 5);
	}// end buildTopLayer()

	private void buildSpriteStyle() {
		/*
		 * TERRAIN STYLE TABLE: -char- -MEANING- 
		 * q Top-Left w Top-Middle e Top-Right 
		 * a Middle-Left s Middle-Middle d Middle-Right 
		 * z Bottom-Left x Bottom-Middle c Bottom-Right 
		 * v Alone-Alone r Alone-Top t Alone-Left
		 * y Alone-Right u Alone-Bottom f Left-Right Tunnel g Up-Down Tunnel
		 */

		boolean isT = false;
		boolean isR = false;
		boolean isB = false;
		boolean isL = false;

		// step through map array checking if neighboring terrain matches
		// current terrain
		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapYSize; j++) {

				isT = (j == 0 || topLayer[i][j] != topLayer[i][j - 1]);
				isR = (i == mapXSize - 1 || topLayer[i][j] != topLayer[i + 1][j]);
				isB = (j == mapYSize - 1 || topLayer[i][j] != topLayer[i][j + 1]);
				isL = (i == 0 || topLayer[i][j] != topLayer[i - 1][j]);

				if (isT)
					if (isR)
						if (isB)
							if (isL)// AA
								spriteStyle[i][j] = 'v';
							else
								// AR
								spriteStyle[i][j] = 'y';
						else if (isL)// AT
							spriteStyle[i][j] = 'r';
						else
							// TR
							spriteStyle[i][j] = 'e';
					else if (isB)
						if (isL)// AL
							spriteStyle[i][j] = 't';
						else
							// LRT
							spriteStyle[i][j] = 'f';
					else if (isL)// TL
						spriteStyle[i][j] = 'q';
					else
						// TM
						spriteStyle[i][j] = 'w';
				else if (isR)
					if (isB)
						if (isL)// AB
							spriteStyle[i][j] = 'u';
						else
							// BR
							spriteStyle[i][j] = 'c';
					else if (isL)// UDT
						spriteStyle[i][j] = 'g';
					else
						// MR
						spriteStyle[i][j] = 'd';
				else if (isB)
					if (isL)// BL
						spriteStyle[i][j] = 'z';
					else
						// BM
						spriteStyle[i][j] = 'x';
				else if (isL)// ML
					spriteStyle[i][j] = 'a';
				else
					// MM
					spriteStyle[i][j] = 's';

				isT = false;
				isR = false;
				isB = false;
				isL = false;

			}
		}// end for loop
	}// end buildSpriteStyle()

	@SuppressWarnings({"incomplete-switch"})
	private void buildCorners(){
		
		char currTopLayer;
		char up = '\0';
		char right = '\0';
		char down = '\0';
		char left = '\0';
		
		for(int i = 0; i < mapXSize; i++){
			for(int j = 0; j < mapYSize; j++){
			
				currTopLayer = topLayer[i][j];
				if(currTopLayer == 'w'){// current terrain is water
					
					// retrieve the next top, right, down, and left tiles
					if(j > 0 && topLayer[i][j - 1] == currTopLayer)
						up = spriteStyle[i][j - 1];
					if(i < mapXSize - 1 && topLayer[i + 1][j] == currTopLayer)
						right = spriteStyle[i + 1][j];
					if(j < mapYSize - 1 && topLayer[i][j + 1] == currTopLayer)
						down = spriteStyle[i][j + 1];
					if(i > 0 && topLayer[i - 1][j] == currTopLayer)
						left = spriteStyle[i - 1][j];
				
					switch(spriteStyle[i][j]){
						case 'q' :	// TL
							if(right == 's' || right == 'd'){
								combineCorners(i + 1, j, 'q');
							}else if(right == 'f' || right == 'y'){
								combineCorners(i, j, 'm');
							}else if(right == 'x' || right == 'c'){
								combineCorners(i + 1, j, 'q');
								combineCorners(i, j, 'm');
							}
							
							if(down == 's' || down == 'x'){
								combineCorners(i, j + 1, 'q');
							}else if(down == 'u' || down == 'g'){
								combineCorners(i, j, 'm');
							}else if(down == 'd' || down == 'c'){
								combineCorners(i, j + 1, 'q');
								combineCorners(i, j, 'm');
							}
							break;
						case 'w' :	// TM
							if(left == 'a' || left == 's'){
								combineCorners(i - 1, j, 'p');
							}else if(left == 'f' || left == 't'){
								combineCorners(i, j, 'z');
							}else if(left == 'z' || left == 'x'){
								combineCorners(i - 1, j, 'p');
								combineCorners(i, j, 'z');
							}
							
							if(right == 's' || right == 'd'){
								combineCorners(i + 1, j, 'q');
							}else if(right == 'y' || right == 'f'){
								combineCorners(i, j, 'm');
							}else if(right == 'x' || right == 'c'){
								combineCorners(i + 1, j, 'q'); 	
								combineCorners(i, j, 'm');
							}
							break;
						case 'e' :	// TR
							if(down == 's' || down == 'x'){
								combineCorners(i, j + 1, 'p');
							}else if(down == 'u' || down == 'g'){
								combineCorners(i, j, 'z');
							}else if(down == 'a' || down == 'z'){
								combineCorners(i, j + 1, 'p');
								combineCorners(i, j, 'z');
							}
							
							if(left == 'a' || left == 's'){
								combineCorners(i - 1, j, 'p');
							}else if(left == 't' || left == 'f'){
								combineCorners(i, j, 'z');
							}else if(left == 'z' || left == 'x'){
								combineCorners(i - 1, j, 'p');
								combineCorners(i, j, 'z');
							}
							break;
						case 'a' : // ML
							if(up == 'w' || up == 's'){
								combineCorners(i, j - 1, 'z');
							}else if(up == 'r' || up == 'g'){
								combineCorners(i, j, 'p');
							}else if(up == 'e' || up == 'd'){
								combineCorners(i, j - 1, 'z');
								combineCorners(i, j, 'p');
							}
							
							if(down == 's' || down == 'w'){
								combineCorners(i, j + 1, 'q');
							}else if(down == 'u' || down == 'g'){
								combineCorners(i, j, 'm');
							}else if(down == 'd' || down == 'c'){
								combineCorners(i, j + 1, 'q');
								combineCorners(i, j, 'm');
							}
							break;
						case 'd' : // MR
							if(up == 'w' || up == 's'){
								combineCorners(i, j - 1, 'm');
							}else if(up == 'r' || up == 'g'){
								combineCorners(i, j, 'q');
							}else if(up == 'q' || up == 'a'){
								combineCorners(i, j - 1, 'm');
								combineCorners(i, j, 'q');
							}
							
							if(down == 's' || down == 'x'){
								combineCorners(i, j + 1, 'p');
							}else if(down == 'u' || down == 'g'){
								combineCorners(i, j, 'z');
							}else if(down == 'a' || down == 'z'){
								combineCorners(i, j + 1, 'p');
								combineCorners(i, j, 'z');
							}
					}
				}
				up = '\0';
				right = '\0';
				down = '\0';
				left = '\0';
			}
		}// end for loop
	}// end buildCorners()
	
	/*
	 *	Used when a corner is needed. This checks if the tile currently has a
	 *	corner associated with it, then combines the two corners to make one
	 *	corner tile.
	 */
	@SuppressWarnings("incomplete-switch")
	private void combineCorners(int i, int j, char newChar){
		/*
		 * CORNER STYLE TABLE -char- -MEANING-
		 * q Top-Left p Top-Right z Bottom-Left m Bottom-Right
		 * t Top-Left && Top-Right a Top-Left && Bottom-Left g Top-Left && Bottom-Right 
		 * h Top-Right && Bottom-Left l Top-Right && Bottom-Right 
		 * v Bottom-Left && Bottom-Right
		 * f Top-Left && Top-Right && Bottom-Left
		 * j Top-Left && Top-Right && Bottom-Right
		 * c Top-Left && Bottom-Left && Bottom-Right
		 * b Top-Right && Bottom-Left && Bottom-Right
		 * y All
		 */
		
		char curChar = corners[i][j];
		
		if(curChar == '?')
			corners[i][j] = newChar;
		else{
			if(newChar == 'q'){// adding TL
				switch(curChar){
				case 'p' : corners[i][j] = 't';
							break;
				case 'z' : corners[i][j] = 'a';
							break;
				case 'm' : corners[i][j] = 'g';
							break;
				case 'h' : corners[i][j] = 'f';
							break;
				case 'l' : corners[i][j] = 'j';
							break;
				case 'v' : corners[i][j] = 'c';
							break;
				case 'b' : corners[i][j] = 'y';
							break;
				}
			}
			else if(newChar == 'p'){// adding TR
				switch(curChar){
				case 'q' : corners[i][j] = 't';
							break;
				case 'z' : corners[i][j] = 'h';
							break;
				case 'm' : corners[i][j] = 'l';
							break;
				case 'a' : corners[i][j] = 'f';
							break;
				case 'g' : corners[i][j] = 'j';
							break;
				case 'v' : corners[i][j] = 'b';
							break;
				case 'c' : corners[i][j] = 'y';
							break;
				}
			}
			else if(newChar == 'z'){// adding BL
				switch(curChar){
				case 'q' : corners[i][j] = 'a';
							break;
				case 'p' : corners[i][j] = 'h';
							break;
				case 'm' : corners[i][j] = 'v';
							break;
				case 't' : corners[i][j] = 'f';
							break;
				case 'g' : corners[i][j] = 'c';
							break;
				case 'l' : corners[i][j] = 'b';
							break;
				case 'j' : corners[i][j] = 'y';
							break;
				}
			}
			else if(newChar == 'm'){// adding BR
				switch(curChar){
				case 'q' : corners[i][j] = 'g';
							break;
				case 'p' : corners[i][j] = 'l';
							break;
				case 'z' : corners[i][j] = 'v';
							break;
				case 't' : corners[i][j] = 'j';
							break;
				case 'a' : corners[i][j] = 'c';
							break;
				case 'h' : corners[i][j] = 'b';
							break;
				case 'f' : corners[i][j] = 'y';
							break;
				}
			}
		}
	}// end combineCorners()
	
	/*
	 * This method ensures that every tile possibly gets expanded upon, so that
	 * terrain types occur in clusters. It also zeroes out some member variables
	 * that are used in the recursive growth equations, before looping through
	 * and calling the recursive growth on each tile. params are: type=terrain
	 * type to expand,layer is the 2d array the operations are happening in
	 * randomBase=the initial probability out of 100 that the first tile will
	 * NOT expand, randomIncrease=the amount that the probability --note about
	 * the probability; since each square can expand up into 8 tiles, anything
	 * under 7/8 (87.5) would lead to each tile expanding into another(run away
	 * expansion). That is why there is another portion that increases the
	 * probability of not expanding each time an expansion happens
	 */
	private void expandFeature(char type, char[][] layer, int randomBase,
			int randomIncrease) {
		zeroRecursiveVars();

		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapXSize; j++) {
				if (layer[i][j] == type) {
					recursiveExpand(i, j, 0, type, layer, randomBase,
							randomIncrease);
				}
			}// end
		}// end
	}// end expandFeature()

	/*	
	 *  called from expand features, read it's comments for more information
	 *	count is the number of times this recursive function has sucessfully
	 *	made more terrain
	*/
	private void recursiveExpand(int y, int x, int count, char type,
			char[][] layer, int randomBase, int randomIncrease) {

		if (y < 0 || x < 0 || y > mapYSize - 1 || x > mapXSize - 1)
			return;
		if (!expanded[y][x]) {
			layer[y][x] = type;
			for (int k = -1; k <= 1; k++) {
				for (int l = -1; l <= 1; l++) {
					int rand = (int) (Math.random() * 100); // 1-100
															// probability
					if (rand > randomBase + (randomIncrease * count)) {
						// start probability slowly gets bigger, so less chance
						// to grow
						recursiveExpand(k + y, l + x, count++, type, layer,
								randomBase, randomIncrease);// increments count
															// on each
															// successful
															// recursive call
						if (!(k + y < 0 || l + x < 0 || k + y > mapYSize - 1 || l
								+ x > mapXSize - 1))
							expanded[k + y][l + x] = true;//this 2d array used to stop recursion from going backwards up the map
					}// end if
				}// end inner for
			}// end outer for
		}// end if
	}// end recursiveExpand()

	private void zeroRecursiveVars() {
		timesExpanded = 0;
		for (int i = 0; i < mapYSize; i++) {
			for (int j = 0; j < mapXSize; j++) {
				expanded[i][j] = false;
			}
		}// end for loop
	}// zeroRecursiveVars()
	
	/*
	 * Image look-up for rendering.
	 * 
	 * @param terrain : the type of terrain at a given tile from TopLayer[][]
	 * @param style : the variation of the terrain tile from spriteStyle[][]
	 * @return : the Image to be drawn
	 */
	public Image getTerrain(char terrain, char style) {

		Image result = null;

		if(terrain != '?'){
			if (terrain == 't') {// terrain is trees
				switch (style) {
				case 'q':
					result = treeTL;
					break;
				case 'w':
					result = treeTM;
					break;
				case 'e':
					result = treeTR;
					break;
				case 'a':
					result = treeML;
					break;
				case 's':
					result = treeMM;
					break;
				case 'd':
					result = treeMR;
					break;
				case 'z':
					result = treeBL;
					break;
				case 'x':
					result = treeBM;
					break;
				case 'c':
					result = treeBR;
					break;
				case 'v':
					result = treeAA;
					break;
				case 'r':
					result = treeAT;
					break;
				case 't':
					result = treeAL;
					break;
				case 'y':
					result = treeAR;
					break;
				case 'u':
					result = treeAB;
					break;
				case 'f':
					result = treeLRT;
					break;
				case 'g':
					result = treeUDT;
					break;
				default:
					result = treeMM;
				}
			} else if (terrain == 'w') {// terrain is water
				switch (style) {
				case 'q':
					result = waterTL;
					break;
				case 'w':
					result = waterTM;
					break;
				case 'e':
					result = waterTR;
					break;
				case 'a':
					result = waterML;
					break;
				case 's':
					result = waterMM;
					break;
				case 'd':
					result = waterMR;
					break;
				case 'z':
					result = waterBL;
					break;
				case 'x':
					result = waterBM;
					break;
				case 'c':
					result = waterBR;
					break;
				case 'v':
					result = waterAA;
					break;
				case 'r':
					result = waterAT;
					break;
				case 't':
					result = waterAL;
					break;
				case 'y':
					result = waterAR;
					break;
				case 'u':
					result = waterAB;
					break;
				case 'f':
					result = waterLRT;
					break;
				case 'g':
					result = waterUDT;
					break;
				default:
					result = waterMM;
				}
			} else if (terrain == 'm') {// terrain is mountain
				switch (style) {
				case 'q':
					result = mountainTL;
					break;
				case 'w':
					result = mountainTM;
					break;
				case 'e':
					result = mountainTR;
					break;
				case 'a':
					result = mountainML;
					break;
				case 's':
					result = mountainMM;
					break;
				case 'd':
					result = mountainMR;
					break;
				case 'z':
					result = mountainBL;
					break;
				case 'x':
					result = mountainBM;
					break;
				case 'c':
					result = mountainBR;
					break;	
				case 'v':
					result = mountainAA;
					break;
				case 'r':
					result = mountainAT;
					break;
				case 't':
					result = mountainAL;
					break;
				case 'y':
					result = mountainAR;
					break;
				case 'u':
					result = mountainAB;
					break;
				case 'f':
					result = mountainLRT;
					break;
				case 'g':
					result = mountainUDT;
					break;
				default:
					result = mountainMM;
				}
			} else if (terrain == 'g') {// terrain is grass
				result = grass;
			} else if (terrain == 'u') {// terrain is mud
				result = mud;
			}
		}
		return result;
	}// end getTerrain()

	@SuppressWarnings("incomplete-switch")
	public Image getCorner(int i, int j){
		
		Image result = null;
		
		if(topLayer[i][j] == 'w'){// terrain is water
			switch(corners[i][j]){
			case 'q' : result = waterCTL;
						break;
			case 'p' : result = waterCTR;
						break;
			case 'z' : result = waterCBL;
						break;
			case 'm' : result = waterCBR;
						break;
			case 't' : result = waterCTLTR;
						break;
			case 'a' : result = waterCTLBL;
						break;
			case 'g' : result = waterCTLBR;
						break;
			case 'h' : result = waterCTRBL;
						break;
			case 'l' : result = waterCTRBR;
						break;
			case 'v' : result = waterCBLBR;
						break;
			case 'f' : result = waterCTLTRBL;
						break;
			case 'j' : result = waterCTLTRBR;
						break;
			case 'c' : result = waterCTLBLBR;
						break;
			case 'b' : result = waterCTRBLBR;
						break;
			case 'y' : result = waterCTLTRBLBR;
						break;
			}
		}
		
		return result;
	}// end getCorner()
	
 	public Image getTank(int playerNum) {

		return tank;
	}

}// end GameMap Class
