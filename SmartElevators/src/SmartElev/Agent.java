package SmartElev;

import java.awt.Color;

public class Agent {
	private int _id;			   		// every agent has an ID corresponding to it's lane
	private int _currPos;
	private int _prev;
	private String _prevName="";
	private boolean _isFree = true;
	private boolean _busy = false;
	private Request _req;
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
		return (14 -_req.getOriginFloor());
	}
	
	public int getDestFloor() {
		return (14 -_req.getDestFloor());
	}
	
	public void setRequest(Request req) {
		this._req = req;
	}
	
	public void setHasCargo(boolean bol) {
		this._hasCargo = bol;
	}
	
	public boolean hasCargo() {
		return this._hasCargo;
	}
	


}
