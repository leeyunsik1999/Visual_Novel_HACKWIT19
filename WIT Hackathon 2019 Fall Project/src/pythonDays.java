
public class pythonDays extends GameManager {

	public static void dayCheck(int[][] BIAS) {
		switch (BIAS[0][1]) {

		case 0:
			BIAS[0][0] = BIAS[0][0] + 1;
			BIAS[0][1] = 1;
			scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Python\\EventOne.txt","Python.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
			break;
			
		case 1:
			BIAS[0][0] = BIAS[0][0] + 1;
			BIAS[0][1] = 2;
			scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Python\\EventTwo.txt","Python.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
			break;
			
		case 2:
			BIAS[0][0] = BIAS[0][0] + 1;
			BIAS[0][1] = 3;
			scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Python\\EventThree.txt","Python.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
			break;
			
		}
	}

	public static void dayOne(int[][] BIAS) {
		BIAS[0][0] = BIAS[0][0] + 1;
		BIAS[0][1] = 1;
		scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Python\\EventOne.txt","Python.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
	}

	public static void dayTwo(int[][] BIAS) {
		BIAS[0][0] = BIAS[0][0] + 1;
		BIAS[0][1] = 2;
		scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Python\\EventTwo.txt","Python.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
	}

	public static void dayThree(int[][] BIAS) {
		
		BIAS[0][0] = BIAS[0][0] + 1;
		BIAS[0][1] = 3;
		scene = new sceneOutline("SchoolGate.jpg","\\Day567\\Python\\EventThree.txt","Python.png","Flower Garden - Yoshi's Island-[AudioTrimmer.com].mp3");
	}
}
