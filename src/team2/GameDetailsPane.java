package team2;

import java.awt.*;

import javax.swing.*;

public class GameDetailsPane extends JPanel{
	
	private JLabel header;
	private JList playerList;
	private JLabel footer;
	
	public GameDetailsPane(){
		
		header = new JLabel("Game Details");
		
		footer = new JLabel("Game Status: [Waiting/In Progress/Complete]");
		
		playerList = new JList();
		JScrollPane playerListScroll = new JScrollPane(playerList);
		DefaultListModel model = new DefaultListModel();
		playerList.setModel(model);
		
		//make 8 dummy players
		for (int i = 0; i < 7; i++){
			model.addElement(new Player());
		}
		      
		setLayout(new BorderLayout());
		add(header, BorderLayout.NORTH);
		add(playerListScroll, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
		
	}

}
