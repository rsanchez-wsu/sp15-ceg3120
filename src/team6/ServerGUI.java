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

package team6;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
//import java.util.Arrays;

//This class currently takes hardcoded tankobjects, in a 2d array, and displays
//them in a table.  Will adapt to accept GameState objects, or at least a return
//from a GameState.toArray call.

@SuppressWarnings("serial")
public class ServerGUI extends JPanel {	
	
    private static ServerGUI instance= new ServerGUI();    
    JTable table; 
    String[] columnNames = {"Tank Image", "Name", "IP",
            "x coord", "y coord", "Health","Status"};
   
    //will be at most 8 tanks in the game, but tank object structure isnt finalized
    Object[][] data = new Object[8][]; 
    
    //when ever updating gameInstance, make sure to reparse the data into the array; untill the data object is factored out.
    public GameInstance game=new GameInstance();
    
    public ServerGUI() {
    	
        super(new GridLayout(1, 0));
        
        for (int i=0;i<8;i++){
        	data[i]=game.tanks.get(i).toStringArray();
        }
        JTable table = new JTable(data, columnNames);
        this.table=table;

        table.setPreferredScrollableViewportSize(new Dimension(800, 180));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);        
    }// end ServerTankObjectGUI()

    public ServerGUI(GameInstance game) {
        super(new GridLayout(1, 0));
                Object[][] data = new Object[8][]; 
        
        
        for (int i=0;i<8;i++){
        	data[i]=game.tanks.get(i).toStringArray();
        }
        JTable table = new JTable(data, columnNames);

        table.setPreferredScrollableViewportSize(new Dimension(800, 180));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);        
    }// end ServerTankObjectGUI()
    
    //Status bar for Server GUI
    public void statusBar(JFrame frame){

    	JPanel statBar = new JPanel();
    	statBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
    	frame.add(statBar, BorderLayout.SOUTH);

    	JLabel statInfo = new JLabel("DB Status:             Game Status:");
    	
    	statBar.add(statInfo);

    	frame.setVisible(true);
    	    
    }

    public void updateTable(GameInstance game)
    {   
    	this.game=game;//needed because this class has redunant data representation; move 2d array into game instance later.
    	for (int i=0;i<8;i++){
        	data[i]=game.tanks.get(i).toStringArray();
        }
    	//removed debugging info   	
       table.setModel(new DefaultTableModel(data,columnNames ));       
    }//updateTable
    
    
    //not needed instance should always be initilized now  - mason
    public static ServerGUI getInstance(){
        return instance;
    }//end getinstance
    

    
}// end ServerTankObjectGUI Class

