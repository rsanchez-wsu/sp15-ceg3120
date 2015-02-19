/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 *  Copyright (C) <2015>  <Team 6>
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
//
package team6;

import javax.swing.*;

import java.awt.*;

//This class just creates a frame, and adds what ever panel we are testing
public class driver {

    @SuppressWarnings("serial")
	public static void main(String[] args) {
      
        JFrame gameFrame = new JFrame("game GUI Demo");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        center(gameFrame);

        GameRenderer renderer = new GameRenderer() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(64*50, 64*50); //hard coded tile size must be updated here and in renderer
            }
        };
        gameFrame.getContentPane().add(new JScrollPane(renderer), BorderLayout.CENTER);      
        gameFrame.setVisible(true);
        
        
       //JFrame serverFrame2 = new JFrame("server GUI Demo");
        ServerTree tree = new ServerTree();
       //serverFrame2.add(tree);
       //serverFrame2.pack();
       // serverFrame2.setVisible(true);
        
        JFrame serverFrame = new JFrame("server GUI Demo");
        ServerGUI table = ServerGUI.getInstance();
        serverFrame.add(table,BorderLayout.CENTER);        
        serverFrame.pack();
        serverFrame.setVisible(true);
        
        serverFrame.add(tree,BorderLayout.WEST);
        
        
    }// end main
  
    

    public static void center(JFrame frame) {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point center = ge.getCenterPoint();
        int windowX = 1024;
        int windowY = 640;
        int x = center.x - windowX / 2;
        int y = center.y - windowY / 2;
        frame.setBounds(x, y, windowX, windowY);
        frame.validate();
    }
    
    
    
    
}//end main class

