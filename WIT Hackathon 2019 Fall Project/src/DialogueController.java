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
		genericTextBox.setStyle("-fx-background-color: transparent;");
		background.setImage(sceneOutline.getBackground());
	}
	

}
