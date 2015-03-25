
/*
 *  Copyright (C) <2015>  <Brandon Head, Matthew Hemker, Hien Long, Maxwell Nukpor>
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

package team8;

public class Player {

    int playerNumber;
    String ipAddress;
    enum State {WAIT, ACTIVE, DEAD};
    State playerState;
    int health;
    String position;

    public Player(int number) {
        this.playerNumber = number;
        this.ipAddress = "127.0.0.1";
        this.playerState = State.WAIT;
        this.health = 50;
        this.position = "(28, 19)";
    }
    
    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public State getPlayerState() {
        return playerState;
    }

    public void setPlayerState(State playerState) {
        this.playerState = playerState;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    @Override public String toString()
    {
        return " Player " + playerNumber + " (" + ipAddress + ") " + "| State: " 
               + playerState + " | Health: " + health + "/50" + " | Position: " + position;
    }//end to string

}
