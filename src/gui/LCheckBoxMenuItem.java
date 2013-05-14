package gui;

import java.awt.Color;

import javax.swing.JCheckBoxMenuItem;

public class LCheckBoxMenuItem {

	private JCheckBoxMenuItem comp;
	
	public LCheckBoxMenuItem(String s) {
		comp = new JCheckBoxMenuItem();
		comp.setVisible(true);
		this.setText(s);
	}
	
	public void setText(String s){
		comp.setText(s);
	}
	
	public JCheckBoxMenuItem get() {
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