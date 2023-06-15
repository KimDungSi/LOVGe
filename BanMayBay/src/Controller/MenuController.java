package Controller;

import java.io.IOException;

import View.GamePlayManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
// sua lai background o file Menu.fxml
public class MenuController {
	private Parent root;
	private Scene scene;
	private Stage stage;
	@FXML
	Button myButtonPlay;
	@FXML
	Label logoGame;
	@FXML
	public void Play(ActionEvent event) throws IOException {
		// xu ly su kien nhan Play thi chuyen stage vao choi.
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.hide();
		GamePlayManager gameManager = new GamePlayManager();
		stage = gameManager.getGameStage();
		stage.show();
	}
	
}
