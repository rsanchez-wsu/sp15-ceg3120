package team7;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

public class PlayerTableFrame extends JFrame
{
	public PlayerTableFrame(ArrayList<Player> list)
	{
		TableModel model = new PlayerTableModel(list);
		JTable table = new JTable(model);
		add(new JScrollPane(table));
		pack();
	}
}

class PlayerTableModel extends AbstractTableModel
{
	private ArrayList<Player> players = new ArrayList();
	private String[] columns = {"Player", "Health", "Position", "Status"};
	
	public PlayerTableModel(ArrayList<Player> players)
	{
		this.players = players;
	}
	
	@Override
	public String getColumnName(int columnIndex)
	{
		return columns[columnIndex];
	}

	@Override
	public int getRowCount()
	{
		return players.size();
	}

	@Override
	public int getColumnCount()
	{
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Player player = players.get(rowIndex);
		switch (columnIndex)
		{
			case 0:
				return player.getName();
			case 1:
				String max = Integer.toString(player.getMaxHealth());
				String actual = Integer.toString(player.getMaxHealth() - player.getDmgTaken());
				return actual + "/" + max;
			case 2:
				return Integer.toString(player.getPosX()) + ", " + Integer.toString(player.getPosY());
			case 3:
				switch(player.getState())
				{
					case 0:
						return "Active";
					case 1:
						return "Waiting";
					case 3:
						return "Dead";
				}
		}
		return null;
	}
}