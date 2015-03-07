
/*
 *  Copyright (C) <2015>  <Brandon Head, Matthew Hemker, Hien Long, Maxwell Nukpor>
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

package team8;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


/**
 * This is a List Entry Cell Renderer class that does the rendering for the JList.
 * The Purpose of this class is to act as a custom cell renderer for the JList.
 */
public class ListEntryCellRenderer extends JLabel implements ListCellRenderer {
	private JLabel label;

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		ListEntry entry = (ListEntry) value;

		setText(value.toString());
		setIcon(entry.getIcon());

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);

		return this;
	}
}
