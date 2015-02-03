/*
Team 9
*/
package team9;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class playerTable extends JPanel {
    /**
    * Default Constructor
    */
    public playerTable() {}

    /**
     * Constructor
     * @param playerList Full list of players
     * @param currentPlayer Player playing on the current client
     */
    public playerTable(Vector<Player> playerList, Player currentPlayer) {
        super(new GridLayout(1, 0));
        JTable table;
		
        table = new JTable(new PlayersTable(playerList, currentPlayer));

        JPanel panel = new JPanel();
	panel.add(table);
        
        for (int i = 0; i < playerList.size(); i++) {
            table.getColumnModel().getColumn(i)
                .setPreferredWidth(125);
            table.getColumnModel().getColumn(i)
                .setCellRenderer(new MyCellRenderer());
        }
        add(panel, BorderLayout.SOUTH);
    }

/*
Model used in the PlayerTable
*/
class PlayersTable extends AbstractTableModel {
    private String[] columnNames;
    private String[][] playerList;
    /**
    * Default model Constructor    
    */
    public PlayersTable() {
    }
     /**
     * Constructor
     * @param playerList Full list of players
     * @param currentPlayer Player on current client
     */
    public PlayersTable(Vector<Player> playerList, Player currentPlayer) {
        int size = playerList.size();
        columnNames = new String[size];
        for (int i = 0; i < size; i++) {
            columnNames[i] = null;
        }

        this.playerList = new String[1][size];

        int i = 0;
        for (Player player : playerList) {
            String playerInfo;
            if(player == currentPlayer){
                playerInfo = " Player " + currentPlayer.getPlayerNum()+ ":\n Me";
            }
            else{
                playerInfo = " Player "+player.getPlayerNum()+"\n Last seen: \n "+
                    player.getLoc().toString(); 
            }
        setValueAt(playerInfo, 0, i);
        i++;
        } 
    }
    
    //Sets the value to be given in each cell
    private void setValueAt(String playerInfo, int row, int column) {
        playerList[row][column] = playerInfo;
        fireTableCellUpdated(row, column);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return 1;
    }
        
    // Reads the value given for a give cell
    @Override
    public Object getValueAt(int row, int column) {
        return playerList[row][column];
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