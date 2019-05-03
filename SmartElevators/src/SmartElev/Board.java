package SmartElev;

public class Board {
	private static int x =15;
	static String _board[][] = {
			  {"A1","A2","A3","A4"},         
			  {"B1","B2","B3","B4"},         
			  {"C1","C2","C3","C4"},
			  {"D1","D2","D3","D4"},
			  {"E1","E2","E3","E4"},
			  {"F1","F2","F3","F4"},
			  {"G1","G2","G3","G4"},
			  {"H1","H2","H3","H4"},
			  {"I1","I2","I3","I4"},
			  {"J1","J2","J3","J4"},
			  {"K1","K2","K3","K4"},
			  {"L1","L2","L3","L4"},
			  {"M1","M2","M3","M4"},
			  {"N1","N2","N3","N4"},
			  {"O1","O2","O3","O4"}
			  
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
	    				      "\n----+----+----+----\n ";
				s+= newS;
			}
		}
    	return s;
    }
}
