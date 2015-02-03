package team2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
