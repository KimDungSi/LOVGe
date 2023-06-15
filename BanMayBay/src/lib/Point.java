package lib;

import java.awt.geom.Point2D;

public class Point extends Point2D {
	private double x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		this(0, 0);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setLocation(Point point) {
		this.x = point.getX();
		this.y = point.getY();
	}
	
	public void add(Point point) {
		this.x += point.getX();
		this.y += point.getY();
	}
}
