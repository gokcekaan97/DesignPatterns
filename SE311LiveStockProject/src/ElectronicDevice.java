import java.util.ArrayList;
//'Subject' ==> ElectronicDevice
abstract class ElectronicDevice{
	protected Singleton _singleton = Singleton.getInstance(); //from Singleton class 
	protected Signal _signal; // Internal Subject state
	protected double _location; // Internal Subject state
	protected Cattle _cattle; // Internal Subject state
	public Signal getSignal(){return null;}
	public Cattle getCattle(){return null;}
	public double getLocation(){return 0.0;}
	public void setCattle(Cattle cattle){
		this._cattle=cattle;
	}
	abstract public void setLocation(double location);
	protected ArrayList<Farmer> _farmer =new ArrayList<Farmer>();
	public void Attach(Farmer farmer){ //Register the Observers
		_farmer.add(farmer);
	}
	public void Notify(){ //Notify the Observers.
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
		_location=location;
		_signal.sendLocation(location);
		_singleton.setCattleLocation(this); //accesses to the Database through the Singleton object
		
		// Whenever the location of the cattle exceeds the range[0-10], notify observers.
		if (location<0||location>10) {
			Notify();
		}
	}
	public Signal getSignal(){return _signal;}
	public Cattle getCattle(){return _cattle;}
	public double getLocation(){return _location;} 
} 