package team3;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lbl = new JLabel();
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		ImageIcon icon = null;
		
		//forest
		if(value == (Object)0) {
			icon = new ImageIcon(getClass().getResource("/team3/forest.png"));
			lbl.setIcon(icon);
		}//end of if
		
		//lake
		else if(value == (Object)3) {
			icon = new ImageIcon(getClass().getResource("/team3/lake.png"));
			lbl.setIcon(icon);
		}//end of if
		
		//mountain
		else if(value == (Object)2) {
			icon = new ImageIcon(getClass().getResource("/team3/mountain2.png"));
			lbl.setIcon(icon);
		}//end of if
		
		//plains
		else if(value == (Object)4){
			icon = new ImageIcon(getClass().getResource("/team3/plains.png"));
			lbl.setIcon(icon);
		}//end of if
		
		//hill
		else if(value == (Object)1) {
			icon = new ImageIcon(getClass().getResource("/team3/hill.png"));
			lbl.setIcon(icon);
		}
		
		//tanks
		else {
			icon = new ImageIcon(getClass().getResource("/team3/tank" + value.toString() + ".png"));
			lbl.setIcon(icon);
		}//end of else
		return lbl;
		
	}
}
