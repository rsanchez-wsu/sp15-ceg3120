package team5.Client;

/*
 * License tbd
 * @author hitchens6
 */

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

import team5.PlayerObject.Player;

public class ClientJList extends JPanel {
	/**
	 * ClientJList Variables
	 */
	private static final long serialVersionUID = 1L;
	private JList<Player> list;
	private DefaultListModel<Player> listModel;

	/**
	 * Default Constructor
	 */
	
	public ClientJList() {

	}

	/**
	 * Status Bar Constructor
	 */
	public ClientJList(Vector<Player> playerList, Player actualPlayer) {
		// ClientJList Variables
		JScrollPane statusBarScrollPane;
		int playerIndex = 0;
		final JTextField statusBarTextField;
		
		// Create Status Bar TextField
		statusBarTextField = new JTextField();
		statusBarTextField.setText("Status");
		statusBarTextField.setEditable(false);

		// Create and initialize listModel 
		listModel = new DefaultListModel<Player>();
		for (Player player : playerList) {
			listModel.addElement(player);
			if (actualPlayer == player) {
				playerIndex = listModel.indexOf(actualPlayer);
			}
		}

		// Create the list and put it in a scroll pane.
		list = new JList<Player>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(1);
		list.ensureIndexIsVisible(playerIndex);
	    statusBarScrollPane = new JScrollPane(list);
	    list.ensureIndexIsVisible(playerIndex);
	    
	    // Add statusBar and ListScrollPane to 
		add(statusBarTextField, BorderLayout.WEST);
		add(statusBarScrollPane, BorderLayout.EAST);
	}

}
