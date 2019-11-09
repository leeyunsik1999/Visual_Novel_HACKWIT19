
public class cDays {
	
	public static void dayCheck(int[][] bias) {
		switch (bias[2][1]) {

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
		bias[2][0] = bias[2][0] + 1;
		bias[2][1] = 1;
	}

	public static void dayTwo(int[][] bias) {
		bias[2][0] = bias[2][0] + 1;
		bias[2][1] = 2;
	}

	public static void dayThree(int[][] bias) {
		bias[2][0] = bias[2][0] + 1;
		bias[2][1] = 1;
	}

}
