import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class DialogueController implements Initializable{

	Timeline runningDialogue;
	
	@FXML
	private TextArea genericTextBox;
	
	@FXML
	private AnchorPane bap;
	
	@FXML
	private VBox diaVBox;
	
	@FXML
	private ImageView background;
	
	@FXML
	private ScrollPane scrollyBoi;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		genericTextBox.setEditable(false);
		genericTextBox.autosize();
		genericTextBox.setStyle("-fx-background-color: transparent;");
		background.setImage(sceneOutline.getBackground());
		try {
			Scanner in = new Scanner(sceneOutline.getDialogue());
			keyPressed(diaVBox, in);
			printDialogue(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printDialogue(Scanner in) {
		String s = in.nextLine();
		Timeline timeline = new Timeline();
	    timeline.getKeyFrames().add(new KeyFrame(Duration.ONE, e -> {
			try {
				slowPrint.autoFormat(s, genericTextBox, scrollyBoi, 30, 150);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}));
	    runningDialogue = timeline;
	    runningDialogue.play();
	}
	
	public void skip(Scanner in) {
		runningDialogue.stop();
		printDialogue(in);
	}
	
	public void keyPressed(Parent p, Scanner in) {
		p.setOnKeyPressed(new EventHandler<KeyEvent>() {
		      @Override
		      public void handle(KeyEvent e) {
		    	  if(e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.SPACE) {
		    		skip(in);
		    	  }
		    	  if(e.getCode() == KeyCode.ENTER) {
			    		
		    	  }
		    	  if(e.getCode() == KeyCode.ESCAPE)
		    	  e.consume();
		        }
		    });
	}
	
	

}
