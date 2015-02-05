package team5.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import team5.PlayerObject.Player;

public class ClientBoardTable extends JPanel{

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

	public ClientBoardTable() {

	}

	/**
	 * Status Bar Constructor
	 */
	public ClientBoardTable(Vector<Player> playerList, Player actualPlayer) {
		super(new GridLayout(1, 0));
		
		table = new JTable(new GameTable(playerList, actualPlayer));
		playerModel = playerList;
		
		//Set up keyboard listener for PlayerTabs
		
		JScrollPane scrollPanel = new JScrollPane(table);

		for (int i = 0; i < playerList.size(); i++) {
			table.getColumnModel().getColumn(i)
					.setCellRenderer(new ImageRenderer());
		}
		
		
		
		table.setGridColor(Color.BLACK);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setShowGrid(true);
		add(scrollPanel, BorderLayout.SOUTH);
	}

	class GameTable extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private String[] columnNames;
		private String[][] gameGrid;

		public GameTable() {

		}

		public GameTable(Vector<Player> playerList, Player actualPlayer) {
			
			columnNames = new String[64];

			for (int i = 0; i < 64; i++) {
				columnNames[i] = null;
			}

			this.gameGrid = new String[64][64];
			for(int i = 0; i < 64; i++){
				for(int j = 0; j < 64; j++){
					setValueAt("  ", i, j);
				}
			}
		}

		public void setValueAt(String playerInfo, int row, int column) {
			gameGrid[row][column] = playerInfo;
			fireTableCellUpdated(row, column);
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return gameGrid.length;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return gameGrid[row][column];
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
			table.setRowHeight(10);

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
