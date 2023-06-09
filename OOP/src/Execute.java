import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import entity.Ball;
import screen.Frame;

public class Execute {
	private Frame frame = new Frame();
	private Ball ball[] = new Ball[10];
	private int id = 0;
	private JButton press = new JButton("press");
	
	public Execute() {
		press.setSize(30, 30);
		press.setLocation(500, 600);
		frame.add(press);
	    frame.setVisible(true);
	    
		press.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				Thread thread = new Thread() {
					public void run() {
						ball[id] = new Ball(new Point(500, 400));
						frame.add(ball[id]);
						ball[id].move();
						id++;
					}
				};
				thread.start();
			}
		});
	}
	
	public static void main(String[] ilu) {
		new Execute();
	}
}