/*
 *  Copyright (C) <2015>  Marie Hucke, Kristen Schwaiger, Kyle Wintermute, Kyle Wood
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

package team1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class TurnTanks {
	
	// Create the frame
	private static void createClientWindow() {
		
		GameFrame tankFrame = new GameFrame();
		tankFrame.setTitle("TURN TANKS!!ONE!11!");
		tankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		tankFrame.setResizable(false);
		//frame.add(new TurnTanks());		
		//tankFrame.setSize(600, 600);
		//frame.pack();
		tankFrame.setVisible(true);
		
	}//end of constructor
	
	public class PlayerMouseListener implements MouseListener, MouseMotionListener{
		public void mouseClicked(MouseEvent e){
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	//run the frame
	public static void main(String args[]) {
		
		//ClientSocket socket = new ClientSocket();
		//socket.sendMessage("Hello World!");
		//System.out.print(socket.recMessage());
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createClientWindow();
			}
		});
		
		
	}//end of main
}//end of TurnTanks
