package application;
	
import View.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//chay bat dau tu menu(ViewManager)
			ViewManager manager = new ViewManager();
			primaryStage = manager.getMainStage();
			primaryStage.centerOnScreen();
			primaryStage.setAlwaysOnTop(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
