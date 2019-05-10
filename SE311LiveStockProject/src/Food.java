
abstract public class Food {
	protected double _gram;
	abstract public String displayType();
	abstract public double getWeight(); 
}
abstract class Protein extends Food {
	// giving info about what we serve. (Main)
	abstract public String displayType();
	// taking the weight in grams. (Cattle)
	abstract public double getWeight();
}
abstract class Carbonhydrate extends Food {
	abstract public String displayType();
	abstract public double getWeight();
}
class Soybean extends Protein{
	public Soybean(double gram){
		System.out.println("Soybean is served.");
		this._gram=gram;
	}
	public String displayType(){
		return "Served "+this._gram+" gram of Soybean.";
	}
	public double getWeight(){
		return this._gram;
	}
}
class Canola extends Protein{
	public Canola(double gram){
		System.out.println("Canola is served.");
		this._gram=gram;
	}
	public String displayType(){
		return "Served "+this._gram+" gram of Canola.";
	}
	public double getWeight(){
		return this._gram;
	}	
}
class Wheat extends Carbonhydrate{
	public Wheat(double gram){
		System.out.println("Wheat is served.");
		this._gram=gram;
	}
	public String displayType(){
		return "Served "+this._gram+" gram of Wheat.";
	}
	public double getWeight(){
		return this._gram;
	}	
}
class Corn extends Carbonhydrate{
	public Corn(double gram){
		System.out.println("Corn is served.");
		this._gram=gram;
	}
	public String displayType(){
		return "Served "+this._gram+" gram of Corn.";
	}
	public double getWeight(){
		return this._gram;
	}	
}


