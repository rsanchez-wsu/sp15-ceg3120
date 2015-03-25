
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

import javax.swing.ImageIcon;


/**
 * This is a List entry class That binds a string to an icon.
 * The purpose of this class is to be able to associate the player's
 * attributes with their specific icon. Which in this case would be a tank
 */
public class ListEntry {
	private String value;
	private ImageIcon icon;

	public ListEntry(String value, ImageIcon icon) {
		this.value = value;
		this.icon = icon;
	}

	public String getValue() {
		return value;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public String toString() {
		return value;
	}
}