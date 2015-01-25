package team5.Client;

/*
 * License tbd
 * @author hitchens6
 */

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

import team5.PlayerObject.Player;

/* ListDemo.java requires no other files. */
public class ClientJList extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Player> list;
	private DefaultListModel<Player> listModel;

	public ClientJList() {

	}

	public ClientJList(Vector<Player> playerList, Player actualPlayer) {
		JScrollPane listScrollPane;
		
		int playerIndex = 0;
		final JTextField statusBar = new JTextField();
		statusBar.setText("Status");
		statusBar.setEditable(false);

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
		// list.setSelectedIndex(playerIndex);
		list.setVisibleRowCount(1);
		list.ensureIndexIsVisible(playerIndex);
	    listScrollPane = new JScrollPane(list);

		list.ensureIndexIsVisible(playerIndex);
		add(statusBar, BorderLayout.WEST);
		add(listScrollPane, BorderLayout.EAST);
	}

}
