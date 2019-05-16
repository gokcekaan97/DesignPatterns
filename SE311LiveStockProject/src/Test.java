public class Test {
    public static void main(String[]args){
        //Client of abstract factory pattern.
        BuildFarm Farm= new BuildFarm();
        //Concrete visitors of visitor pattern.
        Visitor falM=new FALMinisteryVisitor();
        Visitor veterinary=new veterinaryVisitor();
        //Object structure of visitor pattern.
        Cattles allCattles=new Cattles();
        //Concrete factory of abstract factory method and Concrete element of visitor pattern.
        Cattle beefCattle2=new BeefCattle("Beef cattle number 2");
        Cattle dairyCattle=new DairyCattle("Dairy cattle number 1");
        Cattle beefCattle=new BeefCattle("Beef cattle number 1");
        //Adapter pattern is used for signals.
        Signal zigbeeSignal=new ZigbeeSignal();
        BluetoothSignal bluetooth=new BluetoothToZigbeeConnector(new ZigbeeSignal());
        //Observer and singleton patterns are used for electronic devices.
        ElectronicDevice ed1=new CattleElectronicDevice(beefCattle,4.2,bluetooth);
        ElectronicDevice ed2= new CattleElectronicDevice(beefCattle2,3.3,zigbeeSignal);
        ElectronicDevice ed=new CattleElectronicDevice(dairyCattle,5.5,zigbeeSignal);
        //Concrete observer.
        Farmer farmer=new Farmer("Bob");
        System.out.println("Serving dairy cattle's meal.");
        //To fill object structure(Cattles).
        allCattles.Add(dairyCattle);
        allCattles.Add(beefCattle);
        //Veterinary is visited.
        allCattles.Accept(veterinary);
        allCattles.Add(beefCattle2);
        // Ministry of Food Agriculture and Livestock is visited.
        allCattles.Accept(falM);
        //These two methods delegates object creation to factory.
        System.out.println(dairyCattle.getName()+" feeded");
        Farm.createMeal(dairyCattle);
        Farm.displayMeals();
        System.out.println(beefCattle.getName()+" feeded");
        Farm.createMeal(beefCattle);
        Farm.displayMeals();
        System.out.println(beefCattle2.getName()+" feeded");
        Farm.createMeal(beefCattle2);
        Farm.displayMeals();
        //Register the observers by calling the Attach method.
        ed.Attach(farmer);
        ed1.Attach(farmer);
        ed2.Attach(farmer);
        //We use both the observer pattern and the singleton pattern
        //By calling setLocation() which notifies and updates the observer 
        //and also accesses to the database through our singleton instance. 
        ed2.setLocation(50);
        ed.setLocation(5);
        ed.setLocation(-5);
        ed1.setLocation(11);
    }
}