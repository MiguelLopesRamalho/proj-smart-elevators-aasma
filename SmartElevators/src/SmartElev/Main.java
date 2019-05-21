package SmartElev;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Main {
	private static int count =0;
	
	public static void main(String[] args) {

		SystemManager sys = new SystemManager(4);
		//sys.run("zero",2);
		Initializer init = new Initializer("zero");
		//Initializer init = new Initializer("divided");
		ArrayList<Request> list = new ArrayList<Request>();
		
		long begin = System.currentTimeMillis();

		//7 AM
		int hour = 7;
        Request req1 = new Request(14,1,false);
        Request req2 = new Request(14,8,false);
        list.add(req1);
		list.add(req2);
		sys.setRequests(list);

		System.out.println("Its : " + hour + "o clock");
		
		 
		//8 AM
        hour++;
        Request req3 = new Request(14,10,false);
		Request req4 = new Request(14,2,false);
        Request req5 = new Request(8,2,false);
        list.add(req3);
        list.add(req4);
        list.add(req5);
        sys.setRequests(list);
      
		
		System.out.println("Its : " + hour + "o clock");
		 
		
        //9 AM
        hour++;
		Request req6 = new Request(14,12,false);
		Request req7 = new Request(14,9,false);
		Request req8 = new Request(14,1,false);
		Request req9 = new Request(2,14,false);
		Request req10 = new Request(14,9,false);
        Request req11 = new Request(11,14,false);
        list.add(req6);
        list.add(req7);
        list.add(req8);
        list.add(req9);
        list.add(req10);
        list.add(req11);
        
        sys.setRequests(list);
		sys.resetPos("zero");
    
		 

		System.out.println("Its : " + hour + "o clock");
		 
        
        //10 AM
        hour++;
		Request req12 = new Request(5,13,false);
        Request req13 = new Request(6,12,false);
        list.add(req12);
        list.add(req13);
        
        sys.setRequests(list);
		sys.resetPos("zero");
        
		 
		
		System.out.println("Its : " + hour + "o clock");
		
        
        //11 AM
        hour++;
        Request req14 = new Request(6,11,false);
        list.add(req14);
        
        sys.setRequests(list);
		sys.resetPos("zero");

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        
        //12 PM
        hour++;
		Request req15 = new Request(0,11,false);
		Request req16 = new Request(5,14,false);
        Request req17 = new Request(11,0,false);
        list.add(req15);
        list.add(req16);
        list.add(req17);
        
        sys.setRequests(list);
		sys.resetPos("zero");

		 
		
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
        list.add(req18);
        list.add(req19);
        list.add(req20);        
        list.add(req21);
        list.add(req22);        
        list.add(req23);
        list.add(req24);
		 
        sys.setRequests(list);
		sys.resetPos("zero");
		
		System.out.println("Its : " + hour + "o clock");
		
        
        //14 PM
        hour++;
		Request req25 = new Request(2,14,false);
		Request req26 = new Request(10,14,false);
		Request req27 = new Request(14,5,false);
		Request req28 = new Request(12,14,false);
		Request req29 = new Request(14,7,false);
        Request req30 = new Request(2,14,false);
        list.add(req25);
        list.add(req26);
        list.add(req27);
        list.add(req28);
        list.add(req29);
        list.add(req30);
        
        sys.setRequests(list);
		sys.resetPos("zero");

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //15 PM
        hour++;
        Request req31 = new Request(14,3,false);
		Request req32 = new Request(6,1,false);
        Request req33 = new Request(9,12,false);
        list.add(req31);
        list.add(req32);
        list.add(req33);
        
        sys.setRequests(list);
		sys.resetPos("zero");

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //16 PM
        hour++;
		Request req34 = new Request(9,12,false);
        Request req35 = new Request(7,6,false);
        list.add(req34);
        list.add(req35);
        
        sys.setRequests(list);
		sys.resetPos("zero");

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //17 PM
        hour++;
		Request req36 = new Request(10,4,false);
        Request req37 = new Request(10,14,false);
        list.add(req36);
        list.add(req37);
        
        sys.setRequests(list);
		sys.resetPos("zero");

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //18 PM
        hour++;
		Request req38 = new Request(13,14,false);
		Request req39 = new Request(2,0,false);
        Request req40 = new Request(2,14,false);
        list.add(req38);
        list.add(req39);
        list.add(req40);
        
        sys.setRequests(list);
		sys.resetPos("zero");

		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //19 PM
        hour++;
		Request req41 = new Request(2,14,false);
		Request req42 = new Request(12,14,false);
		Request req43 = new Request(8,1,false);
		Request req44 = new Request(1,14,false);
		Request req45 = new Request(5,14,false);
        Request req46 = new Request(0,14,false);
        list.add(req41);
        list.add(req42);
        list.add(req43);
        list.add(req44);
        list.add(req45);
        list.add(req46);
        
        sys.setRequests(list);
		sys.resetPos("zero");
    
		 
		
		System.out.println("Its : " + hour + "o clock");
		
        //20 PM
        hour++;
		Request req47 = new Request(6,14,false);
        Request req48 = new Request(11,14,false);
        list.add(req47);
        list.add(req48); 
        
        sys.setRequests(list);

		 
		
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
