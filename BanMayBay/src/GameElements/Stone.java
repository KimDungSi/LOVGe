package GameElements;

import lib.Point;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.layout.AnchorPane;

public class Stone extends ILU {
	
	public Stone(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width, heigh, vector);
	}
	public Stone() {
		this("/resourses/gamekit/spritesheets/enermy/stoneEnermy/stone1.png",
			 50, 50, new Point(0, 10));
		setPosition(new Point(ThreadLocalRandom.current().nextInt(40,560), 0));
	}
	
	private double imageAngle = 0;
	
	@Override
	public void effect() {
		getImageView().setRotate(imageAngle);
		imageAngle += 3;
	}
	
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		spaceShip.getImageView().setRotate(360);
	}
}
