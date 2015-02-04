/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 *  Copyright (C) <2015>  <Team 6>
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

package team6;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ServerTankObjectGUI extends JPanel {

    public ServerTankObjectGUI() {
        super(new GridLayout(1, 0));

        String[] columnNames = {"Tank Image", "Name", "IP",
            "x coord", "y coord", "Health", "Score"};

        TankObject tank1 = new TankObject("green.jpg", "Matt", "178.224.102.99",
                12, 34, 40, 45, "wait");
        TankObject tank2 = new TankObject("green.jpg", "Jeff", "211.87.23.81",
                44, 12, 10, 55, "wait");
        TankObject tank3 = new TankObject("green.jpg", "Gary", "73.23.144.17",
                55, 86, 20, 74, "wait");
        TankObject tank4 = new TankObject("green.jpg", "Stu", "141.55.12.201",
                33, 12, 0, 102, "dead");
        TankObject tank5 = new TankObject("green.jpg", "Jill", "51.122.77.2",
                78, 47, 15, 82, "wait");
        TankObject tank6 = new TankObject("green.jpg", "Kent", "134.11.3.210",
                74, 22, 35, 102, "wait");
        TankObject tank7 = new TankObject("green.jpg", "Scot", "178.224.102.99",
                74, 22, 60, 10, "wait");
        TankObject tank8 = new TankObject("red.jpg", "xXKi113R69Xx", "192.168.1.1",
                99, 99, 65535, 65535, "Active");

        Object[][] data = {tank1.toStringArray(), tank2.toStringArray(),
            tank3.toStringArray(), tank4.toStringArray(), tank5.toStringArray(),
            tank6.toStringArray(), tank7.toStringArray(), tank8.toStringArray()};

        JTable table = new JTable(data, columnNames);

        table.setPreferredScrollableViewportSize(new Dimension(800, 180));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}

