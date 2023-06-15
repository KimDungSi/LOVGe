package Controller;

import GameElements.SpaceShip;
import GameElements.Stone;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GamePlayController {
	@FXML private AnchorPane GamePane;
	@FXML private ImageView background;
	@FXML private Text bullet;
	
	private int bulletCounter; 
	private SpaceShip spaceShip;
	private boolean canShoot = true; // neu canShoot = true thi moi duoc ban
	private Text bossText;
	@FXML
	public void initialize() {
		spaceShip = new SpaceShip();
		GamePane.getChildren().add(spaceShip.getImageView());
		bulletCounter = spaceShip.getBulletStore();
		bullet.setText(String.valueOf(bulletCounter));
	}
	
	public void da()
	{
		Stone stone = new Stone();
		stone.move(spaceShip, GamePane);
	}
	
	public void handleKey(boolean isLeftKeyPressed, boolean isRightKeyPressed, boolean isSpaceKeyPressed) {
		spaceShip.spaceShipMove(isLeftKeyPressed, isRightKeyPressed);
		
		if (isSpaceKeyPressed && canShoot && bulletCounter > 0) {
			bulletCounter--;
			bullet.setText(String.valueOf(bulletCounter));
			spaceShip.spaceShipAttack(GamePane);
			canShoot = false;
			//doi 0.3s moi cho ban' tiep
			PauseTransition shootDelay = new PauseTransition(Duration.seconds(0.3)); 
			shootDelay.setOnFinished(event->{
				canShoot = true;
			});
			
			shootDelay.play();
		}
		
	}
	public void increase(int bullets) {
		if (bulletCounter <= 90) bulletCounter+=10; 
		else bulletCounter = 100;
		bullet.setText(String.valueOf(bulletCounter));
	}
	@FXML
	public void createMoveBackground() {
		//long vao AnimationTimer de lam hieu ung di chuyen man hinh
		if (background.getLayoutY() < 0)
			background.setLayoutY(background.getLayoutY()+0.5);
			if (background.getLayoutY() == -50) createBossText();
			if (background.getLayoutY() == -25) GamePane.getChildren().remove(bossText);
		else {
			
			//hien boss, neu danh chet boss lam cho UFO di chuyen thang len giua man hinh, ket thuc tro choi
		}
	}
	
	public void createBossText() {
		bossText = new Text("BOSS");
		bossText.setFont(Font.font("Arial", FontWeight.BOLD, 96));
		bossText.setFill(Color.RED);
		
		// Tính toán vị trí cho bossText
        double bossTextX = GamePane.getWidth()/ 2 - bossText.getBoundsInLocal().getWidth() / 2;
        double bossTextY = GamePane.getHeight() / 2 - bossText.getBoundsInLocal().getHeight() / 2;
        bossText.setLayoutX(bossTextX);
        bossText.setLayoutY(bossTextY);

        GamePane.getChildren().add(bossText);
	}
	
}
