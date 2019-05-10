
abstract public class Cattle {
	protected String name;
	public String getName(){return name;}
	public Cattle(String name){
		this.name=name;
	}
	abstract public Protein serveProtein();
	abstract public Carbonhydrate serveCarbonhydrate();
}	

class DairyCattle extends Cattle {
	public DairyCattle(String name ){
		super(name);
	}
	public Protein serveProtein(){
		return new Soybean(5);
	}
	public Carbonhydrate serveCarbonhydrate(){
		return new Corn(10);
	}
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
}

