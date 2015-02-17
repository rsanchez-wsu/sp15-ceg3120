package team3;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class TankGame {

	public static void main(String args[]) {
		
		//start method
		//makes the tabbedpane
		final JFrame frame3 = new JFrame();
		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Player 1", new JLabel("Player 1 info"));
		tabbedPane.addTab("Player 2", new JLabel("Player 2 info:"));
		tabbedPane.addTab("Player 3", new JLabel("Player 3 info:"));
		tabbedPane.addTab("Player 4", new JLabel("Player 4 info:"));
		tabbedPane.addTab("Player 5", new JLabel("Player 5 info:"));
		tabbedPane.addTab("Player 6", new JLabel("Player 6 info:"));
		tabbedPane.addTab("Player 7", new JLabel("Player 7 info:"));
		tabbedPane.addTab("Player 8", new JLabel("Player 8 info:"));
		frame3.setLocationRelativeTo(null);
		frame3.add(tabbedPane);
		frame3.setSize(800, 400);
		frame3.setVisible(false);
		frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//end method
		
		//makes the player number 3
		int myNumber = 3;
		
		//makes when the players were last seen
		Point[] lastSeen = {new Point(-1,-1), new Point(-1,-1), new Point(-1,-1), new Point(-1,-1), new Point(-1,-1), new Point(-1,-1), new Point(5,24), new Point(-1,-1)};
		Object[][] table = new Object[64][64];
		Object[] columns = new Object[64];
		
		//start method
		//makes the loading frame
		JFrame loadFrame = new JFrame();
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Generating Map..."));
		loadFrame.add(p1);
		loadFrame.setVisible(true);
		loadFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		loadFrame.setLocationRelativeTo(null);
		loadFrame.setSize(200, 100);
		loadFrame.setResizable(false);
		//end method
		
		//makes a new map
		GameMap myMap = new GameMap();
		
		//gets rid of the loading frame
		loadFrame.setVisible(false);
		
		//start method
		//makes the game map
		for(int i = 0; i < 64; i++) {
			columns[i] = ' ';
			for(int j = 0; j < 64; j++) {
				if(myMap.terrainType(i, j) == 0) {
					table[i][j] = 0;
				}//end of if
				else if(myMap.terrainType(i, j) == 1) {
					table[i][j] = 1;
				}//end of if
				else if(myMap.terrainType(i, j) == 2) {
					table[i][j] = 2;
				}//end of if
				else if(myMap.terrainType(i, j) == 3) {
					table[i][j] = 3;
				}//end of if
				else {
					table[i][j] = 4;
				}//end of else
				if(myMap.isOccupied(i, j) >= 0) {
					table[i][j] = (char)(myMap.isOccupied(i, j) + 49);
					//System.out.println((char)(myMap.isOccupied(i, j) + 49));
				}//end of if
			}//end of for
		}//end of for
		//end method
		
		//creates a new table model
		DefaultTableModel model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return char.class;
			}//end of getColumnClass
		};
		
		DefaultListModel listM = new DefaultListModel();
		listM.setSize(16);
		
		//method with the table data
		//creates a table and makes it so you can't move the columns around
		JTable myTable = new JTable(model);
		model.setDataVector(table, columns);
		myTable.getTableHeader().setVisible(false);
		myTable.getTableHeader().setPreferredSize(new Dimension(0,0));
		//end method
		
		//method
		//sets up the array of players
		Player[] players= new Player[8];
		for(int i = 0; i < 8; i++) {
			players[i] = new Player(i + 1);
		}//end of for
		// end method
		
		//method
		//sets the locations of each player, needs to be changed how it is done
		players[0].setLocation(new Point(0, 0));
		players[1].setLocation(new Point(0, 8));
		players[2].setLocation(new Point(0, 16));
		players[3].setLocation(new Point(0, 24));
		players[4].setLocation(new Point(63, 63));
		players[5].setLocation(new Point(43, 21));
		players[6].setLocation(new Point(5, 24));
		players[7].setLocation(new Point(63, 0));
		//end method
		
		//method
		//sets where the player has last seen each opponent, need to change how it is done
		players[myNumber - 1].setSeen(lastSeen);
		//end method
		
		//method
		//creates the arrays that will be displayed
		Object[] display = new String[16];
		Object[] otherDisplay = new String[18];
		
		//adds the information to the gameinfo display
		otherDisplay[0] = "GAME INFO";
		otherDisplay[1] = "\n";
		otherDisplay[2] = "Status: In Progress";
		otherDisplay[3] = "\n";
		otherDisplay[4] = "Server: 10.229.154.17";
		otherDisplay[5] = "\n";
		otherDisplay[6] = "Players left: 6";
		otherDisplay[7] = "\n";
		otherDisplay[8] = "MY INFO";
		otherDisplay[9] = "\n";
		otherDisplay[10] = "Number: " + myNumber;
		otherDisplay[11] = "\n";
		otherDisplay[12] = "Health: " + players[myNumber - 1].getHealth() + "/50";
		otherDisplay[13] = "\n";
		otherDisplay[14] = "Position: " + players[myNumber - 1].getLocation().toString();
		otherDisplay[15] = "\n";
		otherDisplay[16] = "State: Wait";
		otherDisplay[17] = "\n";
		//end method
		
		//method
		//creates the display of players
		//if the player is the same as myNumber, display me rather than when the player was last seen
		for(int i = 0; i < 8; i++) {
			if(i + 1 == myNumber){
				display[i * 2] = "Player " + myNumber + ": Me";
				listM.set(i*2, "Player " + myNumber + ": Me");
			}//end of if
			else{
				display[i * 2] = "Player " + (i + 1) + ": Last seen:\n" + players[myNumber - 1].getSeen()[i].toString(); 
			}//end of else
			display[(i*2) + 1] = Integer.toString(i + 1);
			listM.set(i*2 + 1, Integer.toString(i + 1));
		}//end of for
		//end method

		//creates the lists, adds them to a panel, and adds the panel to a JFrame
		JList<Object> list = new JList<Object>(display);
		ListCellRenderer listRenderer = new CustomListCellRenderer();
		list.setCellRenderer(listRenderer);
		JList<Object> otherList = new JList<Object>(otherDisplay);

		//method
		//put in the myTable method
		//creates the new table renderer
		myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableCellRenderer renderer = new CustomTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		try{
		myTable.setDefaultRenderer(char.class, renderer);
		}
		catch( Exception e){}
		finally{}
		
		myTable.setShowGrid(false);
		myTable.setRowHeight(32);
		
		for(int i = 0; i < 64; i++) {
			myTable.getColumnModel().getColumn(i).setPreferredWidth(32);
		}
		JScrollPane myScroll = new JScrollPane(myTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//end method
		
		//method
		list.setBackground(Color.BLACK);
		list.setForeground(Color.WHITE);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//end method
		
		//method
		otherList.setBackground(Color.BLACK);
		otherList.setForeground(Color.WHITE);
		otherList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//end method
		
		//method
		JPanel p = new JPanel(new BorderLayout());
		p.add(list, BorderLayout.WEST);	
		p.add(otherList, BorderLayout.EAST);
		p.add(myScroll, BorderLayout.CENTER);
		JFrame frame = new JFrame();
		frame.add(p);
		frame.setSize(1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//end method
		
		//put in the same method as frame3
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				@SuppressWarnings("unchecked")
				JList<Object> lsm = (JList<Object>)(listSelectionEvent.getSource());
				int indexSelected = lsm.getMinSelectionIndex() / 2;
				frame3.setVisible(true);
				tabbedPane.setSelectedIndex(indexSelected);
			}//end of value changed
		};
		list.addListSelectionListener(listSelectionListener);
	}//end of listSelectionListener
}//end of class