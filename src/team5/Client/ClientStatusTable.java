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
import javax.swing.table.DefaultTableCellRenderer;

import team5.PlayerObject.Player;

/**
 * @author Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker
 */

public class ClientStatusTable extends JPanel {
	/**
	 * ClientJList Variables
	 */
	private static final long serialVersionUID = 1L;
	Thread tabThread;
	PlayerTabs tabs = null;
	JTable table;
    Vector<Player> playerModel;
    JFrame playerTabsFrame;
	 
	/**
	 * Default Constructor
	 */

	public ClientStatusTable() {

	}

	/**
	 * Status Bar Constructor
	 */
	public ClientStatusTable(Vector<Player> playerList, Player actualPlayer) {
		super(new GridLayout(1, 0));
		
		table = new JTable(new PlayersTable(playerList, actualPlayer));
		playerModel = playerList;
		
	    
		
		//Set up mouse listener for PlayerTabs
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int column = table.columnAtPoint(e.getPoint());
				String infoString = "";
				tabThread = new Thread();
				

					if(playerTabsFrame == null){
						playerTabsFrame = new JFrame();
						tabs = new PlayerTabs(playerModel);
	    				tabs.setColumns(playerModel.size());
						playerTabsFrame.add(tabs);
						playerTabsFrame.setSize(300, 300);
						playerTabsFrame.setAlwaysOnTop(true);
						playerTabsFrame.setLocationRelativeTo(null);
					}
						
					if(tabs.getTabCount() != 0){	
						tabs.setSelectedIndex(column);
					}else{
					
					tabThread.run();
					tabThread.setName("Tab Thread");
					
					playerTabsFrame.setVisible(true);
					for(Player player : playerModel){
						Player temp = player;
						String tabTitle = "Player " + temp.getPlayerNumber();
						JLabel playerInfo = new JLabel();
						
						infoString = temp.toString();
						playerInfo.setText(infoString);
						
						tabs.addTab(tabTitle, playerInfo);
						
					}
					tabs.setSelectedIndex(column);
				}
					playerTabsFrame.addWindowListener(new java.awt.event.WindowAdapter(){
						@Override
						public void windowClosing(java.awt.event.WindowEvent windowEvent){
							tabs = null;
							playerTabsFrame = null;
						}
					});
			} 
		});

		JScrollPane scrollPanel = new JScrollPane(table);

		for (int i = 0; i < playerList.size(); i++) {
			table.getColumnModel().getColumn(i)
					.setCellRenderer(new ImageRenderer());
		}

		add(scrollPanel, BorderLayout.SOUTH);
	}

	class PlayersTable extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private String[] columnNames;
		private String[][] playerList;

		public PlayersTable() {

		}

		public PlayersTable(Vector<Player> playerList, Player actualPlayer) {
			int size = playerList.size();
			columnNames = new String[size];

			for (int i = 0; i < size; i++) {
				columnNames[i] = null;
			}

			this.playerList = new String[1][size];

			int i = 0;
			for (Player player : playerList) {
				String playerInfo = "";

				if (player == actualPlayer) {
					playerInfo = "Player " + actualPlayer.getPlayerNumber()
							+ ": Me";
					setValueAt(playerInfo, 0, i);
				} else {
					setValueAt(((EnemyPlayer) player).printPosition(), 0, i);

				}
				i++;
			}
		}

		public void setValueAt(String playerInfo, int row, int column) {
			// if(this.playerList[row][column].contains(actualPlayer.getPlayerNumber())){
			//
			// }
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

		@Override
		public Object getValueAt(int row, int column) {
			return playerList[row][column];
		}

		public boolean isCellEditable(int row, int column) {
			return false;
		}

		public String getColumnName(int column) {
			return this.columnNames[column];
		}

	}

	class ImageRenderer extends DefaultTableCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		JLabel lbl = new JLabel();

		public void setRow(JTable table) {
			table.setRowHeight(95);

		}

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {

			setRow(table);

			ImageIcon icon = null;
			icon = new ImageIcon(getClass().getResource(
					"/team5/Client/worldwartank.png"));
			lbl.setText((String) value);
			lbl.setHorizontalAlignment(JLabel.CENTER);
			lbl.setIcon(icon);

			return lbl;
		}
	}

}
