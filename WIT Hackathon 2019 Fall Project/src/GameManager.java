
public class GameManager {
	
	
	public static int[][]		BIAS = new int[3][2];	// Three rows: 0 = python, 1 = java, 2 = c. Two columns: 0 = affection, 1 = days visited
	public static int 			DAY = 1;				// Day number 
	public static int			AFFECTION = 0;
	public static String 		ROUTE;
	
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

}