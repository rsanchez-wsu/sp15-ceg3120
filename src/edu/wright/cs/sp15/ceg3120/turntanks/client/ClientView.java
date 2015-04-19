/*
 *  Copyright (C) <2015>  
 *  Josh Crank - crank.5@wright.edu
 *  // Aditional People
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

package edu.wright.cs.sp15.ceg3120.turntanks.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import edu.wright.cs.sp15.ceg3120.turntanks.Player;

//(JTC) This is the client view, the main game panel.

public class ClientView extends JFrame {
	/**
	 * Random generated serial version UID
	 */
	private static final long serialVersionUID = -6763963976364615259L;

	// (JTC) Window Size
	private static final int DEFAULT_WIDTH = 1024;
	private static final int DEFAULT_HEIGHT = 768;
	private static PlayersView currentPlayersView;
	private static ClientView self = null;

	private String localName = null;
	private Map<String,Player> players;
	private String nextCmd = null;

	public ClientView() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		setTitle("Turn Tanks: Ultimate Destruction!!!!11!!111!ONE!1!!");

		// (kwood) When the program starts, Open a dialog to ask the player for
		// their name.
		localName = JOptionPane.showInputDialog(null,
				"Please enter your Player name", "Player Name",
				JOptionPane.PLAIN_MESSAGE);
		if (localName == null) {
			System.exit(0);
		}
		
		// Exit the program if the window is closed
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to close?", "Close?",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		
		GameRenderer test = new GameRenderer();
		test.setSize(new Dimension(2048, 2048));
		test.repaint();
		
		// (JTC) Setup map area and title
		final JLabel mapTitle = new JLabel("Game Map", SwingConstants.CENTER);
		final JScrollPane map = new JScrollPane(test, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		map.setMinimumSize(new Dimension(1024, 500));
		
		//(kwood) Map mouse listener
		map.addMouseListener(new MouseListener(){ 
			
			@Override			
			public void mouseClicked(MouseEvent e){
				Point p = new Point(e.getX()/32, e.getY()/32);
				
				//USED FOR DEBUGGING. REMOVE LATER
				System.out.println(p);
				if(players == null){}
				else{
					boolean playerClick = false;
					for(int i = 0; i < players.size(); i++){
						if(p == players.get(Integer.valueOf(i)).getPlayerLocation()){
							playerClick = true;
						}
					}
					
					if(p == players.get(localName).getPlayerLocation()){
						nextCmd = "ACTION PASS $ (" + p.getX() + ", " + p.getY() + ")";
					}
					else if(playerClick){
						nextCmd = "ACTION ATTACK $ (" + p.getX() + ", " + p.getY() + ")";
					}
					else{
						nextCmd = "ACTION MOVE $ (" + p.getX() + ", " + p.getY() + ")";
					}
				}				
			}

			//MouseClicked will be the only used MouseListener method. Others implemented to resolve errors.
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}			
		});

		// (JTC) Setup player status area
		final JLabel statusLabel = new JLabel("Status", SwingConstants.CENTER);
		statusLabel.setMinimumSize(new Dimension(65, 65));
		final JLabel status = new JLabel(
				"<html>&nbsp&nbsp&nbsp Game Info - Status: In Progress | Server: 10.229.154.17 | Players left: 6<br>"
						+ "&nbsp&nbsp&nbsp My Info - #: 6 | Health: 11/50 | Position: (60,25) | State: Wait");

		// (JTC) Set up icons for player buttons
		final ImageIcon tankIcon = new ImageIcon("tank.png", "Tank Icon");
		Image image = tankIcon.getImage();
		// image.getWidth(null)/2 ; image.getHeight(null)/2
		image = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		tankIcon.setImage(image);

		// (JTC) Set up player buttons
		// create button
		JButton p1 = null, p2 = null, p3 = null, p4 = null, p5 = null, p6 = null, p7 = null, p8 = null;
		//changed all players.get(int) to players.get(Integer.valueOf(int)) to remove warnings
		try{
			p1 = this.createPlayerButton(players.get(Integer.valueOf(0))); 
		} catch(NullPointerException e){
			p1 = this.createPlayerButton(new Player(0, "NO PLAYER"));
		}
		
		try{
			p2 = this.createPlayerButton(players.get(Integer.valueOf(1))); 
		} catch(NullPointerException e){
			p2 = this.createPlayerButton(new Player(0, "NO PLAYER"));
		}
		try{
			p3 = this.createPlayerButton(players.get(Integer.valueOf(2))); 
		} catch(NullPointerException e){
			p3 = this.createPlayerButton(new Player(0, "NO PLAYER"));
		}
		try{
			p4 = this.createPlayerButton(players.get(Integer.valueOf(3))); 
		} catch(NullPointerException e){
			p4 = this.createPlayerButton(new Player(0, "NO PLAYER"));
		}
		try{
			p5 = this.createPlayerButton(players.get(Integer.valueOf(4))); 
		} catch(NullPointerException e){
			p5 = this.createPlayerButton(new Player(0, "NO PLAYER"));
		}
		try{
			p6 = this.createPlayerButton(players.get(Integer.valueOf(5))); 
		} catch(NullPointerException e){
			p6 = this.createPlayerButton(new Player(0, "NO PLAYER"));
		}
		try{
			p7 = this.createPlayerButton(players.get(Integer.valueOf(6))); 
		} catch(NullPointerException e){
			p7 = this.createPlayerButton(new Player(0, "NO PLAYER"));
		}
		try{
			p8 = this.createPlayerButton(players.get(Integer.valueOf(7))); 
		} catch(NullPointerException e){
			p8 = this.createPlayerButton(new Player(0, "NO PLAYER"));
		}
		

		// (JTC) Create the panes for a nested JSplitPane
		// (JTC) Status Pane (label and player status)
		JSplitPane statusPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				statusLabel, status);
		statusPane.setDividerLocation(0.3);
		statusPane.setMinimumSize(new Dimension(1024, 65));
		statusPane.setEnabled(false);
		statusPane.setDividerSize(1);

		// (JTC) Map pane (map and title) ***Note this will likely contain a map
		// JPanel object of its own once gameBoard is implemented ***
		JSplitPane mapPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				mapTitle, map);
		mapPane.setEnabled(false);
		mapPane.setDividerSize(1);

		// (JTC) This is the pane that contains the status and map areas
		JSplitPane topPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mapPane,
				statusPane);
		// topPane.setDividerLocation(0.1);
		topPane.setBorder(null);
		topPane.setEnabled(false);
		topPane.setDividerSize(1);

		// (JTC) These are the panes that hold the player buttons in a single
		// horizontal line
		JSplitPane p1p2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		p1p2.setBorder(null);
		p1p2.setResizeWeight(0.5);
		p1p2.setEnabled(false);
		p1p2.setDividerSize(1);

		JSplitPane p3p4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p3, p4);
		p3p4.setBorder(null);
		p3p4.setResizeWeight(0.5);
		p3p4.setEnabled(false);
		p3p4.setDividerSize(1);

		JSplitPane p5p6 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p5, p6);
		p5p6.setBorder(null);
		p5p6.setResizeWeight(0.5);
		p5p6.setEnabled(false);
		p5p6.setDividerSize(1);

		JSplitPane p7p8 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p7, p8);
		p7p8.setBorder(null);
		p7p8.setResizeWeight(0.5);
		p7p8.setEnabled(false);
		p7p8.setDividerSize(1);

		JSplitPane p1p2p3p4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1p2,
				p3p4);
		p1p2p3p4.setBorder(null);
		p1p2p3p4.setResizeWeight(0.5);
		p1p2p3p4.setEnabled(false);
		p1p2p3p4.setDividerSize(1);

		JSplitPane p5p6p7p8 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p5p6,
				p7p8);
		p5p6p7p8.setBorder(null);
		p5p6p7p8.setResizeWeight(0.5);
		p5p6p7p8.setEnabled(false);
		p5p6p7p8.setDividerSize(1);

		JSplitPane allPlayers = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				p1p2p3p4, p5p6p7p8);
		allPlayers.setBorder(null);
		allPlayers.setResizeWeight(0.5);
		allPlayers.setEnabled(false);
		allPlayers.setDividerSize(1);

		// (JTC) This is the full view, bringing all panes nested together.
		JSplitPane fullView = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				topPane, allPlayers);
		fullView.setDividerLocation(0.2);
		fullView.setEnabled(false);
		fullView.setDividerSize(1);

		// (JTC) Add the JSplitPane to the layout
		add(fullView, BorderLayout.CENTER);

	}
	
	private JButton createPlayerButton(final Player player){
		JButton button = new JButton("<html>" + player.getName()
				+ "<br>Last Seen:<br>(never)</html>", new ImageIcon(player.getPlayerTankPic()));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		// (JTC) add button listener to open the player status panel for that
		// player. PlayersView takes
		// in "Player #" where # is the player number.
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentPlayersView == null) {//made player final to get rid of error on player.getPlayerNumber()
					PlayersView playersWindow = new PlayersView("Player " + player.getPlayerNumber(),
							self);
					currentPlayersView = playersWindow;
					playersWindow.setVisible(true);
					playersWindow.setResizable(false);
				} else {
					currentPlayersView.changeTab(0);
					currentPlayersView.toFront();
				}
			}
		});
		return button;
	}

	public static void removePlayersView() {
		currentPlayersView = null;
	}
	
	void setPlayers(Map<String,Player> playerList) {
		this.players = playerList;
	}
	
	public String getLocalName () {
		return this.localName;
	}
	
	public String getNextCmd(){
		return this.nextCmd;
	}
	
	public void clearCmd(){
		this.nextCmd = null;
	}
	
}
