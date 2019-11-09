
public class javaDays {

	public static void dayCheck(int[][] bias) {
		switch (bias[1][1]) {

		case 0:
			dayOne(bias);
			break;
			
		case 1:
			dayTwo(bias);
			break;
			
		case 2:
			dayThree(bias);
			break;
			
		}
	}

	public static void dayOne(int[][] bias) {
		bias[1][0] = bias[1][0] + 1;
		bias[1][1] = 1;
	}

	public static void dayTwo(int[][] bias) {
		bias[1][0] = bias[1][0] + 1;
		bias[1][1] = 2;
	}

	public static void dayThree(int[][] bias) {
		bias[1][0] = bias[1][0] + 1;
		bias[1][1] = 3;
	}

}
