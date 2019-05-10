import java.util.ArrayList;

abstract class ElectronicDevice{
	protected Signal _signal;
	protected double _location;
	protected Cattle _cattle;
	public Signal getSignal(){return null;}
	public Cattle getCattle(){return null;}
	public double getLocation(){return 0.0;}
	public void setCattle(Cattle cattle){
		this._cattle=cattle;
	}
	abstract public void setLocation(double location);
	protected ArrayList<Farmer> _farmer =new ArrayList<Farmer>();
	public void Attach(Farmer farmer){
		_farmer.add(farmer);
	}
	public void Notify(){
		for(Farmer f: _farmer){
			f.Update(this);
		}
	}
	public ElectronicDevice(Cattle cattle,double location,Signal signal){
		this._cattle=cattle;
		this._signal=signal;
		this._location=location;
	}
}
class CattleElectronicDevice extends ElectronicDevice{
	public CattleElectronicDevice(Cattle cattle,double location,Signal signal) {
		super(cattle,location,signal);
	}
	public void setLocation(double location){
		// make the location randomized.
		_signal.sendLocation(location);
		_location=location;
		if (location<0||location>10) {
			Notify();
		}
	}
	public Signal getSignal(){return _signal;}
	public Cattle getCattle(){return _cattle;}
	public double getLocation(){return _location;} 
} 