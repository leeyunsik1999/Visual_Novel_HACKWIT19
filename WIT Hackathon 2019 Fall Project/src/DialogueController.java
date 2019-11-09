import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class DialogueController implements Initializable{

	@FXML
	private Text genericTextBox;
	
	@FXML
	private AnchorPane bap;
	
	@FXML
	private StackPane bop;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void print() {
		try {
			slowPrint.autoFormat("Hello, My name is Bob.", genericTextBox, 30, 40);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
