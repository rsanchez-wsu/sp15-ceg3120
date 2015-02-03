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
