/*
 * Copyright (C) 2015 - Matthew J Lents mlents0929@gmail.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package team9;
/*
Set up the Object for each player and their stats
*/
public class Player {
    
    final private int playerNum;
    private int health;
    String name;
    private Coordinate loc;
    private Coordinate lastLoc = new Coordinate(-1,-1);
    private String IPAddress;
    private String status;
    String[] names = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel"};
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
    public String getStatus(Player activePlayer){
        if(this.health==0){
            return "Dead";
        }
        else if(this == activePlayer){
            return "Play";
        }
        else{
            return "Wait";
        }
    }
    public void giveDefaultName(){
    	this.name = names[this.getPlayerNum()-1];
    }
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name= name;
    }
    @Override
	public String toString(){
    	return (this.getName());
    }
}
