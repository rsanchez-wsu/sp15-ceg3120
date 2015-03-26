package team6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ClientControls extends JPanel{

	private JPanel panel;
	private int xOffset=0;
	private int yOffset=0;
	private boolean attack=false;
	ActionListener press = new Press();
	
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
	public int getInputX(){	
		int temp=xOffset;
		xOffset=0;
		return temp;			
	}
	
	public int getInputY(){		
		int temp=yOffset;
		yOffset=0;
		return temp;		
		
	}
	
	
	
	private class offsetButton extends JButton{
		private int xOffset;
		private int yOffset;		
		private offsetButton(String text,int x, int y){
		super(text);
		xOffset=x+1;//makes parsing easier, -1 later in actionlistener
		yOffset=y+1;//makes parsing easier, -1 later in actionlistener
		this.addActionListener(press);
		}		
		
		@Override
		public String getActionCommand(){
			
			return String.valueOf(xOffset)+String.valueOf(yOffset);
		}
	}//end button class
	
	private class Press implements ActionListener
{
public void actionPerformed(ActionEvent event)
{

xOffset=Integer.parseInt(event.getActionCommand().substring(0, 1))-1;	
yOffset=Integer.parseInt(event.getActionCommand().substring(1, 2))-1;

}
}//end listener
	
	
	
	
}//end client control class
