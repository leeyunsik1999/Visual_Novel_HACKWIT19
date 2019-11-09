import java.io.File;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.animation.ScaleTransition;

public class Menu extends GameManager{
	
	MediaPlayer soundEffectPlayer;
	MediaPlayer videoPlayer;
	public static double UI_VOL = .4;
	
	protected void circleHover(Circle c) {
		c.setOpacity(1);
	}
	
	protected void blinkUpAnimation(Node n) {
		//Duration = 2.5 seconds
	    Duration duration = Duration.millis(100);
	    //Create new scale transition
	    ScaleTransition scaleTransition = new ScaleTransition(duration, n);
	    //Set how much X should enlarge
	    scaleTransition.setByX(0.3);
	    //Set how much Y should
	    scaleTransition.setByY(0.3);
	    scaleTransition.play();
	    n.toFront();
	}
	
	protected void blinkAwayAnimation(Node n) {
		//Duration = 2.5 seconds
	    Duration duration = Duration.millis(50);
	    //Create new scale transition
	    ScaleTransition scaleTransition = new ScaleTransition(duration, n);
	    //Set how much X should enlarge
	    scaleTransition.setByX(-0.3);
	    //Set how much Y should
	    scaleTransition.setByY(-0.3);
	    scaleTransition.play();
	}
	
	protected void circleExit(Circle c) {
		c.setOpacity(0);
	}
	
	protected void underlineHover(Button b) {
		b.setUnderline(true);
	}
		
	protected void deunderlineExit(Button b) {
		b.setUnderline(false);
	}
	
}
