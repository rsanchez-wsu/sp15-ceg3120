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
 * @author william, edited by Alyssa & Anthony
 */
public class Player {
    private final String HANDLE;
    private final String IP_ADDRESS;
    private int lifeAmount;
    private int time;
    private int positionX;
    private int positionY;
    private PlayerState status; 
    private int tempRandom; //will not need after we can pull actual data for players
    private static int handleID;
    
    public Player() {
        Integer handleNum = (int)(Math.random() * 8999 + 1000); //temp random handle
        HANDLE = handleNum.toString();
        
        Integer ipNum = (int)(Math.random() * 8999999 + 1000000); //temp random IP Address
        IP_ADDRESS = ipNum.toString();
        
        lifeAmount = (int)(Math.random() * 89 + 10);  //temp random lifeAmount 
        
        time = (int)(Math.random() * 60); //temp random time
        
        positionX = (int)(Math.random() *10); //temp random position
        
        positionY = (int)(Math.random() * 10); //temp random position
        
        //just a random temporary status until we can pull actual data
        tempRandom = (int)(Math.random()*10); 
        if (tempRandom < 3){
        	status = PlayerState.ACTIVE;
        }else if(tempRandom > 7){
        	status = PlayerState.DEAD;
        }
        else{
        	status = PlayerState.WAITING;
        }
        
    }

    @Override
    public String toString() {
        if (status.equals(PlayerState.ACTIVE)){
            return ("<html>Player" + HANDLE + " (IP: " + IP_ADDRESS + ") | State: " + status
                    +  " <br> Health: " + lifeAmount + "%" + " | Position: (" + positionX + 
                    ", " + positionY + ") | Time: " + time + "s<br><br><html>");
        }else {
            return ("<html>Player" + HANDLE + " (IP: " + IP_ADDRESS + ") | State: " + status
                    +  " <br> Health: " + lifeAmount + "%" + " | Position: (" + positionX + 
                    ", " + positionY + ")<br><br><html>");
        }
    	

    }
    
    public int getLifeAmount() {
        return lifeAmount;
    }
    
    public int getPositionX(){
    	return positionX;
    }
    
    public int getPositionY(){
    	return positionY;
    }
    
    public String getStatus(){
    	return status.toString();
    }
    
    public int getTime(){
    	return time;
    }
    
    public void setLifeAmount(int lifeAmount) {
        this.lifeAmount = lifeAmount;
    }
    
    public void setPositionX(int positionX){
    	this.positionX = positionX;
    }
    
    public void setPositionY(int positionY){
    	this.positionY = positionY;
    }
    
    public void setStatus(PlayerState status){
    	this.status = status;
    }
    
    public void setTime(int time){
    	this.time = time;
    }
    
    public enum PlayerState {
		ACTIVE, DEAD, WAITING;
		
		@Override 
		public String toString () {
	        String result = super.toString();
	        result = result.substring (0, 1).toUpperCase() + result.substring(1).toLowerCase();
	        return result;
	    }
	}
}// End Player Class
