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

public class TankObject {
    //
	//
    public String TankImage;
    public String Name;
    public String IP;    
    public int xCoord;
    public int yCoord;
    public int health;
    public int score;
    public String state;

    public TankObject() {
    }// end empty constructor
    
    //full constructor
    public TankObject(String TankImage, String Name, String IP,
            int xCoord, int yCoord, int health, int score, String state) {        
        
        this.TankImage = TankImage;
        this.Name = Name;
        this.IP = IP;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.health = health;
        this.state = state;
    }//end empty constructor    
    
    
     public String[] toStringArray() {
        String[] stringArray = {TankImage,Name,IP,String.valueOf(xCoord),String.valueOf(yCoord) ,String.valueOf(health) ,String.valueOf(score),state }; 
         
        return stringArray ;
    }   

    @Override
    public String toString() {
        return "TankObject{" + "TankImage=" + TankImage + ", Name=" + Name + ", IP=" + IP + ", xCoord=" + xCoord + ", yCoord=" + yCoord + ", health=" + health + ", state=" + state + '}';
    }
     
}//end tank class

