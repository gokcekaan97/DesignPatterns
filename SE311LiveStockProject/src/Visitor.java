import java.time.LocalDate;
abstract public class Visitor {
	protected static int id=1; 
	protected LocalDate dateOf=LocalDate.now();
	public abstract void Visit(DairyCattle dairyCattle);
	public abstract void Visit(BeefCattle BeefCattle);
}
class veterinaryVisitor extends Visitor{
	public void Visit(DairyCattle dairyCattle) {
		dairyCattle.setvaccinationInfo(dairyCattle.getName() +" has been injected :"+dateOf);
		dairyCattle.setId(id);
		System.out.println(dairyCattle.getvaccinationInfo());
		id++;
	}
	public void Visit(BeefCattle beefCattle) {
		beefCattle.setvaccinationInfo(beefCattle.getName() +" has been injected :"+dateOf);
		beefCattle.setId(id);
		System.out.println(beefCattle.getvaccinationInfo());
		id++;
	}
}
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
