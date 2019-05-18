import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Initializer {
	private String _type;
	private ArrayList<Agent> _agents = SystemManager.getAgents();
	private String _sysBoard[][] = SystemManager.getSysBoard();
	private long t = 600;
	
	
	public Initializer(String type) {
		this._type = type;
		System.out.println("\r\n" + 
				"  /$$$$$$                                      /$$           /$$$$$$$$ /$$                                 /$$                                  \r\n" + 
				" /$$__  $$                                    | $$          | $$_____/| $$                                | $$                                  \r\n" + 
				"| $$  \\__/ /$$$$$$/$$$$   /$$$$$$   /$$$$$$  /$$$$$$        | $$      | $$  /$$$$$$  /$$    /$$ /$$$$$$  /$$$$$$    /$$$$$$   /$$$$$$   /$$$$$$$\r\n" + 
				"|  $$$$$$ | $$_  $$_  $$ |____  $$ /$$__  $$|_  $$_/        | $$$$$   | $$ /$$__  $$|  $$  /$$/|____  $$|_  $$_/   /$$__  $$ /$$__  $$ /$$_____/\r\n" + 
				" \\____  $$| $$ \\ $$ \\ $$  /$$$$$$$| $$  \\__/  | $$          | $$__/   | $$| $$$$$$$$ \\  $$/$$/  /$$$$$$$  | $$    | $$  \\ $$| $$  \\__/|  $$$$$$ \r\n" + 
				" /$$  \\ $$| $$ | $$ | $$ /$$__  $$| $$        | $$ /$$      | $$      | $$| $$_____/  \\  $$$/  /$$__  $$  | $$ /$$| $$  | $$| $$       \\____  $$\r\n" + 
				"|  $$$$$$/| $$ | $$ | $$|  $$$$$$$| $$        |  $$$$/      | $$$$$$$$| $$|  $$$$$$$   \\  $/  |  $$$$$$$  |  $$$$/|  $$$$$$/| $$       /$$$$$$$/\r\n" + 
				" \\______/ |__/ |__/ |__/ \\_______/|__/         \\___/        |________/|__/ \\_______/    \\_/    \\_______/   \\___/   \\______/ |__/      |_______/ \r\n" + 
				"                                                                                                                                                \r\n" + 
				"                                                                                                                                                \r\n" + 
				"                                                                                                                                                \r\n" + 
				"");
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(type.equals("zero")) {
			System.out.println("SYSTEM STARTED WHITH OPTION 'ZERO'");
			initializeZero();
		}
		
		if(type.contentEquals("divided")) {
			initializeRandom();
		}

	}
	
	
	private void initializeRandom() {
		int start = 0;
		for(Agent a: _agents) {
			String s = a.getSymbol();
			int id = a.getID();
			for(String[] sArr: _sysBoard) {
				for(int i=0; i<sArr.length;i++) {
					char c = sArr[i].charAt(2);
					int k = 0;
					switch(c) {
						case 'A':
							k=1;
							start=0;
							break;
						case 'B':
							k=2;
							start=4;
							break;
						case 'C':
							k=3;
							start=9;
							break;
						case 'D':
							k=4;
							start=14;
							break;
					}
					if(k == id) {
						_sysBoard[start][i] = s; //put the agents on the 1st, 5th, 10th, 14th floor
						a.setCurrPos(start);
					}
				}
			}
		}

		for(Agent a: _agents){
			System.out.println("Agent ID: " + a.getID() + " Start Pos: " + a.getCurrPos());
		} 
		System.out.println( Board.drawBoard(_sysBoard));
		
		try {
			TimeUnit.MILLISECONDS.sleep(t );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	public void initializeZero() {
		for(Agent a: _agents) {
			String s = a.getSymbol();
			int id = a.getID();
			for(String[] sArr: _sysBoard) {
				for(int i=0; i<sArr.length;i++) {
					char c = sArr[i].charAt(1);
					int cTi = Character.getNumericValue(c);
					if(cTi == id) {
						_sysBoard[14][i] = s; //put the agent on the first floor
						a.setCurrPos(14);
					}
				}
			}
		}
		System.out.println( Board.drawBoard(_sysBoard));
		try {
			TimeUnit.MILLISECONDS.sleep(t );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
