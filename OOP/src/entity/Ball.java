package entity;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Random;

public class Ball extends JLabel{
	private Point vitri = new Point();
	private Point chieu = new Point(0, -1);
	
	public Ball() {
		super();
	}
	public Ball(String str) {
		super(str);
	}
	public Ball(String str, int id) {
		super(str);
		Random rd = new Random();
		int ranNum = rd.nextInt(11);
		chieu.x = ranNum - 5;
	}
	
	public void configure(int x, int y, int width, int height) {
		vitri.x = x;
		vitri.y = y;
		
		setLocation(vitri);
		setSize(width, height);
		setVisible(true);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/data/Capture.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    ImageIcon icon = new ImageIcon(image.getScaledInstance(10, 10, Image.SCALE_SMOOTH));
	    
	    setIcon(icon);
	}
	
	public void move() {
		vitri = getLocation();
	    while(vitri.y > -10) {
	    	vitri.x += chieu.x;
	    	vitri.y += chieu.y;
	    	setLocation(vitri);
	    	if(vitri.x > 675 || vitri.x < 300)
	    		chieu.x = -chieu.x;
	    	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
}
