package gui;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LFrame {

	private JFrame frame;
	private JPanel panel;
	
	public LFrame() {
		frame = new JFrame();
		panel = new JPanel(new GridBagLayout());
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public JFrame get(){
		return frame;
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	public void setTitel(String s){
		frame.setTitle(s);
	}
	
	public void setSize(int x, int y){
		frame.setSize(x,y);
	}
	
	public void setVisable(boolean b){
		frame.setVisible(b);
	}
	
	public void add(LButton b){
		panel.add(b.get(), b.getPlc());
		frame.revalidate();
	}
	
	public void add(LTextField t){
		panel.add(t.get(), t.getPlc());
		frame.revalidate();
	}
	
	public void add(LTextArea t){
		panel.add(t.get(), t.getPlc());
		frame.revalidate();
	}
	
	public void add(LCheckBox t){
		panel.add(t.get(), t.getPlc());
		frame.revalidate();
	}
	
	public void add(LRadioButton t){
		panel.add(t.get(), t.getPlc());
		frame.revalidate();
	}
	
	public void add(LLabel t){
		panel.add(t.get(), t.getPlc());
		frame.revalidate();
	}
	
	public void revalidate(){
		panel.revalidate();
		frame.revalidate();
	}
	
	public void addJMenuBar(LMenuBar m){
		frame.setJMenuBar(m.get());
	}
	
	public void setForground(Color c){
		frame.setForeground(c);
		frame.revalidate();
	}
	
	public void setBackground(Color c){
		panel.setBackground(c);
		frame.revalidate();
	}

	public void add(LPicture t) {
		panel.add(t.get(), t.getPlc());
		frame.revalidate();
	}
}
