import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameScreen {

	private JFrame frame = new JFrame("mull");
	
	public void setFrame() {
//		Default format
		frame.setSize(1024, 512);
		frame.setTitle("Chao mung den voi con game dan don");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
//		
//		Default operator
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	GameScreen() {
		setFrame();
        JLabel label = new JLabel();
        label.setLayout(null);
        frame.add(label);
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Capture.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ImageIcon icon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        label.setIcon(icon);
        int x = 0, y = 0;
        while(x < 500) {
        	label.setLocation(x, y);
        	x += 20;
        	try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        
	}
	
	public static void main(String[] ilu) {
		new GameScreen();
	}
	
	
}
