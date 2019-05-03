package SmartElev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* This class is responsible for the initialization of the Board and agents */

public class SystemManager {
	
	private long t = 600;
	private static ArrayList<Agent> _agents = new ArrayList<Agent>(); 		//List to keep every agent (usefull if we want to add more than default - 4)
	private static String _sysBoard[][] = {
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
	private static String _oldBoard[][] = {
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
	
	
	public SystemManager(int numAgents) {
		for (int i=0; i<numAgents; i++) {
			int id = i;
			Agent a = new Agent(id+1);
			_agents.add(a);
		}
		
	}
	
	public static ArrayList<Agent> getAgents() {
		return _agents;
	}
	
	public static String[][] getSysBoard(){
		return _sysBoard;
	}
	
	
	
	public void draw(Agent agent, int pos, int prev) {
		String s = agent.getSymbol();
		int id = agent.getID();
		for(String[] sArr: _sysBoard) {
			for(int i=0; i<sArr.length;i++) {
				char c = sArr[i].charAt(1);
				int cTi = Character.getNumericValue(c);
				if(cTi == id) {
					_sysBoard[pos][i] = s; 			// put the agent on the new floor
					updatePrevPos(agent);
				}
			}
		}
		System.out.println( Board.drawBoard(_sysBoard));
		try {
			TimeUnit.MILLISECONDS.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updatePrevPos(Agent a) {
		int prevPos = a.getPrevPos();
		int id = a.getID()-1;
		String nameToUpdate = _oldBoard[prevPos][id];
		_sysBoard[prevPos][id] = nameToUpdate;
	}
	
	
	
	public void run(String type, int iterations) {
		Initializer init = new Initializer(type);
		System.out.println("Total number of iteration --> " +iterations + "\n");
		for (int i=0; i<iterations; i++) {
			System.out.println("\n System after iteration number " + i + "\n");
			for(Agent a: _agents) {
				if(a.getCurrPos()==0) {
					a.setPrevPos(a.getCurrPos());
					a.setCurrPos(a.getCurrPos()+1);
					draw(a, a.getCurrPos(), a.getPrevPos());
					try {
						TimeUnit.MILLISECONDS.sleep(t);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (a.getCurrPos()==14) {
					a.setPrevPos(a.getCurrPos());
					a.setCurrPos(a.getCurrPos()-1);
					draw(a, a.getCurrPos(), a.getPrevPos());
					try {
						TimeUnit.MILLISECONDS.sleep(t);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					a.setPrevPos(a.getCurrPos());
					a.setCurrPos(a.getCurrPos()-1);
					draw(a, a.getCurrPos(), a.getPrevPos());
					try {
						TimeUnit.MILLISECONDS.sleep(t);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
