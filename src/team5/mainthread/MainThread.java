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
package team5.mainthread;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import team5.client.ClientBoardTable;
import team5.client.ClientStatusTable;
import team5.client.GameStatus;
import team5.client.socket.SocketClient;
import team5.playerobject.EnemyPlayer;
import team5.playerobject.Pair;
import team5.playerobject.Player;

/**
 * @author Joshua Hitchens, Lori Simmons, Ryan Lane, Tyler Parker
 */
public class MainThread implements Runnable{

	Vector<Player> playerList = new Vector<Player>();
	JTextArea chat;
	JTextField chatTxt;
	int isConnected = 0;
	SocketClient connection;
	
	/**
	 * Runs Main Thread
	 */
	public void run() {
		// Run Variables
		Player actualPlayer;
		JPanel gameBoard;
		JFrame frame;
		JPanel gamePanel;
		JPanel statusPanel;
		JPanel chatPanel;
		JLabel status;
		JLabel info;
		JSplitPane statusArea;
		JSplitPane parentPane;
		JSplitPane chatSplitPane;
		JSplitPane gameBoardSplitPane;
		ClientStatusTable playerTable;
		ClientBoardTable boardTable;
		GameStatus gameStatus;
	    GameStatus.StatusEnum actualStatus; 
		
		// Method to create dummy players
		initializePlayers();
		
	
		actualStatus = GameStatus.StatusEnum.IN_PROGRESS;
		gameStatus = new GameStatus("1.1.1.1", 3,  actualStatus);

		// Get the client player
		actualPlayer = playerList.get(0);

		boardTable = new ClientBoardTable(playerList, actualPlayer);
		
		//create the chat panel
		chatPanel = new JPanel();
		chat = new JTextArea();
		chat.setEditable(false);
		chat.setWrapStyleWord(true);
		chat.setLineWrap(true);
		
		chatTxt = new JTextField();
	    chatTxt.setText("");
	    chatTxt.setSize(100, 100);
	
		chatTxt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String temp;
				temp = chat.getText();
				temp =  temp + System.lineSeparator() + chatTxt.getText();
				chat.setText(temp);		
				chatTxt.setText("");
			}
			
		});
		
		JScrollPane scroll = new JScrollPane (chat);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		chatSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		chatSplitPane.add(scroll, JSplitPane.TOP);
		chatSplitPane.add(chatTxt, JSplitPane.BOTTOM);
		chatSplitPane.setDividerLocation(350);
		
		chatPanel = new JPanel();
		chatPanel.add(chatSplitPane);
		
		// Create the gameBoard Panel 
		gameBoard = new JPanel();
		gameBoardSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		gameBoard.setLayout(new GridLayout(1,0));
		
		gameBoardSplitPane.add(boardTable, JSplitPane.RIGHT);
		gameBoardSplitPane.add(chatSplitPane, JSplitPane.LEFT);
		gameBoardSplitPane.setDividerLocation(300);
		
		// Create JList for Status Implementation
		gamePanel = new JPanel();
		gamePanel.setOpaque(true);
		gamePanel.setLayout(new GridLayout(1,0));
		
		statusPanel = new JPanel();
		statusPanel.setLayout(new GridLayout(1,0));
		
		status = new JLabel();
		status.setText("Status");
		status.setHorizontalAlignment(JLabel.CENTER);
		
		info = new JLabel();
		info.setText(gameStatus.toString() +  " " +  actualPlayer.toString());
		info.setHorizontalAlignment(JLabel.CENTER);
		
		playerTable = new ClientStatusTable(playerList, actualPlayer);
	
		gamePanel.add(gameBoardSplitPane);
		
		statusPanel.add(status, BorderLayout.WEST);
		statusPanel.add(info, BorderLayout.EAST);
		
		statusArea = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		statusArea.add(statusPanel, JSplitPane.TOP);
		statusArea.add(playerTable, JSplitPane.BOTTOM);
		
		parentPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		parentPane.add(gamePanel, JSplitPane.TOP);
		parentPane.add(statusArea, JSplitPane.BOTTOM);
		parentPane.setDividerLocation(550);
		
		// Add Objects to Frame, Frame properties and open Frame.
		frame = new JFrame("ClientJList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(1,0));
		frame.setTitle("Turn Tanks");
		frame.add(parentPane);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		
//		connection = new SocketClient();
//		//connect to chat thing
//		
//		while(!connection.didConnectionEstablish()){
//			if(isConnected<8){
//				System.out.println("Attempting try number: " + isConnected);
//				connection.run("127.0.0.1", 8080);
//			}
//			if(isConnected==8){
//				System.out.println("Connection to server timmed out after 8 trys");
//				break;
//			}
//			isConnected++;
//			connection = new SocketClient();
//		}
//		while(connection.isConnectionTerminated()){
//			
//		}
	}
	
	/**
	 * creates players
	 */
	protected void initializePlayers() {
		int x = 6;
		int y = 7;
		Player.State state = Player.State.WAITING;
		Pair position = new Pair(x, y);
		Player player = new Player( 0, 25, position, state);
		playerList.addElement(player);
		
		x = 5;
		y = 5;
		position = new Pair(x, y);
		state = Player.State.ALIVE;
		player = new EnemyPlayer(1, 20, null, state);
		playerList.addElement(player);
		
		x = 15;
		y = 15;
		state = Player.State.WAITING;
		position = new Pair(x,y);
		player = new EnemyPlayer(2, 50, position, state);
		playerList.addElement(player);
		
		x = 11;
		y = 41;
		state = Player.State.DEAD;
		position = new Pair(x, y);
		player = new EnemyPlayer(3, 0, null, state);
		playerList.addElement(player);
		
		x = 15;
		y = 15;
		state = Player.State.WAITING;
		position = new Pair(x, y);
		player = new EnemyPlayer(4, 50, position, state);
		
		playerList.addElement(player);
		x = 11;
		y = 41;
		state = Player.State.DEAD;
		position = new Pair(x, y);
		player = new EnemyPlayer(5, 0, position, state);
		playerList.addElement(player);
		
		x = 30;
		y = 15;
		state = Player.State.WAITING;
		position = new Pair(x, y);
		player = new EnemyPlayer(6, 50, position, state);
		playerList.addElement(player);
		
		x = 40;
		y = 15;
		state = Player.State.WAITING;
		position = new Pair(x, y);
		player = new EnemyPlayer(7, 50, position, state);
		playerList.addElement(player);
	}

	// Creates and starts the main thread
	public static void main(String[] args) {
		(new MainThread()).run();
	}

}
