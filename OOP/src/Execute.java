import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import entity.Ball;
import screen.Frame;
public class Execute {
	private Frame frame = new Frame();
	private Ball ball[] = new Ball[10];
	private int id = 0;
	
	Execute() {
			ball[id] = new Ball(new Point(500, 400));
	    	frame.add(ball[id]);
	    	frame.setVisible(true);
	    	ball[id].move();
	    	id++;
	    	
	}
	
	public static void main(String[] ilu) {
		new Execute();
	}
}
