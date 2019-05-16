import java.time.LocalDate;
//"Visitor"
abstract public class Visitor {
	protected static int id=1; 
	protected LocalDate dateOf=LocalDate.now(); 
	public abstract void Visit(DairyCattle dairyCattle);
	public abstract void Visit(BeefCattle BeefCattle);
}
//"ConcreteVisitor1 - veterinaryVisitor"
class veterinaryVisitor extends Visitor{
	public void Visit(DairyCattle dairyCattle) {
		dairyCattle.setId(id); 
		dairyCattle.setvaccinationInfo(dairyCattle.getName() +" has been injected :"+dateOf+"(Cattle id :"+dairyCattle.getId()+")");
		System.out.println(dairyCattle.getvaccinationInfo());
		id++;
	}
	public void Visit(BeefCattle beefCattle) {
		beefCattle.setId(id);
		beefCattle.setvaccinationInfo(beefCattle.getName() +" has been injected :"+dateOf+"(Cattle id :"+beefCattle.getId()+")");
		System.out.println(beefCattle.getvaccinationInfo());
		id++;
	}
}
//"ConcreteVisitor2 - FALMinisteryVisitor"
class FALMinisteryVisitor extends Visitor{
	public void Visit(DairyCattle dairyCattle) {
		if(dairyCattle.getId()==0){
			System.out.println(dairyCattle.getName()+" this cattle does not injected before.");
		}
	}
	public void Visit(BeefCattle beefCattle) {
		if(beefCattle.getId()==0){
			System.out.println(beefCattle.getName()+" this cattle does not injected before.");
		}
	}	
}