package SmartElev;

public class Request {
	
	private int _originFloor;
	private int _destFloor;
	private boolean _isHeavy;
	private int[] _utilities = {20,20,20,20};
	private boolean _isUpdated;
	private boolean _isTaken;
	
	public Request(int origin,int destination, boolean isHeavy) {
		this._originFloor = 14-origin;
		this._destFloor = 14-destination;
		this._isHeavy = isHeavy;
		this._isUpdated = false;
		this._isTaken = false;
		
	}

	public int getOriginFloor() {
		return _originFloor;
	}

	public void setOriginFloor(int _originFloor) {
		this._originFloor = _originFloor;
	}

	public int getDestFloor() {
		return _destFloor;
	}

	public void setDestFloor(int _destFloor) {
		this._destFloor = _destFloor;
	}

	public boolean isHeavy() {
		return _isHeavy;
	}

	public void setIsHeavy(boolean _isHeavy) {
		this._isHeavy = _isHeavy;
	}
	
	public int[] getUtilities() {
		return _utilities;
	}
	
	public void updateUtilities (int index, int util) {
		this._utilities[index] = util;
	}
	
	public boolean isUpdated() {
		return this._isUpdated;
	}
	
	public void setUpdated() {
		this._isUpdated = true;
	}
	
	public boolean isTaken() {
		return this._isTaken;
	}
	
	public void setIsTaken() {
		this._isTaken = true;
	}

}
