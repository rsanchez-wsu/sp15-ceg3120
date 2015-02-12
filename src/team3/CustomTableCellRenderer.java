package team3;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer{

	JLabel lbl = new JLabel();
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		ImageIcon icon = null;
		
		//this will be for the forest, we are using the hill tile as a placeholder until we get a forest tile made
		if(value == (Object)'#') {
			icon = new ImageIcon(getClass().getResource("/team3/hill.png"));
			lbl.setIcon(icon);
		}//end of if
		
		
		else if(value == (Object)'=') {
			icon = new ImageIcon(getClass().getResource("/team3/lake.png"));
			lbl.setIcon(icon);
		}//end of if
		else if(value == (Object)'^') {
			icon = new ImageIcon(getClass().getResource("/team3/mountain.png"));
			lbl.setIcon(icon);
		}//end of if
		else if(value == (Object)' '){
			icon = new ImageIcon(getClass().getResource("/team3/plains.png"));
			lbl.setIcon(icon);
		}//end of if
		else if(value == (Object)'U') {
			icon = new ImageIcon(getClass().getResource("/team3/hill.png"));
			lbl.setIcon(icon);
		}
		else {
			cell.setForeground(Color.YELLOW);
			cell.setBackground(Color.PINK);
			return cell;
		}//end of else
		return lbl;
		
	}
}
