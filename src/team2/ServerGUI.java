package team2;
/*
* Copyright (C) <2015> <Team 2>
* 
* Will Hatfield
* Kevin Alig
* Alyssa Ramsey
* Anthony Lamping
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
import java.awt.*;
import javax.swing.*;

public class ServerGUI extends JPanel{
	// Needs to put the game history and details panes into a split pane frame
	// and show itself.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
