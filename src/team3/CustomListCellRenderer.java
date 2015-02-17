package team3;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CustomListCellRenderer implements ListCellRenderer<Object>{
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
		JLabel lbl = new JLabel();
		if(index % 2 != 0) {
			int playerNum = ((index-1)/2) + 1;
			lbl.setIcon(new ImageIcon(getClass().getResource("/team3/tank" + Integer.toString(playerNum) + ".png")));
			lbl.setText("");
		}//end of if
		else {
			lbl.setText((String)value);
		}//end of else
		lbl.setForeground(Color.WHITE);
		return lbl;
	}//end of getListCellRendererComponent
}//end of CustomListCellRenderer
