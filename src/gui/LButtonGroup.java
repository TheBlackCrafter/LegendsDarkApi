package gui;

import javax.swing.ButtonGroup;

public class LButtonGroup {

	private ButtonGroup comp;
	
	public LButtonGroup() {
		comp = new ButtonGroup();
	}
	
	public ButtonGroup get() {
		return comp;
	}
	
	public void add(LRadioButton b){
		comp.add(b.get());
	}
	
	public void add(LRadioButtonMenuItem b){
		comp.add(b.get());
	}
}
