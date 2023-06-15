package GameElements;

import javafx.animation.AnimationTimer;
import lib.Point;
import javafx.scene.layout.AnchorPane;

public class BulletHero extends Bullet{
	
	public BulletHero(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width, heigh, vector);
	}
	public BulletHero() {
		this("/resourses/gamekit/spritesheets/bulletCircle.png",
			 20, 20, new Point(0, -10));
	}
	
	public void Shoot(SpaceShip spaceShip, AnchorPane pane) {
		Point position = new Point(65, 0);
		position.add(spaceShip.getPosition());
		this.setPosition(position);
		
		pane.getChildren().add(this.getImageView());
		
		AnimationTimer bulletTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				position.add(getVector());
				
				setPosition(position);
				
//				//kiem tra dan co ban trung hay khong...else(dong duoi)
				if (position.getY() < 0) {
					pane.getChildren().remove(getImageView());
					this.stop();// dung animationTimer lai
				}	
			}
		};
		bulletTimer.start();
	}
}
