package team2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author william
 */
public class PlayerList extends JList {
    private DefaultListModel<Player> playerList;
    
    public PlayerList() {
        playerList = new DefaultListModel();
    }
    
    public void initializePanel() {
        this.setModel(playerList);
    }
    
    
    public void addPlayer() {
        playerList.addElement(new Player());
    }
}

