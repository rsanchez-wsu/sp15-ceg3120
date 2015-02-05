package team2;

import java.awt.*;
import javax.swing.*;

public class ServerGUI extends JPanel{
	// Needs to put the game history and details panes into a split pane frame
	// and show itself.
	
	private JSplitPane serverSplitPane;
	private JPanel gameDetails;
	private JPanel gameHistory;
	
	public ServerGUI() {		
		
		gameDetails = new GameDetailsPane();
		gameHistory = new GameHistoryPane();
		
		serverSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				gameHistory, gameDetails);
		
        serverSplitPane.setPreferredSize(new Dimension(600, 400));
        serverSplitPane.setDividerLocation(200);
        
	}
	
	public JSplitPane getGUI(){
    	return this.serverSplitPane;
    }
}
