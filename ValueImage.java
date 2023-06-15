package GameElements;

import Controller.GamePlayController;
import lib.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javafx.scene.image.ImageView;
import Controller.GamePlayController;
import javafx.scene.layout.AnchorPane;
import java.util.*;

public class ValueImage {
	ImageView imageView;
	float widthImage;
	float heighImage;
	int typeImage;//0 la khong the xoa
	
	public ValueImage() {
	}
	
	public ValueImage(ImageView imageView, float widthImage, float heighImage, int typeImage) {
		this.imageView = imageView;
		this.heighImage = heighImage;
		this.widthImage = widthImage;
		this.typeImage = typeImage;
	}

	/*public String getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	public float getWidthImage() {
		return widthImage;
	}

	public void setWidthImage(float widthImage) {
		this.widthImage = widthImage;
	}

	public float getHeighImage() {
		return heighImage;
	}

	public void setHeighImage(float heighImage) {
		this.heighImage = heighImage;
	}

	public int getTypeImage() {
		return typeImage;
	}

	public void setTypeImage(int typeImage) {
		this.typeImage = typeImage;
	}*/
	
}
