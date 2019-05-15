package SmartElev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* This class is responsible for the initialization of the Board and agents */

public class SystemManager {
	
	private static long t = 600;
	private static ArrayList<Agent> _agents = new ArrayList<Agent>(); 		//List to keep every agent (usefull if we want to add more than default - 4)
	private static ArrayList<Request> _requests = new ArrayList<Request>();
	private int[] utilities = {0,0,0,0};

	private static String _sysBoard[][] = {
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
	private static String _oldBoard[][] = {
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
	
	
	public SystemManager(int numAgents) {
		for (int i=0; i<numAgents; i++) {
			int id = i;
			Agent a = new Agent(id+1);
			_agents.add(a);
		}
		
	}
	public ArrayList<Request> getRequests() {
		return _requests;
	
	}
	
	public void addRequest(Request req) {
		_requests.add(req);
	}
	
	public static ArrayList<Agent> getAgents() {
		return _agents;
	}
	
	public static String[][] getSysBoard(){
		return _sysBoard;
	}
	
	public void updateUtilities(Request req) {
		int util;
		int index;
		for(Agent a: _agents) {
			index = a.getID()-1;
			if(!a.isBusy()) { 
				util = Math.abs(req.getOriginFloor() - a.getCurrPos());
				this.utilities[index] = util;
			}
			else {
				this.utilities[index] = 20;
			}
		}
		  
	}
	
	public void assignRequest() {
		while (_requests.size()>0) {
			Request nextReq = _requests.get(0);
			updateUtilities(nextReq);
			
			if(_agents.get(0).isBusy() && _agents.get(1).isBusy() && _agents.get(2).isBusy() && _agents.get(3).isBusy()) {
				updateBoard();
			}
			else {
			
				int min = utilities[0];
				int minIndex = 0;
				int index = 0;
				for(int i: utilities) {
					if(i < min) {
						min = i;
						minIndex = index;
						index++;
					}
					else{
						index++;
					}
				}
						
				_agents.get(minIndex).setRequest(nextReq);
				//System.out.println("Agent: " + a.getID() + " Request: " + _requests.get(0).getOriginFloor());
				_requests.remove(nextReq);
				_agents.get(minIndex).setIsBusy(true);
				updateBoard();
			}
		}
	}
	 
	
	public void updateBoard() {
			
		for(Agent a: _agents) {
			if (a.isBusy()) {
				System.out.println("Agent ID : " + a.getID());
				if (!a.hasCargo()) {
					moveToFloor(a, a.getOriginPos());
				}
				else if (a.hasCargo()) {
					moveToFloor(a, a.getDestFloor());
				}
			}
		}	
	}
	
	public static void moveToFloor(Agent a, int pos) {
		int cp = a.getCurrPos();
		if(pos < cp) {
			System.out.println("Agent: " + a.getID() + " Moving to floor: " + pos);
			if (cp > pos) {
				int np = cp -1;
				a.setPrevPos(cp);
				a.setCurrPos(np);
				draw(a,np,a.getPrevPos());
				cp--;
			}
		}
		else if(pos>cp) {
			System.out.println("Agent: " + a.getID() + " Moving to floor: " + pos);
			if (cp < pos) {
				int np = cp +1;
				a.setPrevPos(cp);
				a.setCurrPos(np);
				draw(a,np,a.getPrevPos());
				cp++;
			}
		}
		//chegou ao andar para recolher pessoas
		else if(pos == cp && a.hasCargo()==false) {
			System.out.println("Agent: " + a.getID() + " Reached the floor: " + pos);
			int np = cp;
			draw(a, np, a.getPrevPos());
			a.setHasCargo(true);
		}
		
		else if (pos==cp && a.hasCargo()) {
			System.out.println("Agent: " + a.getID() + " Reached the floor: " + pos);
			int np = cp;
			a.setHasCargo(false);
			draw(a, np, a.getPrevPos());
			a.setIsBusy(false);
		}	
	}

	 
	
	public static void updatePrevPos(Agent a) {
		int prevPos = a.getPrevPos();
		int id = a.getID()-1;
		String nameToUpdate = _oldBoard[prevPos][id];
		_sysBoard[prevPos][id] = nameToUpdate;
	}
	
	
	public static void draw (Agent a, int pos, int prev) {
		String s = a.getSymbol();
		int id = a.getID();
		for(String[] sArr: _sysBoard) {
			for(int i=0; i<sArr.length;i++) {
				char c = sArr[i].charAt(2);
				int k = 0;
				switch(c) {
					case 'A':
						k=1;
						break;
					case 'B':
						k=2;
						break;
					case 'C':
						k=3;
						break;
					case 'D':
						k=4;
						break;
				}
				if(k == id) {
					_sysBoard[pos][i] = s; 			// put the agent on the new floor
					updatePrevPos(a);
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
