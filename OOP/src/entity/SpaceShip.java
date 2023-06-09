package entity;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SpaceShip extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point vitri = new Point();
	private Point chieu = new Point(5, 0);
	
	public SpaceShip() {
		super();
	}
	
	public void configure(int x, int y, int width, int height) {
		vitri.x = x;
		vitri.y = y;
		
		setLocation(vitri);
		setSize(width, height);
		setVisible(true);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("data/2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    ImageIcon icon = new ImageIcon(image.getScaledInstance(15, 15, Image.SCALE_SMOOTH));
	    
	    setIcon(icon);
	}
	
	public void move(int phuong) {
		vitri = getLocation();
		
	    for(int i = 1; i <= chieu.x; i++)
	    	if((vitri.x > 675 && phuong == 1) 
	    	|| (vitri.x < 300 && phuong == -1))
	    		return;
	    	else {
	    		vitri.x = vitri.x + phuong;
	    		setLocation(vitri);
		    	try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    	}
	}
}
