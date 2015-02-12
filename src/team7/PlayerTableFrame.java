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



/*
 * DEPRICATED - No longer in use!!!
 */

/*
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
} */