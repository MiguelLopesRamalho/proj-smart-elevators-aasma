package SmartElev;

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
			initializeZero();
		}
		
		if(type.contentEquals("random")) {
			initializeRandom();
		}

	}
	
	
	private void initializeRandom() {
		// TODO Auto-generated method stub
		
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
