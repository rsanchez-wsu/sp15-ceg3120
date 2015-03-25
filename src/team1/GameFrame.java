/*
 *  Copyright (C) <2015>  Marie Hucke, Kristen Schwaiger, Kyle Wintermute, Kyle Wood
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

package team1;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;


public class GameFrame extends JFrame{
	
	private JList <Player> PlayerList;
	//private JLabel testLabel;
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Player> PlayerModel;
	
	public GameFrame() {
			createComponents();
			this.setSize(800, 600);
		}//end constructor
	
	private void createComponents(){
		
		//create the main panel that will contain all other panels
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		//create the panel to display player info
		JPanel playerDisplay = new JPanel();
		playerDisplay.setLayout(new GridLayout(1,8));
		
		//create the panel to display game grid
		Game_Map gameDisplay = new Game_Map();
		gameDisplay.setLayout(new BorderLayout());
		
		
		//create the players and add them to the list
		Player[] Players = new Player[8];
		PlayerList = new JList<Player>(Players);
		PlayerList.setVisibleRowCount(-1);
		PlayerModel = new DefaultListModel<Player>();
		
		//PLACEHOLDER PLAYERS
		int[] tempPos = new int[2]; tempPos[0] = 42; tempPos[1] = 108;
		PlayerModel.addElement(new Player("Adam")); ((Player)PlayerModel.get(0)).setPosition(tempPos);
		PlayerModel.addElement(new Player("Bob"));
		PlayerModel.addElement(new Player("Charles"));
		PlayerModel.addElement(new Player("Derrick"));
		PlayerModel.addElement(new Player("Edward"));
		PlayerModel.addElement(new Player("Frank"));
		PlayerModel.addElement(new Player("Garfield"));
		PlayerModel.addElement(new Player("Harry"));
		
		PlayerList = new JList<Player>(PlayerModel);
		PlayerList.setVisibleRowCount(8);
		
		//Assigning all players to JLablel objects -- displays Player Name, Last Seen
		//Player 1 JLabel
		String player1status = "<html>Player 1 Status" 
				+ " <br>Player Name: " + ((Player)PlayerModel.get(0)).getName() 
				+ "<br>Last Seen: "+ ((Player)PlayerModel.get(0)).getPosition()[0] + ", "
				+ ((Player)PlayerModel.get(0)).getPosition()[1]
						+"</html>";
		JLabel player1 = new JLabel(player1status);
	
		//Player 2 JLabel
		String player2status = "<html>Player 2 Status" 
				+ "<br>Player Name: " + ((Player)PlayerModel.get(1)).getName() 
				+ "<br>Last Seen: "+ ((Player)PlayerModel.get(1)).getPosition()[0] + ", "
				+ ((Player)PlayerModel.get(1)).getPosition()[1]
								+"</html>";
		JLabel player2 = new JLabel(player2status);
	
		//Player 3 JLabel
		String player3status = "<html>Player 3 Status" 
				+ "<br>Player Name: " + ((Player)PlayerModel.get(2)).getName()
				+ "<br>Last Seen: "+ ((Player)PlayerModel.get(2)).getPosition()[0] + ", "
				+ ((Player)PlayerModel.get(2)).getPosition()[1]
								+"</html>";
		JLabel player3 = new JLabel(player3status);
		
		//Player 4 JLabel
		String player4status = "<html>Player 4 Status" 
				+ "<br>Player Name: " + ((Player)PlayerModel.get(3)).getName() 
				+ "<br>Last Seen: "+ ((Player)PlayerModel.get(3)).getPosition()[0] + ", "
				+ ((Player)PlayerModel.get(3)).getPosition()[1]
								+"</html>";
		JLabel player4 = new JLabel(player4status);
		
		//Player 5 JLabel
		String player5status = "<html>Player 5 Status" 
				+ "<br>Player Name: " + ((Player)PlayerModel.get(4)).getName() 
				+ "<br>Last Seen: "+ ((Player)PlayerModel.get(4)).getPosition()[0] + ", "
				+ ((Player)PlayerModel.get(4)).getPosition()[1]
								+"</html>";
		JLabel player5 = new JLabel(player5status);
		
		//Player 6 JLabel
		String player6status = "<html>Player 6 Status" 
				+ "<br>Player Name: " + ((Player)PlayerModel.get(5)).getName() 
				+ "<br>Last Seen: "+ ((Player)PlayerModel.get(5)).getPosition()[0] + ", "
				+ ((Player)PlayerModel.get(5)).getPosition()[1]
								+"</html>";
		JLabel player6 = new JLabel(player6status);
		
		//Player 7 JLabel
		String player7status = "<html>Player 7 Status" 
				+ "<br>Player Name: " + ((Player)PlayerModel.get(6)).getName() 
				+ "<br>Last Seen: "+ ((Player)PlayerModel.get(6)).getPosition()[0] + ", "
				+ ((Player)PlayerModel.get(6)).getPosition()[1]
								+"</html>";
		JLabel player7 = new JLabel(player7status);
		
		//Player 8 JLabel
		String player8status = "<html>Player 8 Status" 
				+ "<br>Player Name: " + ((Player)PlayerModel.get(7)).getName() 
				+ "<br>Last Seen: "+ ((Player)PlayerModel.get(7)).getPosition()[0] + ", "
				+ ((Player)PlayerModel.get(7)).getPosition()[1]
								+"</html>";
		JLabel player8 = new JLabel(player8status);
		
		//Attaching JLabels to JSplit Panes
			//--remove borders, assign fixed size and divider position, disable manual resizing of each player window.
		//Combine Player 1 and Player 2
		JSplitPane playerPane0 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,player1,player2);
		playerPane0.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		playerPane0.setSize(200, 100);
		playerPane0.setDividerLocation(.5);
		playerPane0.setDividerSize(1);
		playerPane0.setEnabled(false);
		
		//Combine Player1,2 pane with Player 3
		JSplitPane playerPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,playerPane0,player3);
		playerPane1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		playerPane1.setSize(300, 100);
		playerPane1.setDividerLocation(.6666);
		playerPane1.setDividerSize(1);
		playerPane1.setEnabled(false);
		
		//Combine Player1,2,3 pane with Player 4
		JSplitPane playerPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,playerPane1,player4);
		playerPane2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		playerPane2.setSize(400, 100);
		playerPane2.setDividerLocation(.75);
		playerPane2.setDividerSize(1);
		playerPane2.setEnabled(false);
		
		//Combine Player1,2,3,4 pane with Player 5
		JSplitPane playerPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,playerPane2,player5);
		playerPane3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		playerPane3.setSize(500, 100);
		playerPane3.setDividerLocation(.80);
		playerPane3.setDividerSize(1);
		playerPane3.setEnabled(false);
		
		//Combine Player1,2,3,4,5 pane with Player 6
		JSplitPane playerPane4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,playerPane3,player6);
		playerPane4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		playerPane4.setSize(600, 100);
		playerPane4.setDividerLocation(.8333);
		playerPane4.setDividerSize(1);
		playerPane4.setEnabled(false);
		
		//Combine Player1,2,3,4,5,6 pane with Player 7
		JSplitPane playerPane5 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,playerPane4,player7);
		playerPane5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		playerPane5.setSize(700, 100);
		playerPane5.setDividerLocation(.8571);
		playerPane5.setDividerSize(1);
		playerPane5.setEnabled(false);
		
		//Combine Player1,2,3,4,5,6,7 pane with Player 8
		JSplitPane playerPane6 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,playerPane5,player8);
		playerPane6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		playerPane6.setSize(800, 100);
		playerPane6.setDividerLocation(.875);
		playerPane6.setDividerSize(1);
		playerPane6.setEnabled(false);
		
		//Status panel
			//Top row displays Game status, Server IP, Players left alive in JLabel
			//Bottom row displays Player number, Position, Last player action in JLabel
		JPanel gameStats = new JPanel(new BorderLayout());
		JLabel statusLabel = new JLabel("<html><b>STATUS</b></html>");
		JLabel gameStatusLabel = new JLabel("<html>" + "<b>&nbsp;&nbsp;&nbsp;GAME STATUS: </b>" 
				+ " Game: IN PROGRESS | Server: 192.168.142.42 | Players Remaining: 5"+"</html>");
		JLabel playerStatusLabel = new JLabel("<html>" + "<b>&nbsp;&nbsp;&nbsp;PLAYER STATUS: </b>"
				+ "Player #: 4 | Position: (42,42) | Last Action: Move"+ "</html>");
		
		//Combine Status labels to complete Status Panel
		gameStats.add(gameStatusLabel, BorderLayout.NORTH);
		gameStats.add(playerStatusLabel, BorderLayout.SOUTH);
		JSplitPane statusPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, statusLabel, gameStats);
		statusPane.setSize(800,50);
		statusPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		statusPane.setDividerLocation(.08);
		statusPane.setDividerSize(5);
		statusPane.setEnabled(false);
		
		//Combine Status Panel with Player Panel
		JSplitPane playersPlusStatus = new JSplitPane(JSplitPane.VERTICAL_SPLIT, statusPane, playerPane6);
		playersPlusStatus.setSize(800,150);
		playersPlusStatus.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		playersPlusStatus.setDividerLocation(50);
		playersPlusStatus.setDividerSize(1);
		playersPlusStatus.setEnabled(false);
		
		//Adding the game display to the combined player JSplitPanels
		JSplitPane displayPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,gameDisplay,playersPlusStatus);
		displayPane.setDividerLocation(400);
		displayPane.setDividerSize(1);
		displayPane.setEnabled(false);
		
		@SuppressWarnings("unused")
		class PlayerMouseListener implements MouseListener, MouseMotionListener{
			public void mouseClicked(MouseEvent e){
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		
		//add the combined game panels to the Game Frame for display.
		this.add(displayPane);
		
		
	}//end of createComponents
}//end of class
