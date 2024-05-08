import java.util.LinkedList;

public  class Resources {
	 
	 private static float money;
	 
	 private static LinkedList<Ingredient> ingredients = new LinkedList<>();
	 private static LinkedList<Supplier> suppliers = new LinkedList<>();
	 private static LinkedList<Employee> employees = new LinkedList<>();
	 
	 //------------------------------------------------------//
	 
	 public static void addSupplier(Supplier supplier){
			suppliers.add(supplier);
	}
	
	public static void removeSupplier(Supplier supplier){
		suppliers.remove(supplier);
	}
	
	 //------------------------------------------------------//
	
	public static void addEmployee(Employee employee){
		employees.add(employee);
	}
	
	public static void removeEmployee(Employee employee){
		employees.remove(employee);
	}
	
	 //------------------------------------------------------//
	
	public static void addIngredient(Ingredient ingredient){
		ingredients.add(ingredient);
		ingredients.sort(null);
	}
	
	public static void removeIngredient(Ingredient Ingredient){
		ingredients.remove(Ingredient);
		ingredients.sort(null);
	}
	
	//------------------------------------------------------//
	
	public static Ingredient findIngredient(String name) {
		Ingredient searched = null;
		for(Ingredient i : ingredients) {
			
			if(i.getName().contentEquals(name)) {
				searched = i ;
				break;
			}
		}
		return searched;
	}
	
	public static void takeFromStoredIngredients(LinkedList<Ingredient> ings ) {
		//ings = ingredients
		for(Ingredient ing : ings ) {
			Ingredient i = findIngredient(ing.getName());
			i.takeIngredient(ing.getQuantity());
		}
		
	}
	
	 //------------------------------------------------------//
	
	public static float getMoney() {
		return money;
	}

	public static void changeMoney(Pricable something) {
		money += something.getPrice();
	}
	
	public static void payBills( float amount ) {
		money -= amount;
	}
	
	public static void buyIngredients(LinkedList<Ingredient> ings) {
		for(Ingredient ing : ingredients) {
			Ingredient i = findIngredient(ing.getName());
			i.takeIngredient(ing.getQuantity());
			changeMoney(ing);
		}
	}
	
	 //------------------------------------------------------//
	
	public static float getBaseMoney() {
		
		float ingredientsMoney = 0;
		for(Ingredient i : ingredients) {
			ingredientsMoney += i.getPrice()*i.getQuantity();
		}
		
		return ingredientsMoney + money;
	}

}
