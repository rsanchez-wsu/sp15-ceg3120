/*
Team 9
*/
package team9;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;



class Client extends JFrame {
    
    /*
    Builds and fills the Frame with different tables for each area of the game
    */
    public Client(){
        //Table for each player stats
        JTable playerTable = new JTable(new playerTableModel());
        playerTable.setRowHeight(75);
        for(int i =0; i < playerTable.getColumnCount();i++){
            playerTable.getColumnModel().getColumn(i).setCellRenderer(new TextAreaCellRenderer());
        }
        //Table for game stats
        JTable gameTable = new JTable(new gameTableModel());
        gameTable.setRowHeight(50);
        gameTable.getColumnModel().getColumn(1).setCellRenderer(new TextAreaCellRenderer());
        gameTable.getColumnModel().getColumn(0).setMinWidth(100);
        gameTable.getColumnModel().getColumn(1).setPreferredWidth(1000);
        //Table to show the positions of each player on the map
        JTable mapTable = new JTable(new mapTableModel());
        mapTable.setRowHeight(23);
        for(int i =0; i<mapTable.getColumnCount();i++){
            mapTable.getColumnModel().getColumn(i).setPreferredWidth(23);
        }
        //Add each table to the JFrame in the appropriate locations
        add(mapTable, BorderLayout.NORTH);
        add(gameTable, BorderLayout.CENTER);
        add(playerTable,BorderLayout.SOUTH);
    }
    //Place holder for the model of the mapTable
    //More work needed to refine 
    class mapTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 25;
        }

        @Override
        public int getColumnCount() {
           return 45;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }
    }

    //Model used to create the playerTable 
    //Work needed to refine
    class playerTableModel extends AbstractTableModel{
        //Placed data for ease of creation
        Player[] players = {
            new Player(1),new Player(2),new Player(3),new Player(4),
            new Player(5),new Player(6),new Player(7),new Player(8),
        };
        
        @Override
        public int getColumnCount(){
            return players.length;
        }
    
        @Override
        public int getRowCount(){
            return 1;
        }
        //Shows the data inside each cell
        @Override
        public Object getValueAt(int x, int y){
            return ("Player "+ players[y].getPlayerNum()+"\n"+
                "Last seen:"+"\n"+
                players[y].getLastLoc().toString());
        }
    }
    
    //Model to be used in the gameTable
    //Work needed
    class gameTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }
        //Work needed to correctly show the correct data instead of a String
        @Override
        public Object getValueAt(int row, int col) {
            if(col == 0){return "Status";}
            else{
                return ("Game Info - Status: In Progress | "
                        + "Server: 10.229.154.17 | "
                        + " Players Left 6" + "\n "
                        + "My Info - # 6 | Health: 11/50 "                      
                        + "| Position: (60,25) | State: Wait");
            }
        }
    
    } 
    
    //CellRenderer to enable the textWrap in certain cells
    private static class TextAreaCellRenderer extends JTextArea implements TableCellRenderer {
       
        public TextAreaCellRenderer() {
            setLineWrap(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setFont(table.getFont());
            setText((value == null)?" ": value.toString());
            return this;
        }

        
    }
}
