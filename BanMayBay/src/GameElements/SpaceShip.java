package GameElements;

import lib.Point;
import javafx.scene.layout.AnchorPane;

public class SpaceShip extends Entity {
	
	public SpaceShip(String linkImage, float width, float heigh) {
		super(linkImage, width, heigh);
	}
	public SpaceShip() {
		this("/resourses/gamekit/spritesheets/ship/SpaceShip.png", 150, 150);
		setPosition(new Point(225, 600));
		bulletStore = 100;
	}
	
	private static final double STEP = 5;
	private double shipAngle;
	private int bulletStore;
	
	public void setBulletStore(int bulletCounter) {
		this.bulletStore = bulletCounter;
	}
	
	public int getBulletStore() {
		return this.bulletStore;
	}
	
	public void spaceShipMove(boolean isLeftKeyPressed, boolean isRightKeyPressed) {
		this.shipAngle = this.getImageView().getRotate();
		Point position = getPosition();
		
		if (isLeftKeyPressed && !isRightKeyPressed) {
			System.out.println("Movin' Left");
			
			if (position.getX() < 10) position.setLocation(0, position.getY());
			else position.setLocation(position.getX() - STEP, position.getY());
			
			setPosition(position);
			
			if (this.shipAngle > -10) this.shipAngle -= 10;
			getImageView().setRotate(this.shipAngle);
		}
		else if (!isLeftKeyPressed && isRightKeyPressed) {
			System.out.println("Movin' Right");
			
			if (getPosition().getX() > 450) position.setLocation(450, position.getY());
			else position.setLocation(position.getX() + STEP, position.getY());
			
			setPosition(position);
			
			if (this.shipAngle < 10) this.shipAngle += 10;
			getImageView().setRotate(this.shipAngle);
		}
		else if ((!isLeftKeyPressed && !isRightKeyPressed)
				|| (isLeftKeyPressed && isRightKeyPressed)) {
			if (this.shipAngle < 0 ) this.shipAngle += 10;
			else if (this.shipAngle > 0) this.shipAngle -= 10;
			
			getImageView().setRotate(this.shipAngle);
		}
	}
	
	public void spaceShipAttack(AnchorPane pane) {
			System.out.println("Shotin' them");
			BulletHero bullet = new BulletHero();
			bullet.Shoot(this, pane);
			
	}
}
