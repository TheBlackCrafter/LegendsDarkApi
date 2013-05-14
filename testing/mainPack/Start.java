package mainPack;

import fileHandling.LConfigFile;
import gui.LFrame;
import gui.LMenu;
import gui.LMenuBar;
import gui.LMenuItem;
import gui.LPicture;
import gui.LTextField;

import java.io.File;
public class Start
{

	static LFrame f1;
	
	static LMenuBar menuBar = new LMenuBar();
	static LMenu menu1 = new LMenu("menu1");
	static LMenu menu2 = new LMenu("menu2");
	static LMenuItem menuItem1 = new LMenuItem("1");
	static LMenuItem menuItem2 = new LMenuItem("2");
	static LMenuItem menuItem3 = new LMenuItem("3");
	static LMenuItem menuItem4 = new LMenuItem("4");
	static LMenuItem menuItem5 = new LMenuItem("5");
	static LMenuItem menuItem6 = new LMenuItem("6");
	
	static LTextField textfield = new LTextField();
	static LPicture pic;
	
	static LConfigFile config = new LConfigFile(new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Config.ini"), "MyProgram");
	
	static int code;
	
	public static void main(String[] args){
		f1 = new LFrame();
		f1.setTitel("Hellowe");
		f1.setSize(600, 600);
		
		f1.addJMenuBar(menuBar);
		menuBar.addMenu(menu1);		menu1.setText("ding 1");
		menuBar.addMenu(menu2);		menu2.setText("ding 2");
		menu1.addMenuItem(menuItem1);
		menu1.addMenuItem(menuItem2);
		menu1.addMenuItem(menuItem3);
		menu2.addMenuItem(menuItem4);
		menu2.addMenuItem(menuItem5);
		menu2.addMenuItem(menuItem6);
		
		f1.add(textfield);
		textfield.setSize(200,50);
		
		pic = new LPicture("src/Untitled.png");
		pic.setPlace(1, 1);
		pic.setSize(50,50);
		f1.add(pic);
		
		config.addVar("sijmen", "16", "dit is mijn leeftijd!");
		config.addVar("Henk", "60", "dit is de leeftijd van Henk");
		config.addVar("Fieke", "14", "dit is de leeftijd van fieke");
		config.addVar("Anja", "55", "de leeftijd van anja");
		
		if(!config.exists()){
			config.create();
		}
		
		System.out.println(config.open("Anja"));
		
		
	}
	
	
}




