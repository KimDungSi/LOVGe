import java.awt.geom.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import entity.*;

public class FrameX extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpaceShip ship = new SpaceShip();
	private int numberOfBalls = 0;
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
		
//		Declare variable
		add(ship);
		ship.configure(490, 400, 15, 15);
		
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
	        	Thread thread = new Thread() {
					public void run() {
						if(numberOfBalls < 3) {
							numberOfBalls++;
							Ball ball = new Ball("", 0);
							Point point = ship.getLocation();
							ball.configure(point.x, point.y, 10, 10);
				    		add(ball);
				    		ball.move();
				    		numberOfBalls--;
						}
					}
				};
				thread.start();
	        }
	        
	        if (e.getKeyCode() == 37) {
	        	ship.move(-1);
	        }
	        
	        if (e.getKeyCode() == 39) {
	        	ship.move(1);
	        }
	        
	    }
		
		public static void main(String[] ilu) {
			new FrameX();
		}
}
