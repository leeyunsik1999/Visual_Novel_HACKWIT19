import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class GameManager {

	public static int[][] BIAS = new int[4][2]; // Three rows: 0 = python, 1 = java, 2 = c. Two columns: 0 = affection,
												// 1 = days visited
	public static int DAY = -1; // Day number
	public static int AFFECTION;
	public static int VOLUME = 10;
	public static String ROUTE;
	public static MediaPlayer musicPlayer;
	public static Stage game;
	public static sceneOutline scene;
	
	/**
     * Main world method that generates the world in a canvas that allows the player to move around in and encounter enemies
     * 
     * @param stage The javafx stage used to put the canvas in
     */
	public void generate(Stage stage) { 
		Parent root;
		DAY++;
		dayHandler();
		try {
			root = FXMLLoader.load(getClass().getResource("DialogueGUI.fxml"));
			stage.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        //Shows the world
        stage.getScene().getRoot().setOpacity(0);
    	FadeIn(stage.getScene().getRoot());
        stage.show();
        stage.setResizable(false);
	}
	
	/**
	 * Method to Fade into the world from any scene
	 */
	protected static void FadeIn(Parent vb) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(1000));
		fadeTransition.setNode(vb);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();
	}

	public void dayHandler() {
		switch(DAY) {
			case 0:
				scene = new sceneOutline("Userroom.jpg", "DayOne.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				break;
			case 1:
				scene = new sceneOutline("Error.png", "DayTwo.txt", "PythonGirl.png", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				break;
			case 2:
				scene = new sceneOutline("Error.png", "DayThree.txt", "Java.png", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				break;
			case 3:
				scene = new sceneOutline("Error.png", "DayFour.txt", "C.png", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				break;
			case 4:
				scene = new sceneOutline("Schoolgate.jpg", "\\Day567\\Day567 Choice.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				ROUTE = secondWeekEventsHandler();
				AFFECTION = BIAS[3][0];
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				break;
			case 13:
				break;
			case 14:
				break;
		}
	}

	public void firstWeekEventsHandler(String characterChoice) {
		switch (characterChoice) {

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
		String[] fullNameList = {"python", "java", "c"};
		String[] frontNameList = {"python", "java"};
		String[] backNameList = {"java", "c"};
		String[] middleNameList = {"python", "c"};
		Random r = new Random();
		
		if (BIAS[0][0] > BIAS[1][0] && BIAS[0][0] > BIAS[2][0]) {
			BIAS[3][0] = BIAS[0][0];
			return "python";
		} else if (BIAS[1][0] > BIAS[0][0] && BIAS[1][0] > BIAS[0][0]) {
			BIAS[3][0] = BIAS[1][0];
			return "java";
		} else if (BIAS[2][0] > BIAS[0][0] && BIAS[2][0] > BIAS[1][0]) {
			BIAS[3][0] = BIAS[2][0];
			return "c";
		} else if (BIAS[2][0] == 0 && BIAS[1][0] == 0 && BIAS[1][0] == 0) {
			return "game over";
		} else if (BIAS[2][0] == BIAS[0][0] && BIAS[2][0] == BIAS[1][0]) {
			return fullNameList[r.nextInt(fullNameList.length)];
		} else if (BIAS[1][0] == BIAS[0][0]) {
			return frontNameList[r.nextInt(frontNameList.length)];
		} else if (BIAS[2][0] == BIAS[1][0]) {
			return backNameList[r.nextInt(backNameList.length)];
		} else if (BIAS[2][0] == BIAS[0][0]) {
			return middleNameList[r.nextInt(middleNameList.length)];
		} else {
			return "game over";
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
		// If blank stop the music else change to given song
		if(musicPlayer != null) {
			musicPlayer.stop();
		}
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
	 * Method that uses javaFX transitions to fade out of a scene to fade into the
	 * world scene
	 */
	public void fadeToNextScene(Node n) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(1000));
		fadeTransition.setNode(n);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.setOnFinished(ActionEvent -> {
			nextScene();
		});
		fadeTransition.play();
	}

	public void nextScene() {
		try {
			generate(game);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}