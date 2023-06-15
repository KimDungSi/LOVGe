package View;

import java.io.IOException;

import Controller.GamePlayController;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import GameElements.SpaceShip;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class GamePlayManager {
	private AnchorPane gameRoot;
	private Scene gameScene;
	private Stage gameStage;
	
	private boolean isLeftKeyPressed;
	private boolean isRightKeyPressed;
	private boolean isSpaceKeyPressed;
	private AnimationTimer gameTimer;
	
	private long elapsedTime = 0;
	private long pre_elapsedTime = 0;
	private final long BULLET_INCREASE_INTERVAL= 10_000_000_000L;
	private int count_time = -1;
	
	//contructor
	public GamePlayManager() throws IOException {
		//link GamePlay.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
		gameRoot = loader.load();
		GamePlayController controller = loader.getController();
		gameScene = new Scene(gameRoot);
		
		//link gamPlay.css
		String css = this.getClass().getResource("gamePlay.css").toExternalForm();
		gameScene.getStylesheets().add(css);
		
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		
		gameTimer = new AnimationTimer() {
			private long lastTime = 0;
			@Override
			public void handle(long now) {
				// Handle Key Event
				gameScene.setOnKeyPressed(event->{
					KeyCode keyCode = event.getCode();
					if (keyCode == KeyCode.LEFT) isLeftKeyPressed = true;
					else if (keyCode == KeyCode.RIGHT) isRightKeyPressed = true;
					else if (keyCode == KeyCode.SPACE) isSpaceKeyPressed = true;
				});
				gameScene.setOnKeyReleased(event->{
					KeyCode keyCode = event.getCode();
					if (keyCode == KeyCode.LEFT) isLeftKeyPressed = false;
					else if (keyCode == KeyCode.RIGHT) isRightKeyPressed = false;
					else if (keyCode == KeyCode.SPACE) isSpaceKeyPressed = false;
				});
				controller.handleKey(isLeftKeyPressed, isRightKeyPressed, isSpaceKeyPressed);
				
				controller.createMoveBackground();
				
				//increase number of bullet after each 10s
				if (lastTime != 0) {
					long deltaTime =  now - lastTime;
					pre_elapsedTime = elapsedTime;
					elapsedTime += deltaTime;
					
					if ((int) (pre_elapsedTime/1_000_000_000) != (int)(elapsedTime / 1_000_000_000)) {
						count_time++;
						if(elapsedTime >= BULLET_INCREASE_INTERVAL) {
							pre_elapsedTime = 0;
							elapsedTime=0;
						}
							
						if(count_time%10==0)
						{
							controller.increase(10);
						}
						controller.da();
					}
					
					
				}
				lastTime = now;
			}
		};
		
		gameTimer.start();
	}
	public Stage getGameStage() {
		return this.gameStage;
	}
}
