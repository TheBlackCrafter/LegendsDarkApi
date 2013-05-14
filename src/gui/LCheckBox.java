package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;

public class LCheckBox {

	private JCheckBox comp;
	private GridBagConstraints plc;
	
	public LCheckBox() {
		comp = new JCheckBox();
		comp.setVisible(true);
	}

	public void setText(String s){
		comp.setText(s);
	}
	
	public void setSize(int x, int y){
		comp.setPreferredSize(new Dimension(x,y));
		comp.setSize(x,y);
	}
	
	public JCheckBox get() {
		return comp;
	}
	
	public GridBagConstraints getPlc(){
		return plc;
	}
	
	public void setPlace(int x, int y){
		plc = new GridBagConstraints();
		plc.insets = new Insets(1, 1, 1, 1);
		plc.gridx = x;
		plc.gridy = y;
		plc.anchor = GridBagConstraints.NORTHWEST;
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
	
	public void setGridSize(int x, int y){
		plc.gridwidth = x;
		plc.gridheight = y;
	}
}
