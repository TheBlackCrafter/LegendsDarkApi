package gui;

import java.awt.Color;

import javax.swing.JMenuItem;

public class LMenuItem {

	private JMenuItem comp;
	
	public LMenuItem(String s) {
		comp = new JMenuItem();
		comp.setVisible(true);
		this.setText(s);
	}
	
	public void setText(String s){
		comp.setText(s);
	}
	
	public JMenuItem get() {
		return comp;
	}
	
	public void setForground(Color c){
		comp.setForeground(c);
		comp.revalidate();
	}
	
	public void setBackground(Color c){
		comp.setBackground(c);
		comp.revalidate();
	}

}