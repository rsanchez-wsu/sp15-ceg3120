package team7;

public class Tile {
	
	private Terrain terrainType;
	private boolean hasPlayer;
	
	//these variables hold the surrounding tiles. This is so you can set the player visibility on the game board
	//The initial values are set to null so border tiles are easy to find
	private Tile northTile = null;
	private Tile southTile = null;
	private Tile eastTile = null;
	private Tile westTile = null;
	private Tile northEastTile = null;
	private Tile northWestTile = null;
	private Tile southWestTile = null;
	private Tile southEastTile = null;
	
	
	public Tile(Terrain terrainType, boolean hasPlayer){
		
		this.setTerrainType(terrainType);
		this.setHasPlayer(hasPlayer);
		
	}


	public Terrain getTerrainType() {
		return terrainType;
	}


	public void setTerrainType(Terrain terrainType) {
		this.terrainType = terrainType;
	}


	public boolean isHasPlayer() {
		return hasPlayer;
	}


	public void setHasPlayer(boolean hasPlayer) {
		this.hasPlayer = hasPlayer;
	}


	public Tile getSouthTile() {
		return southTile;
	}


	public void setSouthTile(Tile southTile) {
		this.southTile = southTile;
	}


	public Tile getNorthTile() {
		return northTile;
	}


	public void setNorthTile(Tile northTile) {
		this.northTile = northTile;
	}


	public Tile getEastTile() {
		return eastTile;
	}


	public void setEastTile(Tile eastTile) {
		this.eastTile = eastTile;
	}


	public Tile getWestTile() {
		return westTile;
	}


	public void setWestTile(Tile westTile) {
		this.westTile = westTile;
	}


	public Tile getNorthEastTile() {
		return northEastTile;
	}


	public void setNorthEastTile(Tile northEastTile) {
		this.northEastTile = northEastTile;
	}


	public Tile getNorthWestTile() {
		return northWestTile;
	}


	public void setNorthWestTile(Tile northWestTile) {
		this.northWestTile = northWestTile;
	}


	public Tile getSouthWestTile() {
		return southWestTile;
	}


	public void setSouthWestTile(Tile southWestTile) {
		this.southWestTile = southWestTile;
	}


	public Tile getSouthEastTile() {
		return southEastTile;
	}


	public void setSouthEastTile(Tile southEastTile) {
		this.southEastTile = southEastTile;
	}

}
