package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LPicture {

	private ImageIcon pic;
	private JLabel comp;
	private GridBagConstraints plc;
	
	public LPicture(String path) {
		pic = new ImageIcon(path);
		comp = new JLabel(pic);
		comp.setVisible(true);
	}

	public void setText(String s){
		comp.setText(s);
	}
	
	public void setSize(int x, int y){
		comp.setPreferredSize(new Dimension(x,y));
		comp.setSize(x,y);
	}
	
	public JLabel get() {
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

	public ImageIcon getPic() {
		return pic;
	}

	public void setPic(ImageIcon pic) {
		this.pic = pic;
	}
}
