package SmartElev;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {

		SystemManager sys = new SystemManager(4);
		//sys.run("zero",2);
		//Initializer init = new Initializer("zero");
		Initializer init = new Initializer("random");
		//ArrayList<Request> list = new ArrayList<Request>();
		
		long begin = System.currentTimeMillis();

		//7 AM
		int hour = 7;
        Request req1 = new Request(14,1,false);
        Request req2 = new Request(14,8,false);
        sys.addRequest(req1);
		sys.addRequest(req2);
		//sys.setRequests(list);

		System.out.println("Its : " + hour + "o clock");
		 
		//8 AM
        hour++;
        Request req3 = new Request(14,10,false);
		Request req4 = new Request(14,2,false);
        Request req5 = new Request(8,2,false);
        sys.addRequest(req3);
        sys.addRequest(req4);
        sys.addRequest(req5);
		 
		
        //9 AM
        hour++;
		Request req6 = new Request(14,12,false);
		Request req7 = new Request(14,9,false);
		Request req8 = new Request(14,1,false);
		Request req9 = new Request(2,14,false);
		Request req10 = new Request(14,9,false);
        Request req11 = new Request(11,14,false);
        sys.addRequest(req6);
        sys.addRequest(req7);
        sys.addRequest(req8);
        sys.addRequest(req9);
        sys.addRequest(req10);
        sys.addRequest(req11);
    
		 

		System.out.println("Its : " + hour + "o clock");
		 
        
        //10 AM
        hour++;
		Request req12 = new Request(5,13,false);
        Request req13 = new Request(6,12,false);
        sys.addRequest(req12);
        sys.addRequest(req13);
        
		 
		
		System.out.println("Its : " + hour + "o clock");
		
        
        //11 AM
        hour++;
        Request req14 = new Request(6,11,false);
        sys.addRequest(req14);

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        
        //12 PM
        hour++;
		Request req15 = new Request(0,11,false);
		Request req16 = new Request(5,14,false);
        Request req17 = new Request(11,0,false);
        sys.addRequest(req15);
        sys.addRequest(req16);
        sys.addRequest(req17);

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        
        //13 PM
        hour++;
		Request req18 = new Request(13,14,false);
		Request req19 = new Request(10,14,false);
		Request req20 = new Request(14,8,false);
		Request req21 = new Request(0,14,false);
		Request req22 = new Request(6,14,false);
		Request req23 = new Request(13,5,false);
        Request req24 = new Request(2,14,false);
        sys.addRequest(req18);
        sys.addRequest(req19);
        sys.addRequest(req20);        
        sys.addRequest(req21);
        sys.addRequest(req22);        
        sys.addRequest(req23);
        sys.addRequest(req24);
		 
		
		System.out.println("Its : " + hour + "o clock");
		
        
        //14 PM
        hour++;
		Request req25 = new Request(2,14,false);
		Request req26 = new Request(10,14,false);
		Request req27 = new Request(14,5,false);
		Request req28 = new Request(12,14,false);
		Request req29 = new Request(14,7,false);
        Request req30 = new Request(2,14,false);
        sys.addRequest(req25);
        sys.addRequest(req26);
        sys.addRequest(req27);
        sys.addRequest(req28);
        sys.addRequest(req29);
        sys.addRequest(req30);

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //15 PM
        hour++;
        Request req31 = new Request(14,3,false);
		Request req32 = new Request(6,1,false);
        Request req33 = new Request(9,12,false);
        sys.addRequest(req31);
        sys.addRequest(req32);
        sys.addRequest(req33);

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //16 PM
        hour++;
		Request req34 = new Request(9,12,false);
        Request req35 = new Request(7,6,false);
        sys.addRequest(req34);
        sys.addRequest(req35);

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //17 PM
        hour++;
		Request req36 = new Request(10,4,false);
        Request req37 = new Request(10,14,false);
        sys.addRequest(req36);
        sys.addRequest(req37);

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //18 PM
        hour++;
		Request req38 = new Request(13,14,false);
		Request req39 = new Request(2,0,false);
        Request req40 = new Request(2,14,false);
        sys.addRequest(req38);
        sys.addRequest(req39);
        sys.addRequest(req40);

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //19 PM
        hour++;
		Request req41 = new Request(2,14,false);
		Request req42 = new Request(12,14,false);
		Request req43 = new Request(8,1,false);
		Request req44 = new Request(1,14,false);
		Request req45 = new Request(5,14,false);
        Request req46 = new Request(0,14,false);
        sys.addRequest(req41);
        sys.addRequest(req42);
        sys.addRequest(req43);
        sys.addRequest(req44);
        sys.addRequest(req45);
        sys.addRequest(req46);
    
		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //20 PM
        hour++;
		Request req47 = new Request(6,14,false);
        Request req48 = new Request(11,14,false);
        sys.addRequest(req47);
        sys.addRequest(req48); 

		 
		
		System.out.println("Its : " + hour + "o clock");
		while (sys.getRequests().size()>0) {
			sys.assignRequest(); 
		}
		
		int i = 0;
		while(i<400) {
			sys.updateBoard();
			i++;
		}

		long end = System.currentTimeMillis();
		long totalTime = end - begin;
		System.out.println("Elapsed: " + totalTime/1000 + " segs");
		
	}


}
