package GameElements;

import lib.Point;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;

public class ILU extends Entity {
	
	public ILU(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width, heigh);
		this.vector = vector;
	}
	
	private Point vector = new Point();
	
	public Point getVector() {
		return vector;
	}
	
	public void move(SpaceShip spaceShip, AnchorPane pane) {
		pane.getChildren().add(this.getImageView());
		Point position = this.getPosition();
		
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				
				position.add(vector);
				setPosition(position);
				
				if (position.getY() > 700 || position.getY() < 0) {
					pane.getChildren().remove(getImageView());
					this.stop();// stop animationTimer
				}
				else if (hasVaCham(spaceShip)) {
					System.out.println("BOOM");
					pane.getChildren().remove(getImageView());
					attack(spaceShip, pane);
					this.stop();
				}
				effect();
			}
		};
		timer.start();
	}
	public void attack(SpaceShip spaceShip, AnchorPane pane) {}
	public void init(SpaceShip spaceShip) {}
	public void effect() {}
}
