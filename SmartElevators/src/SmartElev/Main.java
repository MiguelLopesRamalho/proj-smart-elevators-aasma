package SmartElev;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {

		SystemManager sys = new SystemManager(4);
		//sys.run("zero",2);
		Initializer init = new Initializer("zero");
		ArrayList<Agent> l = SystemManager.getAgents();
		System.out.println("TOTAL NUMBER OF AGENTS --> " + l.size());
		Agent a1 = l.get(0);
		Agent a2 = l.get(1);
		Agent a3 = l.get(2);
		Agent a4 = l.get(3);

		
		Request req1 = new Request(10,4,false);
		Request req2 = new Request(5,1,false);
		Request req3 = new Request(0,7,false);
		Request req4 = new Request(4,14,false);
		Request req5 = new Request(9,0,false);
		Request req6 = new Request(14,0,false);
		Request req7 = new Request(13,2,false);
		
		sys.addRequest(req1);
		sys.addRequest(req2);
		sys.addRequest(req3);
		sys.addRequest(req4);
		//sys.addRequest(req5);
		//sys.addRequest(req6);
		//sys.addRequest(req7);
		
		while (sys.getRequests().size()>0) {
			sys.assignRequest();
		}
		
		System.out.println("Agent 1 at --> " + a1.getCurrPos());
		int i = 0;
		while(i<100) {
			sys.updateBoard();
			i++;
		}
		
	}


}
