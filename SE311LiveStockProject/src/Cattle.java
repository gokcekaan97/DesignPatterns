import java.util.ArrayList;
//Element  (Animal)
//defines an Accept operation that takes a visitor
//as an argument.
interface Animal{
	public void Accept(Visitor visitor);
}
//ConcreteElement  (Cattle)
//implements an Accept operation that
//takes a visitor as an argument
abstract public class Cattle implements Animal{
	protected Singleton _singleton= Singleton.getInstance(); //from Singleton class 
	private int id;
	protected String _vaccinationInfo;
	protected String name;
	public String getName(){return name;}
	public Cattle(String name){
		this.name=name;
		setvaccinationInfo("vaccination has not been injected before.");
		_singleton.addCattle(this); //accesses to the Database through the Singleton object
		setId(0);
	}
	abstract public Protein serveProtein();
	abstract public Carbonhydrate serveCarbonhydrate();
	protected String getvaccinationInfo() {
		return _vaccinationInfo;
	}
	protected void setvaccinationInfo(String _vaccinationInfo) {
		this._vaccinationInfo = _vaccinationInfo;
	}
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
}	
class DairyCattle extends Cattle {
	public DairyCattle(String name){
		super(name);
	}
	public Protein serveProtein(){
		return new Soybean(5);
	}
	public Carbonhydrate serveCarbonhydrate(){
		return new Corn(10);
	}
	public void Accept(Visitor visitor) {visitor.Visit(this);}
}
class BeefCattle extends Cattle{
	public BeefCattle(String name ){
		super(name);
	}
	public Protein serveProtein(){
		return new Canola(25);
	}
	public Carbonhydrate serveCarbonhydrate(){
		return new Wheat(10);
	}
	public void Accept(Visitor visitor) {visitor.Visit(this);}
}
//ObjectStructure  (Cattles)
class Cattles {
	public void Add(Cattle cattle){ cattles.add(cattle);};
	public void Remove(Cattle cattle) {
		for (int i = 0; i< cattles.size(); i++) {
			if (cattles.get(i).getName() == cattle.getName()) {
				cattles.remove(i);
				return;
			}
		}
	}
	public void Accept(Visitor visitor) {
		for (int i = 0; i < cattles.size(); i++) {
			cattles.get(i).Accept(visitor);		}
	}
	private ArrayList<Cattle> cattles = new ArrayList<Cattle>();
}