package team2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import javax.swing.JFrame;


/**
 *
 * @author william
 */
public class Team2_SimpleJList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hatfield: CEG-3120");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PlayerList panel = new PlayerList();
        for(int i = 0; i < 20; i++) {
            panel.addPlayer();
        }
        
        panel.initializePanel();
        
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        
    }
    
}
