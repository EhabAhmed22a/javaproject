package javaapplication4;

import java.util.LinkedList;

public class Ingredient extends sellable {
//	here the name of the Ingredient Objects is the name of ingredient
	LinkedList<Supplier> suppliers = new LinkedList<>();
	
	 //------------------------------------------------------//
	
	Ingredient(int quantity , int price){
		this.quantity = quantity;
		this.price = price ;
	}
	
	 //------------------------------------------------------//
	
	
	public void addSupplier(Supplier supplier){
		this.suppliers.add(supplier);
		this.suppliers.sort(null);
	}
	
	public void removeSupplier(Supplier supplier){
		this.suppliers.remove(supplier);
		this.suppliers.sort(null);
	}
	
	 //------------------------------------------------------//
	
	
}
