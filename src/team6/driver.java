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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//This class just creates a frame, and adds what ever panel we are testing
public class driver {

    public static void main(String[] args) {
      
        JFrame frame = new JFrame("Server GUI Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ServerTankObjectGUI test = new ServerTankObjectGUI();
        GameTree tree = new GameTree();
        GameRenderer renderer = new GameRenderer();
        
        test.setOpaque(true); //content panes must be opaque
        //frame.setContentPane(test);
        //frame.add(tree);
        frame.add(renderer);
        //Display the window.
        frame.pack();
        frame.setVisible(true);  
    }// end main
}//end main class

