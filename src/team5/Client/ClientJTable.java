/*
 *  Copyright (C) <2015>  <Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker>
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
package team5.Client;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import team5.PlayerObject.Player;

/**
 * @author Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker
 */

public class ClientJTable extends JPanel {
	/**
	 * ClientJList Variables
	 */
	private static final long serialVersionUID = 1L;
	private JList<Player> list;
	private DefaultListModel<Player> listModel;

	/**
	 * Default Constructor
	 */
	
	public ClientJTable() {

	}

	/**
	 * Status Bar Constructor
	 */
	public ClientJTable(Vector<Player> playerList, Player actualPlayer) {
		super(new GridLayout(1,0));
		JTable table;
		table = new JTable(new PlayersTable(playerList, actualPlayer));
		
		JScrollPane scrollPanel = new JScrollPane(table);
		add(scrollPanel, BorderLayout.SOUTH);
	}

	class PlayersTable extends AbstractTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private String[] columnNames;
		private Image[][] playerList;
		
		public PlayersTable(){
			
		}
		
		public PlayersTable(Vector<Player> playerList, Player actualPlayer){
			int size = playerList.size();
			columnNames = new String[size];
			
			for(int i = 0; i < size; i++){
				columnNames[i] = "";
			}
			
			this.playerList = new Image[1][size];
			
			int i = 0;
			for(Player player : playerList){
				setValueAt(player, 0, i);
				i++;
			}
		}
		
		
		public void setValueAt(Player player, int row, int column, Player actualPlayer){
		//	if(this.playerList[row][column].contains(actualPlayer.getPlayerNumber())){
		//		
		//	}
			this.playerList[row][column] = player.getPlayerImage();
			fireTableCellUpdated(row, column);
		}
		
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return playerList.length;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return this.playerList[row][column];
		}
		
		public boolean isCellEditable(int row, int column){
			return false;
		}
		
		public String getColumnName(int column){
			return this.columnNames[column].toString();
		}
	}
}
