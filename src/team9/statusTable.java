package team9;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class statusTable extends JPanel {
    
    public statusTable(){        
    }
    
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
    
    class StatusTable extends AbstractTableModel{
        
        private String[] columnNames;
        private String[][] statusList;
        private int playersRemaining=0;
        public StatusTable(){
            
        }
        
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
