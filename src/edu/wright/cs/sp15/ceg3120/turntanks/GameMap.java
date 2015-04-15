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

package edu.wright.cs.sp15.ceg3120.turntanks;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.wright.cs.sp15.ceg3120.turntanks.server.RegionCheck;

public class GameMap {

	public int mapXSize = 64;
	public int mapYSize = 64;
	public char[][] baseLayer = new char[mapXSize][mapYSize];
	public char[][] topLayer = new char[mapXSize][mapYSize];
	public char[][] spriteStyle = new char[mapXSize][mapYSize];
	public char[][] corners = new char[mapXSize][mapYSize];

	// used to limit recursive terrain feature growth
	private int timesExpanded = 0;

	// used for recursive growth limiting
	private boolean[][] expanded = new boolean[mapXSize][mapYSize];

	private Image tank = null;
	private Image grass = null;
	private Image hill = null;

	private Image mudTL = null;
	private Image mudTM = null;
	private Image mudTR = null;
	private Image mudML = null;
	private Image mudMM = null;
	private Image mudMR = null;
	private Image mudBL = null;
	private Image mudBM = null;
	private Image mudBR = null;
	private Image mudAA = null;
	private Image mudAT = null;
	private Image mudAR = null;
	private Image mudAB = null;
	private Image mudAL = null;
	private Image mudUDT = null;
	private Image mudLRT = null;

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
	}

	/*
	 * Creates a randomized map.
	 */
	public void generateMap() {
		do {
			buildBaseLayer();
			buildSpriteStyle('a');
			buildTopLayer();
		} while (!checkMap());
		buildSpriteStyle('b');
		buildCorners();
	}

	/*
	 * creates a regioncheck and sees that each tank will be able to access each
	 * other tank returns if each tank can get to each other tank
	 */
	private boolean checkMap() {
		RegionCheck r = new RegionCheck(topLayer);
		if (r.findRegions() > 3) {
			return false;
		}// end of if
		return true;
	}

	/*
	 * Creates a completely unknown map. All arrays are initiated to '?', this
	 * char is never used
	 */
	private void generateBlankLayers() {
		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapYSize; j++) {
				baseLayer[i][j] = '?';
				topLayer[i][j] = '?';
				spriteStyle[i][j] = '?';
				corners[i][j] = '?';
			}
		}
	}

	/*
	 * Connects the Image Objects with the files.
	 */
	private void findFiles() {
		try {
			tank = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tank.jpg"));
			grass = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/grass.jpg"));
			hill = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/hill.png"));

			mudTL = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_tl.jpg"));
			mudTM = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_tm.jpg"));
			mudTR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_tr.jpg"));
			mudML = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_ml.jpg"));
			mudMM = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_mm.jpg"));
			mudMR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_mr.jpg"));
			mudBL = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_bl.jpg"));
			mudBM = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_bm.jpg"));
			mudBR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_br.jpg"));
			mudAA = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_aa.jpg"));
			mudAT = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_at.jpg"));
			mudAR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_ar.jpg"));
			mudAB = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_ab.jpg"));
			mudAL = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_al.jpg"));
			mudUDT = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_udt.jpg"));
			mudLRT = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mud_lrt.jpg"));

			treeTL = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_tl.png"));
			treeTM = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_tm.png"));
			treeTR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_tr.png"));
			treeML = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_ml.png"));
			treeMM = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_mm.png"));
			treeMR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_mr.png"));
			treeBL = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_bl.png"));
			treeBM = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_bm.png"));
			treeBR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_br.png"));
			treeAA = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_aa.png"));
			treeAT = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_at.png"));
			treeAL = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_al.png"));
			treeAR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_ar.png"));
			treeAB = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_ab.png"));
			treeUDT = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_udt.png"));
			treeLRT = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/tree_lrt.png"));

			waterTL = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_tl.png"));
			waterTM = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_tm.png"));
			waterTR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_tr.png"));
			waterML = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ml.png"));
			waterMM = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_mm.png"));
			waterMR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_mr.png"));
			waterBL = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_bl.png"));
			waterBM = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_bm.png"));
			waterBR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_br.png"));
			waterAA = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_aa.png"));
			waterAT = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_at.png"));
			waterAL = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_al.png"));
			waterAR = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ar.png"));
			waterAB = ImageIO.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ab.png"));
			waterLRT = ImageIO
					.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_lrt.png"));
			waterUDT = ImageIO
					.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_udt.png"));

			waterCTL = ImageIO
					.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ctl.png"));
			waterCTR = ImageIO
					.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ctr.png"));
			waterCBL = ImageIO
					.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_cbl.png"));
			waterCBR = ImageIO
					.read(new File("./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_cbr.png"));
			waterCTLTR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ctl_tr.png"));
			waterCTLBL = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ctl_bl.png"));
			waterCTLBR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ctl_br.png"));
			waterCTRBL = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ctr_bl.png"));
			waterCTRBR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ctr_br.png"));
			waterCBLBR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_cbl_br.png"));
			waterCTLTRBL = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ctl_tr_bl.png"));
			waterCTLTRBR = ImageIO.read(new File(
					"./src/team6/images/water_ctl_tr_br.png"));
			waterCTLBLBR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ctl_bl_br.png"));
			waterCBLBR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_cbl_br.png"));
			waterCTLTRBLBR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/water_ctl_tr_bl_br.png"));

			mountainTL = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_tl.png"));
			mountainTM = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_tm.png"));
			mountainTR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_tr.png"));
			mountainML = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_ml.png"));
			mountainMM = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_mm.png"));
			mountainMR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_mr.png"));
			mountainBL = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_bl.png"));
			mountainBM = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_bm.png"));
			mountainBR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_br.png"));
			mountainAA = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_aa.png"));
			mountainAT = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_at.png"));
			mountainAR = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_ar.png"));
			mountainAB = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_ab.png"));
			mountainAL = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_al.png"));
			mountainUDT = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_udt.png"));
			mountainLRT = ImageIO.read(new File(
					"./src/edu/wright/cs/sp15/ceg3120/turntanks/resources/mountain_lrt.png"));

		} catch (IOException ex) {
			System.out.println(ex);
			// FIXME: handle exception...
		}
	}

	/*
	 * Generates the bottom layer of the game map. This layer is only cosmetic,
	 * since in buildTopLayer() the actual features of the map are created and
	 * expanded. Through the alpha colors in topLayer you will see the baseLayer
	 * terrain.
	 */
	private void buildBaseLayer() {
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
	}

	/*
	 * Generates the features that make the map interesting. This layer is held
	 * in the topLayer array and contains the type of each terrain piece
	 */
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
				else if (rand > 300 && rand < 304) // hill
					topLayer[i][j] = 'h';
				else if (baseLayer[i][j] == 'g')
					topLayer[i][j] = 'g';
				else
					topLayer[i][j] = 'u';
			}
		}

		expandFeature('m', topLayer, 80, 5);
		expandFeature('w', topLayer, 75, 5);
		expandFeature('t', topLayer, 70, 5);
		expandFeature('h', topLayer, 80, 5);
	}

	/*
	 * To make the map look more realistic, there are different 'styles' for
	 * each tile piece, depending on the neighboring tiles. These styles include
	 * a basic 3x3 assortment and also singleton pieces and tunnel-like pieces.
	 * Each piece has it's own style char, included in a table below.
	 */
	private void buildSpriteStyle(char mode) {
		/*
		 * TERRAIN STYLE TABLE: -char- -MEANING- q Top-Left w Top-Middle e
		 * Top-Right a Middle-Left s Middle-Middle d Middle-Right z Bottom-Left
		 * x Bottom-Middle c Bottom-Right v Alone-Alone r Alone-Top t Alone-Left
		 * y Alone-Right u Alone-Bottom f Left-Right Tunnel h Up-Down Tunnel
		 */
		boolean isT = false;
		boolean isR = false;
		boolean isB = false;
		boolean isL = false;

		char style = '\0';

		// step through map array checking if neighboring terrain matches
		// current terrain
		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapYSize; j++) {

				if (mode == 'a') {// building baseLayer
					// check each cardinal direction to determine what kind of
					// tile it is
					isT = (i == 0 || baseLayer[i - 1][j] == 'g');
					isR = (j == mapXSize - 1 || baseLayer[i][j + 1] == 'g');
					isB = (i == mapYSize - 1 || baseLayer[i + 1][j] == 'g');
					isL = (j == 0 || baseLayer[i][j - 1] == 'g');
				} else if (mode == 'b') {
					// check each cardinal direction to determine what kind of
					// tile it is
					isT = (i == 0 || topLayer[i][j] != topLayer[i - 1][j]);
					isR = (j == mapXSize - 1 || topLayer[i][j] != topLayer[i][j + 1]);
					isB = (i == mapYSize - 1 || topLayer[i][j] != topLayer[i + 1][j]);
					isL = (j == 0 || topLayer[i][j] != topLayer[i][j - 1]);
				}
				// very basic logic that assigns the tile a style depending on
				// its cardinal directions
				if (isT)
					if (isR)
						if (isB)
							if (isL)// AA
								style = 'v';
							else
								// AR
								style = 'y';
						else if (isL)// AT
							style = 'r';
						else
							// TR
							style = 'e';
					else if (isB)
						if (isL)// AL
							style = 't';
						else
							// LRT
							style = 'f';
					else if (isL)// TL
						style = 'q';
					else
						// TM
						style = 'w';
				else if (isR)
					if (isB)
						if (isL)// AB
							style = 'u';
						else
							// BR
							style = 'c';
					else if (isL)// UDT
						style = 'h';
					else
						// MR
						style = 'd';
				else if (isB)
					if (isL)// BL
						style = 'z';
					else
						// BM
						style = 'x';
				else if (isL)// ML
					style = 'a';
				else
					// MM
					style = 's';

				isT = false;
				isR = false;
				isB = false;
				isL = false;

				if (mode == 'a' && baseLayer[i][j] != 'g')
					baseLayer[i][j] = style;
				else if (mode == 'b')
					spriteStyle[i][j] = style;
			}
		}
	}

	/*
	 * To make the map even more realistic, corners have been implemented. These
	 * pieces are necessary for when there is a change in 'direction' between
	 * neighboring tiles.
	 */
	private void buildCorners() {
		char currTopLayer;
		char currSpriteStyle;
		char neighbor = '?';

		boolean edgeTL = false;
		boolean edgeTR = false;
		boolean edgeRT = false;
		boolean edgeRB = false;
		boolean edgeBR = false;
		boolean edgeBL = false;
		boolean edgeLB = false;
		boolean edgeLT = false;

		/*
		 * step through the map array checking the style of neighboring tiles to
		 * decide if a corner is necessary
		 */
		for (int i = 0; i < mapXSize; i++) {
			for (int j = 0; j < mapYSize; j++) {
				currTopLayer = topLayer[i][j];
				if (currTopLayer == 'w') {// current terrain is water
					currSpriteStyle = spriteStyle[i][j];

					// depending on the tile type, decide which directions need
					// to be checked
					edgeTL = (currSpriteStyle == 'w' || currSpriteStyle == 'e'
							|| currSpriteStyle == 'y' || currSpriteStyle == 'f');
					edgeTR = (currSpriteStyle == 'q' || currSpriteStyle == 'w'
							|| currSpriteStyle == 't' || currSpriteStyle == 'f');
					edgeRT = (currSpriteStyle == 'd' || currSpriteStyle == 'c'
							|| currSpriteStyle == 'u' || currSpriteStyle == 'h');
					edgeRB = (currSpriteStyle == 'e' || currSpriteStyle == 'd'
							|| currSpriteStyle == 'r' || currSpriteStyle == 'h');
					edgeBR = (currSpriteStyle == 'z' || currSpriteStyle == 'x'
							|| currSpriteStyle == 't' || currSpriteStyle == 'f');
					edgeBL = (currSpriteStyle == 'x' || currSpriteStyle == 'c'
							|| currSpriteStyle == 'y' || currSpriteStyle == 'f');
					edgeLB = (currSpriteStyle == 'q' || currSpriteStyle == 'a'
							|| currSpriteStyle == 'r' || currSpriteStyle == 'h');
					edgeLT = (currSpriteStyle == 'a' || currSpriteStyle == 'z'
							|| currSpriteStyle == 'u' || currSpriteStyle == 'h');

					if (edgeTL) {
						neighbor = spriteStyle[i][j - 1];
						if (neighbor == 's' || neighbor == 'x'
								|| neighbor == 'a' || neighbor == 'z')
							combineCorners(i, j - 1, 'p');
					}
					if (edgeTR) {
						neighbor = spriteStyle[i][j + 1];
						if (neighbor == 's' || neighbor == 'x'
								|| neighbor == 'd' || neighbor == 'c')
							combineCorners(i, j + 1, 'q');
					}
					if (edgeRT) {
						neighbor = spriteStyle[i - 1][j];
						if (neighbor == 's' || neighbor == 'w'
								|| neighbor == 'q' || neighbor == 'a')
							combineCorners(i - 1, j, 'm');
					}
					if (edgeRB) {
						neighbor = spriteStyle[i + 1][j];
						if (neighbor == 's' || neighbor == 'x'
								|| neighbor == 'a' || neighbor == 'z')
							combineCorners(i + 1, j, 'p');
					}
					if (edgeBR) {
						neighbor = spriteStyle[i][j + 1];
						if (neighbor == 's' || neighbor == 'w'
								|| neighbor == 'd' || neighbor == 'e')
							combineCorners(i, j + 1, 'z');
					}
					if (edgeBL) {
						neighbor = spriteStyle[i][j - 1];
						if (neighbor == 's' || neighbor == 'w'
								|| neighbor == 'a' || neighbor == 'q')
							combineCorners(i, j - 1, 'm');
					}
					if (edgeLB) {
						neighbor = spriteStyle[i + 1][j];
						if (neighbor == 's' || neighbor == 'w'
								|| neighbor == 'd' || neighbor == 'c')
							combineCorners(i + 1, j, 'q');
					}
					if (edgeLT) {
						neighbor = spriteStyle[i - 1][j];
						if (neighbor == 's' || neighbor == 'w'
								|| neighbor == 'e' || neighbor == 'd')
							combineCorners(i - 1, j, 'z');
					}
				}
			}
		}
	}

	/*
	 * Used when a corner is needed. This checks if the tile currently has a
	 * corner associated with it, then combines the two corners to make one
	 * corner tile.
	 */
	@SuppressWarnings("incomplete-switch")
	private void combineCorners(int i, int j, char newChar) {
		/*
		 * CORNER STYLE TABLE -char- -MEANING- q Top-Left p Top-Right z
		 * Bottom-Left m Bottom-Right t Top-Left && Top-Right a Top-Left &&
		 * Bottom-Left g Top-Left && Bottom-Right h Top-Right && Bottom-Left l
		 * Top-Right && Bottom-Right v Bottom-Left && Bottom-Right f Top-Left &&
		 * Top-Right && Bottom-Left j Top-Left && Top-Right && Bottom-Right c
		 * Top-Left && Bottom-Left && Bottom-Right b Top-Right && Bottom-Left &&
		 * Bottom-Right y All
		 */
		char curChar = corners[i][j];

		if (curChar == '?' || curChar == newChar)
			corners[i][j] = newChar;
		else {
			if (newChar == 'q') { // adding TL
				switch (curChar) {
				case 'p':
					corners[i][j] = 't';
					break;
				case 'z':
					corners[i][j] = 'a';
					break;
				case 'm':
					corners[i][j] = 'g';
					break;
				case 'h':
					corners[i][j] = 'f';
					break;
				case 'l':
					corners[i][j] = 'j';
					break;
				case 'v':
					corners[i][j] = 'c';
					break;
				case 'b':
					corners[i][j] = 'y';
					break;
				}
			} else if (newChar == 'p') { // adding TR
				switch (curChar) {
				case 'q':
					corners[i][j] = 't';
					break;
				case 'z':
					corners[i][j] = 'h';
					break;
				case 'm':
					corners[i][j] = 'l';
					break;
				case 'a':
					corners[i][j] = 'f';
					break;
				case 'g':
					corners[i][j] = 'j';
					break;
				case 'v':
					corners[i][j] = 'b';
					break;
				case 'c':
					corners[i][j] = 'y';
					break;
				}
			} else if (newChar == 'z') { // adding BL
				switch (curChar) {
				case 'q':
					corners[i][j] = 'a';
					break;
				case 'p':
					corners[i][j] = 'h';
					break;
				case 'm':
					corners[i][j] = 'v';
					break;
				case 't':
					corners[i][j] = 'f';
					break;
				case 'g':
					corners[i][j] = 'c';
					break;
				case 'l':
					corners[i][j] = 'b';
					break;
				case 'j':
					corners[i][j] = 'y';
					break;
				}
			} else if (newChar == 'm') { // adding BR
				switch (curChar) {
				case 'q':
					corners[i][j] = 'g';
					break;
				case 'p':
					corners[i][j] = 'l';
					break;
				case 'z':
					corners[i][j] = 'v';
					break;
				case 't':
					corners[i][j] = 'j';
					break;
				case 'a':
					corners[i][j] = 'c';
					break;
				case 'h':
					corners[i][j] = 'b';
					break;
				case 'f':
					corners[i][j] = 'y';
					break;
				}
			}
		}
	}

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
			}
		}
	}

	/*
	 * called from expand features, read it's comments for more information
	 * count is the number of times this recursive function has sucessfully made
	 * more terrain
	 */
	private void recursiveExpand(int y, int x, int count, char type,
			char[][] layer, int randomBase, int randomIncrease) {
		if (y < 0 || x < 0 || y > mapYSize - 1 || x > mapXSize - 1)
			return;
		if (!expanded[y][x]) {
			layer[y][x] = type;
			for (int k = -1; k <= 1; k++) {
				for (int l = -1; l <= 1; l++) {
					int rand = (int) (Math.random() * 100); // 1-100 probability
					if (rand > randomBase + (randomIncrease * count)) {
						// start probability slowly gets bigger, so less chance
						// to grow
						// increments count on each successful recursive call
						recursiveExpand(k + y, l + x, count++, type, layer,
								randomBase, randomIncrease);
						if (!(k + y < 0 || l + x < 0 || k + y > mapYSize - 1 || l
								+ x > mapXSize - 1))
							expanded[k + y][l + x] = true;// this 2d array used
															// to stop recursion
															// from going
															// backwards up the
															// map
					}
				}
			}
		}
	}

	private void zeroRecursiveVars() {
		timesExpanded = 0;
		for (int i = 0; i < mapYSize; i++) {
			for (int j = 0; j < mapXSize; j++) {
				expanded[i][j] = false;
			}
		}
	}

	/*
	 * Image look-up for rendering a tile.
	 * 
	 * @param mode == 'a' : baseLayer is being drawn
	 * 
	 * @param mode == 'b' : topLayer is being drawn
	 * 
	 * @param terrain : the type of terrain at a given tile from topLayer[][] or
	 * baseLayer[][]
	 * 
	 * @param style : the variation of the terrain tile from spriteStyle[][]
	 * 
	 * @return : the Image to be drawn
	 */
	public Image getTerrain(char mode, char terrain, char style) {
		Image result = null;

		if (mode == 'a') { // drawing base-layer
			if (terrain != '?') {
				switch (terrain) {
					case 'g':
						result = grass;
						break;
					case 'q':
						result = mudTL;
						break;
					case 'w':
						result = mudTM;
						break;
					case 'e':
						result = mudTR;
						break;
					case 'a':
						result = mudML;
						break;
					case 's':
						result = mudMM;
						break;
					case 'd':
						result = mudMR;
						break;
					case 'z':
						result = mudBL;
						break;
					case 'x':
						result = mudBM;
						break;
					case 'c':
						result = mudBR;
						break;
					case 'v':
						result = mudAA;
						break;
					case 'r':
						result = mudAT;
						break;
					case 't':
						result = mudAL;
						break;
					case 'y':
						result = mudAR;
						break;
					case 'u':
						result = mudAB;
						break;
					case 'f':
						result = mudLRT;
						break;
					case 'h':
						result = mudUDT;
						break;
					default:
						result = mudAA;
				}
			}
		} else if (mode == 'b') {// drawing top-layer
			if (terrain != '?') {
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
						case 'h':
							result = treeUDT;
							break;
						default:
							result = treeAA;
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
						case 'h':
							result = waterUDT;
							break;
						default:
							result = waterAA;
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
						case 'h':
							result = mountainUDT;
							break;
						default:
							result = mountainAA;
					}
				} else if (terrain == 'h') {// terrain is hill
					result = hill;
				}
			}
		}
		return result;
	}

	/*
	 * Image look-up for rendering a corner.
	 * 
	 * @param i : x coordinate in the array
	 * 
	 * @param j : y coordinate in the array
	 */
	public Image getCorner(int i, int j) {
		Image result = null;

		if (topLayer[i][j] == 'w') {// terrain is water
			switch (corners[i][j]) {
				case 'q':
					result = waterCTL;
					break;
				case 'p':
					result = waterCTR;
					break;
				case 'z':
					result = waterCBL;
					break;
				case 'm':
					result = waterCBR;
					break;
				case 't':
					result = waterCTLTR;
					break;
				case 'a':
					result = waterCTLBL;
					break;
				case 'g':
					result = waterCTLBR;
					break;
				case 'h':
					result = waterCTRBL;
					break;
				case 'l':
					result = waterCTRBR;
					break;
				case 'v':
					result = waterCBLBR;
					break;
				case 'f':
					result = waterCTLTRBL;
					break;
				case 'j':
					result = waterCTLTRBR;
					break;
				case 'c':
					result = waterCTLBLBR;
					break;
				case 'b':
					result = waterCTRBLBR;
					break;
				case 'y':
					result = waterCTLTRBLBR;
					break;
				default:
					result = waterCTL;
					break;
			}
		}
		return result;
	}

	public Image getTank(int playerNum) {

		// TODO: Figure out what to do with playerNum here
		return tank;
	}

	// team 3 create player positions

	// create array to hold generated player positions
	int playerPosition[][] = new int[2][8];

	public void generateRandomPositions() {
		// initialize starting position to (-5,-5), will not render and allows
		// a player to be positioned at (0,0)
		for (int i = 0; i < 8; i++) {
			playerPosition[0][i] = -5;
			playerPosition[i][0] = -5;
		}

		int x;
		int y;
		boolean valid = false;

		// loop 8 times to place each player
		for (int i = 0; i < 8; i++) {
			valid = true;
			while (valid) {
				valid = false;
				x = (int) Math.random() * 63;
				y = (int) Math.random() * 63;

				// can't be on a mountain or water
				if (topLayer[x][y] != 'm' && topLayer[x][y] != 'w') {
					// check for players close by
					for (int j = 0; j < 8; j++) {
						if (playerPosition[0][j] != -5) {// check to see if it
							// cant be withing 5 tiles of another player in x
							// direction
						}

					}
				}
			}
		}		
		// create a player
		// check for water and mountain tile
	}
	
	public Point generateSpawnLocation() {
		Point generatedPoint = new Point(0, 0);
		boolean validLocation = false;

		while (!validLocation) {
			generatedPoint.setLocation((int) Math.random() * (mapXSize - 1), 
					(int) Math.random() * (mapYSize - 1));
			// can't be on a mountain or water
			if (topLayer[generatedPoint.x][generatedPoint.y] != 'm' 
					&& topLayer[generatedPoint.x][generatedPoint.y] != 'w') {
				validLocation = true;
			}
		}
		return generatedPoint;
	}

}
