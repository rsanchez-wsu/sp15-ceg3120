package team2;
/*
* Copyright (C) <2015> <Team 2>
*
* Will Hatfield
* Kevin Alig
* Alyssa Ramsey
* Anthony Lamping
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*
*/


import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author william
 */
public class PlayerList extends JList {
    private DefaultListModel<Player> playerList;
    
    public PlayerList() {
        playerList = new DefaultListModel();
    }
    
    public void initializePanel() {
        this.setModel(playerList);
    }
    
    
    public void addPlayer() {
        playerList.addElement(new Player());
    }
}

