/*
 * Copyright (C) 2015 - Matthew J Lents mlents0929@gmail.com
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
package team9;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class statusTable extends JPanel {
    /**
    * Default Constructor
    */
    public statusTable(){        
    }
    /**
     * Constructor
     * @param playerList Full list of players
     * @param currentPlayer Player playing on the current client
     */
    public statusTable(Vector<Player> playerList, Player currentPlayer){
        super(new GridLayout(1,0));
        JTable table;
        
        table = new JTable(new StatusTable(playerList, currentPlayer));
        table.setRowHeight(200);
        JPanel panel = new JPanel();
	panel.add(table);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(900);
        table.getColumnModel().getColumn(1)
                .setCellRenderer(new MyCellRenderer());
        add(panel, BorderLayout.SOUTH);
        
    }
    /*
    Model used in the statusTable
    */    
    class StatusTable extends AbstractTableModel{
        // Initialize variables
        private String[] columnNames;
        private String[][] statusList;
        private int playersRemaining=0;
        /**
        * Default model Constructor    
        */
        public StatusTable(){
        }
        /**
        * Constructor
        * @param playerList Full list of players
        * @param currentPlayer Player on current client
        */
        public StatusTable(Vector<Player> playerList, Player currentPlayer){
            columnNames = new String[2];
            for(int i=0;i<columnNames.length;i++){
                columnNames[i]=null;
            }
            this.statusList=new String[1][2];
            for(int i =0;i<2;i++){
                String statusInfo;
                if(i==0){
                    statusInfo="Status";
                }
                else{
                    for (Player player : playerList) {
                        if(player.getHealth()>1){
                            playersRemaining++;
                        }
                    }
                    statusInfo="Game Info - Status: In Progress | Server: 01.10.01.10"+
                            " | Players Left: "+playersRemaining+"\n My Info - #: "+ currentPlayer.getPlayerNum()+
                            " | Health: "+currentPlayer.getHealth()+"/50 | Position: "+
                            currentPlayer.getLoc().toString()+" state: "+currentPlayer.getStatus(currentPlayer);
                    playersRemaining=0;
                }
                setValueAt(statusInfo,0,i);
            }
        }
        //Sets the value to be given in each cell
        private void setValueAt(String statusInfo,int row, int col){
            statusList[row][col] = statusInfo;
            fireTableCellUpdated(row,col);
        }
        
        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        // Reads the value given for a give cell
        @Override
        public Object getValueAt(int row, int column) {
            return statusList[row][column];
        }
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public String getColumnName(int column) {
            return this.columnNames[column];
        }
    }         
/**
* Enables the ability to change the text in the given cell
*/   
public class MyCellRenderer extends JTextArea implements TableCellRenderer {
    public MyCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object
            value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());//or something in value, like value.getNote()...
        setSize(table.getColumnModel().getColumn(column).getWidth(),
            getPreferredSize().height);
        if (table.getRowHeight(row) != getPreferredSize().height) {
            table.setRowHeight(row, getPreferredSize().height);
        }
    return this;
    }
    } 
   
}
