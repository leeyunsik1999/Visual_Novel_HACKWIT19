import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class DialogueController implements Initializable{

	@FXML
	private TextArea genericTextBox;
	
	@FXML
	private AnchorPane bap;
	
	@FXML
	private ImageView background;
	
	@FXML
	private ScrollPane scrollyBoi;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		genericTextBox.setEditable(false);
		genericTextBox.autosize();
	}
	
	public void print() {
		try {
			slowPrint.autoFormat("Hello, My name is Bob. Bob Bob Bob Bob Bob Bob Bob Bob Bob Bob Bob Bob Bob Bob Bob Bob BobBob Bob Bob Bob BobBob Bob Bob BobBob Bob Bob BobBob BOBBOBBOBBOBBOBBOBBOBBOBBOBBOBBOBBOBBOBBOBBOB BOBBOBBOBBOBBOBBOBBOBBOB BOBBOBBOBBOBBOBBOB BOBBOBBOBBOBBOBBOBBOBBOB BOBBOBBOBBOBBOB.", genericTextBox, scrollyBoi, 20, 130);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
