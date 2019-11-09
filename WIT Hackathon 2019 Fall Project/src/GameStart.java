import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameStart extends Application {

	public static Stage game = new Stage();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Shows main menu screen
		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml")); 
		Scene scene = new Scene(root);
		game.setScene(scene);
		game.show();
		game.setResizable(false);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
