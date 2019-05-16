 package SmartElev;

import java.awt.Color;

public class Agent {
	private int _id;			   		// every agent has an ID corresponding to it's lane
	private int _currPos;
	private int _prev;
	private String _prevName="";
	private boolean _isFree = true;
	private boolean _busy = false;
	private Request _currReq;
	private Request _possibleReq;
	private boolean _hasCargo = false;

	
	
	
	
	public Agent(int id) {
		this._id = id;


	}

	public String getSymbol() {
		return  _hasCargo ? "[X]" : "[ ]";
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
	
	public boolean isFree() {
		return this._isFree;
	}
	
	public void setIsFree(boolean bool) {
		this._isFree = bool;
	}
	
	public boolean isBusy() {
		return this._busy;
	}
	
	public void setIsBusy(boolean bool) {
		this._busy = bool;	
	}
	
	public void moveToFloor(int pos) {
		SystemManager.moveToFloor(this, pos);
	}

	public int getOriginPos() {
		return (14 -_currReq.getOriginFloor());
	}
	
	public int getDestFloor() {
		return (14 -_currReq.getDestFloor());
	}
	
	public void setRequest(Request req) {
		this._currReq = req;
	}
	
	public void setHasCargo(boolean bol) {
		this._hasCargo = bol;
	}
	
	public boolean hasCargo() {
		return this._hasCargo;
	}
	
	public Request getPossibleRequest() {
		return this._possibleReq;
	}
	
	public void setPossibleRequest(Request req) {
		this._possibleReq = req;
	}
	
	public void calcUtil() {
		if(this._busy) {
			this._possibleReq.updateUtilities(this.getID()-1, 20);
		}
		else {
			int dest = _possibleReq.getOriginFloor();
			int util = Math.abs(dest - this.getCurrPos());
			this._possibleReq.updateUtilities(this.getID()-1,util);
		}
	}
	
	public void decide() {
		if(!this._possibleReq.isTaken()) {
			int[] arr =  this._possibleReq.getUtilities();
			int min = arr[0];
			int minIndex = 0;
			int index = 0;
			for(int i: arr) {
				if(i < min) {
					min = i;
					minIndex = index;
					index++;
				}
				else{
					index++;
				}
			}
			if (minIndex == this.getID()-1) {
				this._currReq = this._possibleReq;
				SystemManager.sendMessage();
				
			}
		}
	}


}
