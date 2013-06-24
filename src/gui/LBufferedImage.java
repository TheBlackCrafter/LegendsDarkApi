package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class LBufferedImage extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage canvas;

    public LBufferedImage(int width, int height) {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public BufferedImage get(){
    	return canvas;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }

    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    private void drawRect_(Color c, int x1, int y1, int width, int height) {
        int color = c.getRGB();
        for (int x = x1; x < x1 + width; x++) {
            for (int y = y1; y < y1 + height; y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    public void drawRect(Color c, int x, int y, int width, int height){
    	drawRect_(c, x-height/2, y-width/2, width/2, height/2 );
    	drawRect_(c, x, y-width/2, width/2, height/2 );
    	drawRect_(c, x-height/2, y, width/2, height/2 );
    	drawRect_(c, x, y, width/2, height/2 );
    }
    
    public void drawCircle(Color c, int ox, int oy, int r){
    	int color = c.getRGB();
    	for (double x = -r; x < r ; x++){
    	    double height = Math.sqrt(r * r - x * x);
    	    for (double y = -height; y < height; y++){
				canvas.setRGB((int)Math.round(x + ox), (int)Math.round(y + oy), color);
    	    }
    	}
    	repaint();
    }

	public void drawLine(Color c, int x1, int y1, int x2, int y2) {
		int color = c.getRGB();
		int DX,DY;
		
		if(x1 < x2){
			DX = x2 - x1;
		}else{
			DX = x1 - x2;
		}
		
		if(y1 < y2){
			DY = y2 - y1;
		}else{
			DY = y1 - y2;
		}
		
		
		int a = 2*DY;
		int b = a - 2*DX;
		int p = a - DX;
		
		int x3 = x1, y3 = y1;
		while(x2 != x3 && y2 != y3){
			if(p < 0){
				x3++;
				canvas.setRGB(x3, y3, color);
				p = p + a;
			}
			else if(p > 0){
				x3++;
				y3++;
				canvas.setRGB(x3, y3, color);
				p = p + b;
			}
		}
		repaint();
	}
}
	
