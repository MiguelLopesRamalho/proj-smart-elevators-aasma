package SmartElev;

public class Request {
	
	private int _originFloor;
	private int _destFloor;
	private boolean _isHeavy;
	
	public Request(int origin,int destination, boolean isHeavy) {
		this._originFloor = origin;
		this._destFloor = destination;
		this._isHeavy = isHeavy;
		
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

}
