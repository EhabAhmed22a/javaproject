package javaapplication4;

import java.util.LinkedList;

public class Resources {
	 
	 private static float money;
	 
	 private static LinkedList<Ingredient> ingredients = new LinkedList<>();
	 private static LinkedList<Supplier> suppliers = new LinkedList<>();
	 private static LinkedList<Employee> employees = new LinkedList<>();
	 
	 //------------------------------------------------------//
	 
	 public void addSupplier(Supplier supplier){
			suppliers.add(supplier);
	
			suppliers.sort(null);
	}
	
	public void removeSupplier(Supplier supplier){
		suppliers.remove(supplier);
		suppliers.sort(null);
	}
	
	 //------------------------------------------------------//
	
	public void addEmployee(Employee employee){
		employees.add(employee);
	}
	
	public void removeEmployee(Employee employee){
		employees.remove(employee);
	}
	
	 //------------------------------------------------------//
	
	public void addIngredient(Ingredient ingredient){
		ingredients.add(ingredient);
		ingredients.sort(null);
	}
	
	public void removeIngredient(Ingredient Ingredient){
		ingredients.remove(Ingredient);
		ingredients.sort(null);
	}
	
	 //------------------------------------------------------//
	
	public float getMoney() {
		return money;
	}
	
	public float buySomething(Sellable thing) {  
		float amount = thing.getPrice() * thing.getQuantity() ;
		money-=amount;
		return amount;
	}
	
	public void importMoney(int amount) {
		money+=amount;
	}
	
	 //------------------------------------------------------//

}
