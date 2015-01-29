/*
Team 9
*/
package team9;

import javax.swing.*;


public class TEAM9 {
    
    //Create and run the GUI
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
