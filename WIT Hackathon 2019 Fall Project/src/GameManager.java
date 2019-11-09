import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class GameManager {
	
	
	public static int[][]		BIAS = new int[3][2];	// Three rows: 0 = python, 1 = java, 2 = c. Two columns: 0 = affection, 1 = days visited
	public static int 			DAY = 1;				// Day number 
	public static int			AFFECTION = 0;
	public static int           VOLUME = 10;
	public static String 		ROUTE;
	public static MediaPlayer   musicPlayer;
	
	public void dayHandler() {
		for (int i = 0; i < 14; i++) {
			// TODO Call scenes here
		}
	}
	
	public void firstWeekEventsHandler(String characterChoice) {
		switch(characterChoice) {
		
		case "python": 
			pythonDays.dayCheck(BIAS);
			break;
		
		case "java": 
			javaDays.dayCheck(BIAS);
			break;
			
		case "c":
			cDays.dayCheck(BIAS);
			break;

		}
	}
	
	public String secondWeekEventsHandler() {
		if (BIAS[0][0] > BIAS[1][0] && BIAS[0][0] > BIAS[2][0]) {
			return "python";
		} else if (BIAS[1][0] > BIAS[0][0] && BIAS[1][0] > BIAS[0][0]) {
			return "java";
		} else {
			return "c";
		}
	}
	
	/**
	 * Method to change volume of music and sounds
	 */
	public static void changeMusicVolume(double i) {
		musicPlayer.setVolume(i);
	}
	
	/**
	 * Method to change the current song playing in the game
	 */
	public static void changeSong(Media song) {
		//If blank stop the music else change to given song
		musicPlayer.stop();
		musicPlayer = new MediaPlayer(song);
		musicPlayer.setVolume(VOLUME);
		musicPlayer.setOnEndOfMedia(new Runnable() {
		       public void run() {
		         musicPlayer.seek(Duration.ZERO);
		       }
		   });
		musicPlayer.play();
	}
	
	/**
	 * Method that uses javaFX transitions to fade out of a scene to fade into the world scene
	 */
	protected static void fadeToWorld(Node n) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(1000));
		fadeTransition.setNode(n);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.setOnFinished(ActionEvent-> {
			nextScene();
		});
		fadeTransition.play();
	}
	
	public static void nextScene() {
		
	}
	
	
}