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

import team5.PlayerObject.Pair;
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
		JScrollPane scrollPanel = new JScrollPane(table,
			    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		for (int i = 0; i < playerList.size(); i++) {
			table.getColumnModel().getColumn(i)
					.setCellRenderer(new ImageRenderer());
		}
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setGridColor(Color.BLACK);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setShowGrid(true);
		add(scrollPanel, BorderLayout.SOUTH);
		for (int i = 0; i < 64; i++) {
			table.getColumnModel().getColumn(i)
					.setCellRenderer(new ImageRenderer());
			table.getColumnModel().getColumn(i).setPreferredWidth(170);
		}
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
			Pair position = new Pair();
			columnNames = new String[64];
			
			for (int i = 0; i < 64; i++) {
				columnNames[i] = null;
			}

			this.gameGrid = new String[64][64];
			for(int i = 0; i < 64; i++){
				for(int j = 0; j < 64; j++){
					setValueAt(null, i, j);
				}
			}
			
			position = actualPlayer.getPosition();
			setValueAt(actualPlayer.getState(), position.getxPos(), position.getyPos());
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
			table.setRowHeight(130);
		}

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			ImageIcon icon = null;
			Vector<Player> playerList = playerModel;
			setRow(table);
			for(Player player : playerList){
				
					   if((row == 5 && column == 6) || (row == 20 && column == 25) ||
								(row == 10 && column == 30) || (row == 26 && column == 35) || 
								(row == 45 && column == 50) || (row == 28 && column == 55)){
							icon = new ImageIcon(getClass().getResource(
									"/team5/Client/mountain.png"));
							lbl.setIcon(icon);
							break;
						}
						else if((row == 5 && column == 6) || (row == 20 && column == 25) ||
								(row == 17 && column == 35) || (row == 26 && column == 19) || 
								(row == 47 && column == 16) || (row == 37 && column == 55)){
							icon = new ImageIcon(getClass().getResource(
									"/team5/Client/water.png"));
							lbl.setIcon(icon);
							break;
						}
						else if((row == 18 && column == 17) || (row == 26 && column == 24) ||
								(row == 39 && column == 62) || (row == 62 && column == 45) || 
								(row == 48 && column == 29) || (row == 49 && column == 17)){
							icon = new ImageIcon(getClass().getResource(
									"/team5/Client/grass.png"));
							lbl.setIcon(icon);
							break;
						}
						else if(player.getPosition() != null){
							if(player.getPosition().getxPos() == row && 
									player.getPosition().getyPos() == column){
								icon = new ImageIcon(getClass().getResource(
										"/team5/Client/worldwartank.png"));
								lbl.setIcon(icon);
								break;
							}
						}
						else{
							icon = new ImageIcon(getClass().getResource(
									"/team5/Client/plane.png"));
							lbl.setIcon(icon);
							break;
						}
					}
				

			return lbl;
		}
	}

	
	
}
