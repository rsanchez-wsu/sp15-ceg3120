/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdesign_hemker1;

/**
 *
 * @author TEAM ATE
 */
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

}
