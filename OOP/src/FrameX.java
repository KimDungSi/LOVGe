import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import entity.Ball;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrameX extends JFrame implements KeyListener {
	
	public FrameX() {
//		Default format
		setSize(1024, 512);
		setTitle("Chao mung den voi con game dan don");
		setLocationRelativeTo(null);
		
//		Default operator
		setLayout(null);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		this.addKeyListener(this);
	}
	
	   public void paint(Graphics gp) { 
		   super.paint(gp); 
		   Graphics2D graphics = (Graphics2D) gp;
		   Line2D line = new Line2D.Float(300, 0, 300, 500);
		   graphics.draw(line);
		   line = new Line2D.Float(700, 0, 700, 500);
		   graphics.draw(line);
	   }
	   
		@Override public void keyTyped(KeyEvent e) {}
		@Override public void keyReleased(KeyEvent e) {}
		@Override
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == 32) {
	        	System.out.println(1);
	        	Thread thread = new Thread() {
					public void run() {
			        	Ball ball = new Ball("o", 1);
			    		ball.setSize(9, 9);
			    		ball.setLocation(500, 400);
			    		ball.setVisible(true);
			    		add(ball);
			    		ball.move();
					}
				};
				thread.start();
	        }
	        
	        if (e.getKeyCode() != 0) {
	        	System.out.println(e.getKeyCode());
	        }
	        
	    }
		
		public static void main(String[] ilu) {
			new FrameX();
		}
}
