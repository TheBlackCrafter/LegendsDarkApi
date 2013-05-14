package gui;

import java.awt.Color;

import javax.swing.JMenu;

public class LMenu {

	private JMenu comp;
	
	public LMenu(String s) {
		comp = new JMenu();
		comp.setVisible(true);
		this.setText(s);
	}
	
	public void setText(String s){
		comp.setText(s);
	}
	
	public JMenu get() {
		return comp;
	}

	public void addMenuItem(LMenuItem m){
		comp.add(m.get());
	}
	
	public void addMenuItem(LRadioButtonMenuItem m){
		comp.add(m.get());
	}
	
	public void addMenuItem(LCheckBoxMenuItem m){
		comp.add(m.get());
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