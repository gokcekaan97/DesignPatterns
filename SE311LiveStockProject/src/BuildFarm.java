import java.util.ArrayList;
//The 'Client' of AbstractFactory Pattern.
public class BuildFarm {
	// Object creation is delegated to factory.
	private ArrayList<Food> food;
	public void createMeal(Cattle cattle) {
		food = new ArrayList<Food>();
		food.add(cattle.serveCarbonhydrate());
		food.add(cattle.serveProtein());
	}
	void displayMeals() {
		System.out.println("\tListing Foods\n\t-------------");
		food.forEach(p  -> System.out.println(p.displayType()));
	}
}
