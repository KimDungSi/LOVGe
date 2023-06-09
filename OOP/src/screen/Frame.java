package screen;

import java.awt.geom.*;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
	public Frame() {
		setLayout(new FlowLayout());
		
//		Default format
		setSize(1024, 512);
		setTitle("Chao mung den voi con game dan don");
		setLocationRelativeTo(null);
		
//		Default operator
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	   public void paint(Graphics gp) { 
		   super.paint(gp); 
		   Graphics2D graphics = (Graphics2D) gp;
		   Line2D line = new Line2D.Float(300, 0, 300, 500);
		   graphics.draw(line);
		   line = new Line2D.Float(700, 0, 700, 500);
		   graphics.draw(line);
	   }
}
