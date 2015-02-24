package team7;

import java.util.Random;
/*
 *  Copyright (C) <2015>  
 *  Josh Crank - crank.5@wright.edu
 *  // Aditional People
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

// (JTC) This is where the gameboard object will be implemented.  Size, matrix, etc.



public class GameBoard {
	
	private int sizeX;
	private int sizeY;
	private Tile[][] boardMatrix;
	
	
	public GameBoard(){
		
		sizeX = 64;
		sizeY = 64;
		
		boardMatrix = new Tile[64][64];
		
		generateMatrix();
	}
	
	
	
	
	
	public int getSizeX() {
		return sizeX;
	}
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}
	public int getSizeY() {
		return sizeY;
	}
	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}





	public Tile[][] getBoardMatrix() {
		return boardMatrix;
	}





	public void setBoardMatrix(Tile[][] boardMatrix) {
		this.boardMatrix = boardMatrix;
	}
	
	private void generateMatrix(){
		
		Random random = new Random();
		int randomNum;
		
		for(int i = this.sizeX; i < 100; i++){
			for(int j = this.sizeY; j < 100; j++){
			
				randomNum = random.nextInt(10);
				
				switch(randomNum){
				
				case 0:
					boardMatrix[i][j].setTerrainType(Terrain.MOUNTAIN);
					break;
				case 1:
					boardMatrix[i][j].setTerrainType(Terrain.LAKE);
					break;
				case 2:
					boardMatrix[i][j].setTerrainType(Terrain.FORREST);
					break;
				case 3:
					boardMatrix[i][j].setTerrainType(Terrain.FORREST);
					break;
				case 4:
					boardMatrix[i][j].setTerrainType(Terrain.HILLS);
					break;
				case 5:
					boardMatrix[i][j].setTerrainType(Terrain.HILLS);
					break;
				case 6:
					boardMatrix[i][j].setTerrainType(Terrain.PLAIN);
					break;
				case 7:
					boardMatrix[i][j].setTerrainType(Terrain.PLAIN);
					break;
				case 8:
					boardMatrix[i][j].setTerrainType(Terrain.PLAIN);
					break;
				case 9:
					boardMatrix[i][j].setTerrainType(Terrain.PLAIN);
					break;
				
				}
		
				
			}
		}
		
		
		
	}
	
	
	
	
	
}
