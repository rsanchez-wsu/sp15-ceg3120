package team3;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CustomTableCellRenderer extends DefaultTableCellRenderer{

	JLabel lbl = new JLabel();
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		ImageIcon icon = null;
		
		if(value == (Object)'#') {
			icon = new ImageIcon(getClass().getResource("/team3/forest.png"));
			lbl.setIcon(icon);
		}//end of if
		else if(value == (Object)'=') {
			icon = new ImageIcon(getClass().getResource("/team3/lake.png"));
			lbl.setIcon(icon);
		}//end of if
		else if(value == (Object)'^') {
			icon = new ImageIcon(getClass().getResource("/team3/mountain2.png"));
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
			icon = new ImageIcon(getClass().getResource("/team3/tank.png"));
			lbl.setIcon(icon);
		}//end of else
		return lbl;
		
	}
}
