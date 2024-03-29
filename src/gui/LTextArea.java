package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class LTextArea {

	private JTextArea comp;
	private GridBagConstraints plc;
	private JScrollPane scroll;
	private boolean useScrollPane = false;
	
	public LTextArea() {
		comp = new JTextArea();
		comp.setVisible(true);
	}
	
	public void setText(String s){
		comp.setText(s);
	}
	
	public void setSize(int x, int y){
		comp.setPreferredSize(new Dimension(x,y));
		comp.setSize(x,y);
	}
	
	public JTextArea get() {
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
	
	public String getText(){
		return comp.getText();
	}
	
	public void addString(String s){
		this.setText(this.getText()+"\n"+s);
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
	
	public void useScrollPane(boolean b){
		this.useScrollPane = b;
		scroll = new JScrollPane(comp);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	}
	
	public boolean useScrollPane(){
		return useScrollPane;
	}
	
	public JScrollPane getScroll(){
		return scroll;
	}
}
