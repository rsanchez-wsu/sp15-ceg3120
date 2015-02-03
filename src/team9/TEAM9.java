/*
Team 9
*/
package team9;

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class TEAM9 extends Thread{
    Vector<Player> players = new Vector<>();
    
    //Create and run the GUI
    @Override
    public void run(){
        // Initialize Variables
        Player currentPlayer;
        Player playerPlaying;
        JPanel gameBoard;
        JFrame frame;
        JPanel gamePanel;
        JPanel statusPanel;
        statusTable statusTable;
        playerTable playerTable;
        JSplitPane splitPaneA;
        JSplitPane splitPaneB;
        

        // Method to create dummy players
        gatherPlayers();

        // Get the client player
        currentPlayer = players.get(5);

       

        // Stand in for the game pane 
        // 
        gameBoard = new JPanel();
        gameBoard.setBackground(Color.BLACK);

        // Create a panel for the game map pane
        gamePanel = new JPanel();
        gamePanel.setOpaque(true);
        gamePanel.setLayout(new GridLayout(1,0));

        // Create a panel for the status table
        statusPanel = new JPanel();
        statusPanel.setOpaque(true);
        statusPanel.setLayout(new GridLayout(1,0));

        // Create tables for each area
        statusTable = new statusTable(players, currentPlayer);
        playerTable = new playerTable(players, currentPlayer);
        
        // Add tables to their panels
        gamePanel.add(gameBoard);
        statusPanel.add(statusTable);
        
        // Initial splitPane to contain the bottom two panes
        splitPaneB = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPaneB.add(statusPanel, JSplitPane.TOP);
        splitPaneB.add(playerTable, JSplitPane.BOTTOM);

        // Over splitPane to contain the first 2 panes along with the game pane
        splitPaneA = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPaneA.add(gamePanel, JSplitPane.TOP);
        splitPaneA.add(splitPaneB, JSplitPane.BOTTOM);

        // Add and select the settings for the frame
        frame = new JFrame("Client");
        frame.setLayout(new GridLayout(1,0));
        frame.setTitle("#InsertNameHere");
        frame.add(splitPaneA);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    // Method to create dummy players
    // Will be changed at a later date
    protected void gatherPlayers(){
        for(int i=0;i<8;i++){
            players.addElement(new Player(i+1));
            Coordinate startingCoord = new Coordinate(i+10,i+11);  
            players.elementAt(i).setLoc(startingCoord);
            Coordinate lastSeen = new Coordinate(-1,-1);
            players.elementAt(i).setLastSeen(lastSeen);
        }
        
    }
    public static void main(String[] args) {
       (new TEAM9()).start();
    }
    
}
