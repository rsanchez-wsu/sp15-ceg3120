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
		// super(new BorderLayout());
		int playerIndex = 0;
		final JPanel statusBar = new JPanel();
		JLabel statusLabel = new JLabel("Status");
		statusBar.add(statusLabel);

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
		JScrollPane listScrollPane = new JScrollPane(list);

		list.ensureIndexIsVisible(playerIndex);
		add(statusBar, BorderLayout.WEST);
		add(listScrollPane, BorderLayout.EAST);
	}

}
