package SmartElev;




public class Agent {
	private int _id;			   		// every agent has an ID corresponding to it's lane
	String _symbol;
	int _currPos;
	int _prev;
	String _prevName="";
	
	
	
	public Agent(int id) {
		this._id = id;
		 _symbol ="[]";
		
	}
	
	public String getSymbol() {
		return _symbol;
	}
	
	public int getID() {
		return _id;
	}
	
	public int getCurrPos() {
		return _currPos;
	}
	
	public int getPrevPos() {
		return _prev;
	}
	public String getPrevName() {
		return Board.getBoard()[_prev][_id];
	}
	
	public void setCurrPos(int newPos) {
		this._currPos = newPos;
	}

	public void setPrevPos(int pos) {
		this._prev = pos;

	}
	
	public void moveToFloor(int pos) {
		if(pos<_currPos) {
			//move up (-)
		}
		else if(pos>_currPos) {
			//move down (+)
		}
		else {
			//stop (same floor)
		}
	}

}
