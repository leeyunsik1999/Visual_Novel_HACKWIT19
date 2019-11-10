import javafx.scene.Node;

public class javaDays extends GameManager{

	public void dayCheck(Node n) {
		switch (BIAS[1][1]) {

		case 0:
			BIAS[1][0] = BIAS[1][0] + 1;
			BIAS[1][1] = 1;
			scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Java\\EventOne.txt","Java.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
			break;
			
		case 1:
			BIAS[1][0] = BIAS[1][0] + 1;
			BIAS[1][1] = 2;
			scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Java\\EventTwo.txt","Java.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
			break;
			
		case 2:
			BIAS[1][0] = BIAS[1][0] + 1;
			BIAS[1][1] = 3;
			scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Java\\EventThree.txt","Java.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
			break;
			
		}
		fadeToNowScene(n);
	}

	public void dayOne(Node n) {
		BIAS[1][0] = BIAS[1][0] + 1;
		BIAS[1][1] = 1;
		scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Java\\EventOne.txt","Java.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
		fadeToNowScene(n);
	}

	public void dayTwo(Node n) {
		BIAS[1][0] = BIAS[1][0] + 1;
		BIAS[1][1] = 2;
		scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Java\\EventTwo.txt","Java.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
	}

	public void dayThree(Node n) {
		BIAS[1][0] = BIAS[1][0] + 1;
		BIAS[1][1] = 3;
		scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Java\\EventThree.txt","Java.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
	}

}
