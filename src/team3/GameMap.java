package team3;

public class GameMap {

	private byte[][] map = new byte[64][64];
	private Point[] locations = new Point[8];
	
	
	//creates a gamemap
	public GameMap(){
		do {
		generateMap();
		}while(!checkMap());
	}//end of constructor
	
	//randomly generates a map and places players
	private void generateMap() {
		byte num = 0;
		for(int i = 0; i < 64; i++) {
			for(int j = 0; j < 64; j++) {
			int r = (int)(Math.random() * 1000);
			//System.out.println(r);
			if(r == 1000) {
				r = 999;
				}//end of if
			if(r < 500) {
				num = 4;
			}
			else if(r < 700) {
				num = 1;
			}
			else if(r < 900) {
				num = 0;
			}
			else if(r < 950) {
				num = 2;
			}
			else if(r < 999){
				num = 3;
			}
			map[i][j] = num;
			}//end of if
		}//end of if
		for(int i = 0; i < 8; i++) {
			int randx = (int)(Math.random() * 64);
			int randy = (int)(Math.random() * 64);
			if(isOccupied(randx, randy) < 0 && map[randx][randy] != 2 && map[randx][randy] != 3) {
				locations[i] = new Point(randx, randy);
			}//end of if
			else {
				i--;
			}//end of else
		}//end of for
	}//end of generateMap
	
	private boolean checkMap() {
		//checks if there is any unaccessable terrain in the map
		Grid g = new Grid(map);
		int num = g.findRegions();
		//System.out.println(num);
		if(num > 3) {
			return false;
		}//end of if
		return true;
	}//end of checkMap
	
	public int isOccupied(int x, int y) {
		//returns what tank is at the given coordinates
		for(int i = 0; i < 8; i++) {
			if(locations[i] != null && locations[i].x == x && locations[i].y == y) {
				return i;
			}//end of if
		}//end of for
		return -1;
	}//end of isOccupied
	
	//moves a tank
	public void moveTank(int playerNumber, int x, int y) {
		locations[playerNumber] = new Point(x,y);
	}//end of moveTank
	
	public byte terrainType(int x, int y) {
		//returns the terrain type at the given coordinates
		return map[x][y];
	}//end of terrainType
	
	//returns the locations of the players
	public Point[] getLocations() {
		return locations;
	}//end of getLocations
}//end of GameMap
