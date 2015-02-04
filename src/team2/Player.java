package team2;
/*
* Copyright (C) <2015> <Team 2>
* 
* Will Hatfield
* Kevin Alig
* Alyssa Ramsey
* Anthony Lamping
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


/**
 * A dummy player class for representing a player in the simple JList.
 * @author william
 */
public class Player {
    private final String HANDLE;
    private final String IP_ADDRESS;
    private int lifeAmount;
    
    private static int handleID;
    
    public Player() {
        Integer handleNum = (int)(Math.random() * 8999 + 1000);
        HANDLE = handleNum.toString();
        
        Integer ipNum = (int)(Math.random() * 8999999 + 1000000);    
        IP_ADDRESS = ipNum.toString();
        
        lifeAmount = (int)(Math.random() * 89 + 10);             
    }

    @Override
    public String toString() {
        return ("Player" + HANDLE + " @ ip" + IP_ADDRESS 
                + ": Life = " + lifeAmount + "%");
    }
    
    public int getLifeAmount() {
        return lifeAmount;
    }

    public void setLifeAmount(int lifeAmount) {
        this.lifeAmount = lifeAmount;
    }
}// End Player Class
