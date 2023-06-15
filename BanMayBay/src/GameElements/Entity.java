package GameElements;

import lib.Point;
import javafx.scene.image.ImageView;

public class Entity {
	private ImageView imageView;
	private Point position = new Point();
	private double domain;
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position.setLocation(position);
		imageView.setLayoutX(position.getX());
		imageView.setLayoutY(position.getY());
	}

	public ImageView getImageView() {
		return imageView;
	}

	public Entity(String linkImage, float width, float heigh) {
		imageView = new ImageView(linkImage);
		imageView.setFitWidth(width);
		imageView.setFitHeight(heigh);
		domain = width/2;
	}
	
	public boolean hasVaCham(Entity entity) {
		return(position.distance(entity.position) <= domain + entity.domain);
	}
}
