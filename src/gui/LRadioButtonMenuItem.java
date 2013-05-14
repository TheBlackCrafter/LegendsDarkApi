package gui;

import java.awt.Color;

import javax.swing.JRadioButtonMenuItem;

public class LRadioButtonMenuItem {

	private JRadioButtonMenuItem comp;
	
	public LRadioButtonMenuItem(String s) {
		comp = new JRadioButtonMenuItem();
		comp.setVisible(true);
		this.setText(s);
	}
	
	public void setText(String s){
		comp.setText(s);
	}
	
	public JRadioButtonMenuItem get() {
		return comp;
	}
	
	public void setState(boolean b){
		comp.setSelected(b);
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