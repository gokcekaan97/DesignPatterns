//'Observer'  ==> Abstract Observer.
interface Observer {
	public void Update(ElectronicDevice electronicDevice);
}
//'ConcreteObserver' ==> Farmer
class Farmer implements Observer{
	private Cattle cattle; 
	private double cattleLocation; // Internal Observer state
	private String name;
	private ElectronicDevice _electronicDevice;
	public Farmer(String name){
		this.setName(name);
	}
	public void Update(ElectronicDevice electronicDevice){
		//current cattle type needed.
		this._electronicDevice=electronicDevice; // Reference to Subject
		this.cattleLocation=electronicDevice.getLocation();
		this.cattle=electronicDevice.getCattle();
		System.out.println("Notify that current location of "+cattle.getName()+" is outside of farm boundaries. '"+cattleLocation+"'");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ElectronicDevice get_electronicDevice() {
		return _electronicDevice;
	}
	public void set_electronicDevice(ElectronicDevice _electronicDevice) {
		this._electronicDevice = _electronicDevice;
	}
}