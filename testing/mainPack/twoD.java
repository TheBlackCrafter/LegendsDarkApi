package mainPack;

import gui.LBufferedImage;
import gui.LFrame;
import java.awt.Color;
import java.util.Timer;
import javax.swing.JPanel;

import utily.LFunc;

@SuppressWarnings("serial")
public class twoD extends JPanel{

	static LFrame frame;
	static LBufferedImage canvas = new LBufferedImage(1280, 720);
	static Integer[] j = new Integer[100];
	static Timer timer = new Timer();
	
	public static void main(String[] args) {
		frame = new LFrame();
		frame.setTitel("lala");
		frame.setSize(1280, 720);
		frame.setResizable(false);
		
		frame.add(canvas);
		canvas.fillCanvas(Color.red);
	
		canvas.fillCanvas(Color.red);
		
		canvas.drawRect(Color.blue, 100, 100, 50, 50);
		canvas.drawRect(Color.black, 100, 100, 5, 5);
		
		canvas.drawCircle(Color.blue, 300, 300, 100);
		canvas.drawRect(Color.red, 300, 300, 1, 1);
		
		canvas.drawLine(Color.black, 0 , 0 , 10 , 12);

		
		
		while(true){
			canvas.fillCanvas(Color.WHITE);
			canvas.drawLine(Color.black, 0 , 0 , (int) frame.get().getMousePosition().getX() , (int)frame.get().getMousePosition().getY());
			LFunc.Sleep(1);
		}
	}

}
