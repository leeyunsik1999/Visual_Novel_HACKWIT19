import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	public static int AFFECTION = -500;
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
	
	/**
     * Main world method that generates the world in a canvas that allows the player to move around in and encounter enemies
     * 
     * @param stage The javafx stage used to put the canvas in
     */
	public void generateCurrentDay(Stage stage) { 
		Parent root;
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

	public void dayHandler() {
		switch(DAY) {
			case 0:
				scene = new sceneOutline("Userroom.jpg", "DayOne.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				ROUTE = "none";
				break;
			case 1:
				scene = new sceneOutline("Userroom.jpg", "DayTwo.txt", "Python.png", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				ROUTE = "Python";
				break;
			case 2:
				scene = new sceneOutline("Schoolgate.jpg", "DayThree.txt", "Java.png", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				ROUTE = "Java";
				break;
			case 3:
				scene = new sceneOutline("Schoolgate.png", "DayFour.txt", "C.png", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				ROUTE = "C";
				break;
			case 4:
				scene = new sceneOutline("Schoolgate.jpg", "\\Day567\\Day567 Choice.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				break;
			case 5:
				scene = new sceneOutline("Schoolgate.jpg", "\\Day567\\Day567 Choice.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				break;
			case 6:
				scene = new sceneOutline("Schoolgate.jpg", "\\Day567\\Day567 Choice.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
				break;
			case 7:
				ROUTE = secondWeekEventsHandler();
				AFFECTION = BIAS[3][0];
				if(ROUTE.equals("game over")) {
					System.exit(0);
				}
				switch(ROUTE) {
					case "Python":
						scene = new sceneOutline("Userroom.jpg", "\\DayEight\\Python.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
						break;
					case "Java":
						scene = new sceneOutline("Userroom.jpg", "\\DayEight\\Java.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
						break;
					case "C":
						scene = new sceneOutline("Userroom.jpg", "\\DayEight\\C.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
						break;
				}
				break;
			case 8:
				switch(ROUTE) {
				case "Python":
					scene = new sceneOutline("Userroom.jpg", "\\DayNine\\Python.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "Java":
					scene = new sceneOutline("Userroom.jpg", "\\DayNine\\Java.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "C":
					scene = new sceneOutline("Userroom.jpg", "\\DayNine\\C.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
			}
				break;
			case 9:
				switch(ROUTE) {
				case "Python":
					scene = new sceneOutline("Classroom.png", "\\DayTen\\Python.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "Java":
					scene = new sceneOutline("Userroom.png", "\\DayTen\\Java.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "C":
					scene = new sceneOutline("Userroom.png", "\\DayTen\\C.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
			}
				break;
			case 10:
				switch(ROUTE) {
				case "Python":
					scene = new sceneOutline("Rooftop.png", "\\DayEleven\\Python.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "Java":
					scene = new sceneOutline("Rooftop.png", "\\DayEleven\\Java.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "C":
					scene = new sceneOutline("Rooftop.png", "\\DayEleven\\C.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
			}
				break;
			case 11:
				switch(ROUTE) {
				case "Python":
					scene = new sceneOutline("Track.png", "\\DayTwelve\\Python.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "Java":
					scene = new sceneOutline("Clubroom.jpg", "\\DayTwleve\\Java.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "C":
					scene = new sceneOutline("Library.jpg", "\\DayTwleve\\C.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
			}
				break;
			case 12:
				switch(ROUTE) {
				case "Python":
					scene = new sceneOutline("Clubfair.PNG", "\\DayThirteen\\Python.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "Java":
					scene = new sceneOutline("Clubfair.PNG", "\\DayThirteen\\Java.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "C":
					scene = new sceneOutline("Clubfair.PNG", "\\DayThirteen\\C.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
			}
				break;
			case 13:
				switch(ROUTE) {
				case "Python":
					if (AFFECTION > 4)
						scene = new sceneOutline("Userroom.jpg", "\\DayFourteen\\Python\\accepted.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					else
						scene = new sceneOutline("Userroom.jpg", "\\DayFourteen\\Python\\declined.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "Java":
					if (AFFECTION > 4)
						scene = new sceneOutline("Userroom.jpg", "\\DayFourteen\\Java\\accepted.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					else
						scene = new sceneOutline("Userroom.jpg", "\\DayFourteen\\Java\\declined.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
				case "C":
					if (AFFECTION > 4)
						scene = new sceneOutline("Userroom.jpg", "\\DayFourteen\\C\\accepted.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					else
						scene = new sceneOutline("Userroom.jpg", "\\DayFourteen\\C\\declined.txt", "none", "Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
					break;
			}
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
	
	/**
	 * Method that uses javaFX transitions to fade out of a scene to fade into the
	 * world scene
	 */
	public void fadeToNowScene(Node n) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(1000));
		fadeTransition.setNode(n);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.setOnFinished(ActionEvent -> {
			nextNow();
		});
		fadeTransition.play();
	}
	
	/**
	 * Method that uses javaFX transitions to fade out of a scene to fade into the
	 * world scene
	 */
	public void fadeChar(Node n, boolean in) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(500));
		fadeTransition.setNode(n);
		if(in) {
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1);
		}else {
			fadeTransition.setFromValue(1);
			fadeTransition.setToValue(0);
		}
		fadeTransition.play();
	}
	
	/**
	 * Method that uses javaFX transitions to fade out of a scene to fade into the
	 * world scene
	 */
	public void fadeBackground(ImageView iv, Image m) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(500));
		fadeTransition.setNode(iv);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.setOnFinished(ActionEvent -> {
			FadeTransition fadeTrans = new FadeTransition();
			iv.setImage(m);
			fadeTrans.setDuration(Duration.millis(500));
			fadeTrans.setNode(iv);
			fadeTrans.setFromValue(0);
			fadeTrans.setToValue(1);
			fadeTrans.play();
		});
		fadeTransition.play();
	}

	public void nextNow() {
		try {
			generateCurrentDay(game);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void nextScene() {
		try {
			generate(game);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}