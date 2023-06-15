package View;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewManager {
	private Parent root;
	private Scene mainScene;
	private Stage mainStage;
	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	
	//constructor
	public ViewManager() throws IOException {
		root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		mainScene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		mainScene.getStylesheets().add(css);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
	}
	
	//getter to get mainStage
	public Stage getMainStage() {
		return this.mainStage;
	}
}
