import java.time.LocalDate;
interface Visitor {
	LocalDate dateOf=LocalDate.now();
	public void Visit(DairyCattle dairyCattle);
	public void Visit(BeefCattle BeefCattle);
}
class veterinaryVisitor implements Visitor{
	public void Visit(DairyCattle dairyCattle) {
		dairyCattle.setvaccinationInfo(dairyCattle.getName() +" has been injected :"+dateOf);
		System.out.println(dairyCattle.getvaccinationInfo());
	}
	public void Visit(BeefCattle beefCattle) {
		beefCattle.setvaccinationInfo(beefCattle.getName() +" has been injected :"+dateOf);
		System.out.println(beefCattle.getvaccinationInfo());
	}
}
class FALMinisteryVisitor implements Visitor{
	public void Visit(DairyCattle dairyCattle) {
		
	}
	public void Visit(BeefCattle beefCattle) {
		
	}	
}
