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
import javax.swing.event.*;
import javax.swing.table.*;

public class playerTable extends JPanel {
	JTable table;
	JFrame treeFrame = new JFrame();
	playerTree playerTree;
	/**
	 * Default Constructor
	 */
	public playerTable() {}

	/**
	 * Constructor
	 * @param playerList Full list of players
	 * @param currentPlayer Player playing on the current client
	 */
	public playerTable(final Vector<Player> playerList, Player currentPlayer) {
		super(new GridLayout(1, 0));


		table = new JTable(new PlayersTable(playerList, currentPlayer));

		table.setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int selectedColumn = table.getSelectedColumn();
				if(!(selectedColumn<0)){

					Player selectedPlayer = playerList.elementAt(selectedColumn);

					table.clearSelection();
					playerTree = new playerTree(playerList, selectedPlayer);
					treeFrame.add(playerTree);
					Dimension minSize = new Dimension(300,300);
					treeFrame.setMinimumSize(minSize);
					treeFrame.setVisible(true);
				}
			}
		});

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
	public class MyCellRenderer extends JTextArea implements TableCellRenderer{
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