
public class YalandanFarm {
	public static void main(String[]args){
		BuildFarm YalandanFarm= new BuildFarm();
		Visitor falM=new FALMinisteryVisitor();
		Visitor veterinary=new veterinaryVisitor();
		Cattles allCattles=new Cattles();
		Cattle beefCattle2=new BeefCattle("Beef cattle number 2");
		Cattle dairyCattle=new DairyCattle("Dairy cattle number 1");
		Cattle beefCattle=new BeefCattle("Beef cattle number 1");
		Signal zigbeeSignal=new ZigbeeSignal();
		BluetoothSignal bluetooth=new BluetoothToZigbeeConnector(new ZigbeeSignal());
		ElectronicDevice ed1=new CattleElectronicDevice(beefCattle,4.2,bluetooth);
		ElectronicDevice ed2= new CattleElectronicDevice(beefCattle2,3.3,zigbeeSignal);
		ElectronicDevice ed=new CattleElectronicDevice(dairyCattle,5.5,zigbeeSignal);
		Farmer ercan=new Farmer("ErJant");
		System.out.println("Serving dairy cattle's meal.");
		allCattles.Add(dairyCattle);
		allCattles.Add(beefCattle);
		allCattles.Accept(veterinary);
		allCattles.Add(beefCattle2);
		allCattles.Accept(falM);
		System.out.println(dairyCattle.getName()+" feeded");
		YalandanFarm.createMeal(dairyCattle);
		System.out.println(beefCattle.getName()+" feeded");
		YalandanFarm.createMeal(beefCattle);
		System.out.println(beefCattle2.getName()+" feeded");
		YalandanFarm.createMeal(beefCattle2);
		YalandanFarm.displayMeals();
		ed.Attach(ercan);
		ed1.Attach(ercan);
		ed2.Attach(ercan);
		ed2.setLocation(50);
		ed.setLocation(5);
		ed.setLocation(-5);
		ed1.setLocation(11);
	}
}
