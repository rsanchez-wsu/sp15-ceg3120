/*
Team 9
Matthew Lents
*/
package team9;

import javax.swing.*;


public class TEAM9 {
    
    
    public static void createClientGUI(){
        Client Client = new Client();
        Client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        Client.pack();
        Client.setVisible(true);
    }
    
    public static void main(String[] args) {
       
        createClientGUI(); 
    }
    
}
