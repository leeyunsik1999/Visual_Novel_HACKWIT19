import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class MainController extends Menu implements Initializable{
	
	@FXML
	private Button btnQuit;
	private boolean quitSelected;
	@FXML
	private Button btnStart;
	private boolean startSelected;
	@FXML
	private Circle startCircle;
	@FXML
	private Circle quitCircle;
	@FXML
	private VBox mainMenu;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		keyPressed(mainMenu);
		
	}
	
	public void HoverStart() {
		circleHover(startCircle);
	}
	
	public void ExitStart() {
		circleExit(startCircle);
	}
	
	public void HoverQuit() {
		circleHover(quitCircle);
	}
		
	public void ExitQuit() {
		circleExit(quitCircle);
	}
	
	public void startGame(Event e) {
		btnStart.setDisable(true);
		fadeToNextScene(mainMenu);
	}
	
	public void quit() {
		btnQuit.setDisable(true);
		quitGame();
	}
	
	public void quitGame() {
		System.exit(0);
	}
	
	public void keyPressed(Parent p) {
		p.setOnKeyPressed(new EventHandler<KeyEvent>() {
		      @Override
		      public void handle(KeyEvent e) {
		    	  if(e.getCode() == KeyCode.UP || e.getCode() == KeyCode.DOWN) {
		    		if(quitSelected) {
		    			quitSelected = false;
		    			circleExit(quitCircle);
		    			startSelected = true;
		    			circleHover(startCircle);
		    		}else if(startSelected) {
		    			startSelected = false;
		    			circleExit(startCircle);
		    			quitSelected = true;
		    			circleHover(quitCircle);
		    		}else {
		    			startSelected = true;
		    			circleHover(startCircle);
		    		}
		    	  }
		    	  if(e.getCode() == KeyCode.ENTER) {
		    		  if(startCircle.getOpacity() == 1) 
			    			startGame(e);
			    		else if(quitCircle.getOpacity() == 1) 
			    			quitGame();
			    		
		    	  }
		    	  if(e.getCode() == KeyCode.ESCAPE)
		    		  quitGame();
		    	  e.consume();
		        }
		    });
	}

}
