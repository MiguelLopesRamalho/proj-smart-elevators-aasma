package SmartElev;

public class Board {
	private static int x =15;
	static String _board[][] = {
			  {"15A","15B","15C","15D"},	
			  {"14A","14B","14C","14D"},
			  {"13A","13B","13C","13D"},
			  {"12A","12B","12C","12D"},
			  {"11A","11B","11C","11D"},
			  {"10A","10B","10C","10D"},
			  {"09A","09B","09C","09D"},
			  {"08A","08B","08C","08D"},
			  {"07A","07B","07C","07D"},
			  {"06A","06B","06C","06D"},
			  {"05A","05B","05C","05D"},
			  {"04A","04B","04C","04D"},
			  {"03A","03B","03C","03D"},
			  {"02A","02B","02C","02D"},
			  {"01A","01B","01C","01D"}	
			  
	};

	public Board() {
		
	}
	
	public static String[][] getBoard() {
		return _board;
	}
	
	public static String drawBoard(String[][] boardToDraw) {
		String s = "\n\n ";
		for (int i =0; i<x; i++) {
			if(i == 14) {
				String newS = boardToDraw[i][0]+" | " +
						boardToDraw[i][1]+" | " +
						boardToDraw[i][2]+" | " +
						boardToDraw[i][3] + " \n";
				s+= newS;
			}
			else {
				String newS = boardToDraw[i][0]+" | " +
						boardToDraw[i][1]+" | " +
						boardToDraw[i][2]+" | " +
						boardToDraw[i][3]+" " +
	    				      "\n-----+-----+-----+-----\n ";
				s+= newS;
			}
		}
    	return s;
    }
}
