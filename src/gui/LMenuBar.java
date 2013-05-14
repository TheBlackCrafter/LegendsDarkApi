package gui;

import java.awt.Color;

import javax.swing.JMenuBar;

public class LMenuBar {

	private JMenuBar comp;
	
	public LMenuBar() {
		comp = new JMenuBar();
		comp.setVisible(true);
	}
	
	public JMenuBar get() {
		return comp;
	}
	
	public void addMenu(LMenu m){
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
