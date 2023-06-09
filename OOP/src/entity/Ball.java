package entity;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Ball extends JLabel{
	private Point vitri = new Point();
	private Point chieu = new Point(5, -1);
	
	public Ball(Point vitri){
		this.vitri = vitri;
		setLocation(vitri);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/data/Capture.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ImageIcon icon = new ImageIcon(image.getScaledInstance(10, 10, Image.SCALE_SMOOTH));
	    setIcon(icon);
	    setLayout(null);
	    setVisible(false);
	}
	
	public void move() {
		setVisible(true);
	    while(vitri.y > 0) {
	    	vitri.x += chieu.x;
	    	vitri.y += chieu.y;
	    	setLocation(vitri);
	    	if(vitri.x > 675 || vitri.x < 300)
	    		chieu.x = -chieu.x;
	    	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    setVisible(false);
	}
}
