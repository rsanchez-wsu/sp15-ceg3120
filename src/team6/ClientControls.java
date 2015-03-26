package team6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ClientControls extends JPanel{

	private JPanel panel;
	private int xOffset=0;
	private int yOffset=0;
	private boolean attack=false;
	ActionListener press = new CommandAction();
	
	public ClientControls() {
		super();
	
		panel = new JPanel();	
		panel.setLayout(new GridLayout(3, 3));
		
		panel.add(new offsetButton("\\",-1,1));
		panel.add(new offsetButton("|",0,1));
		panel.add(new offsetButton("/",-1,1));
		panel.add(new offsetButton("<-",-1,0));
		panel.add(new offsetButton(":D",0,0));
		panel.add(new offsetButton("->",1,0));
		panel.add(new offsetButton("/",-1,-1));
		panel.add(new offsetButton("|",0,1));
		panel.add(new offsetButton("\\",1,-1));
		this.add(panel);
		
	}	
	
	
	
	private class offsetButton extends JButton{
		private int xOffset;
		private int yOffset;		
		private offsetButton(String text,int x, int y){
		super(text);
		xOffset=x;
		yOffset=y;	
		}
		
	}
	
	private class CommandAction implements ActionListener
{
public void actionPerformed(ActionEvent event)
{

	
}
}
	
	
	
	
}
