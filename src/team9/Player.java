/*
Team 9
*/
package team9;
/*
Set up the Object for each player and their stats
*/
public class Player {
    
    final private int playerNum;
    private int health;
    private Coordinate loc;
    private Coordinate lastLoc = new Coordinate(-1,-1);
    
    public Player(int playerNum){
        this.health = 50;
        this.playerNum=playerNum;
    }
    
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getPlayerNum(){
        return this.playerNum;
    }
    
    public void setLoc(Coordinate loc){
        this.loc=loc;
    }
    public Coordinate getLoc(){
        return this.loc;
    }
    public Coordinate getLastLoc(){
        return lastLoc;
    }
    public void setLastSeen(Coordinate foundLoc){
        this.lastLoc=foundLoc;
    }
    
}
