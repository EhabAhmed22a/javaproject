package javaapplication4;

import java.util.ArrayList;
import java.util.List;


public class FoodItem implements Sellable , Comparable<Sellable>  {

    

	//	here the name of the food Objects is the name of ingredient
	private String name;
	private float price;
	public int quantity =0;
	
	FoodItem( String n , int price){
		this.name = n;
		this.price = price ;
	}
        
        //adding function to select the quantity
        public void Select_Quantity( int quantity){
         this.quantity= quantity;
}
	
	//---------------------------------------------------------//
	
        @Override
	public float getPrice() { return this.price; }
	
        @Override
	public void changePrice(float newPrice) {
		this.price = newPrice;
	}

        @Override
	public int getQuantity() {
		return this.quantity;
	}

    public String getName() {
        return name;
    }
	public static List<FoodItem> getFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("Burger", 150));
        foodItems.add(new FoodItem("Pizza", 110));
        
        
        // Add more food items as needed
        return foodItems;
    }
	//---------------------------------------------------------//
	
        @Override
	public int compareTo(Sellable other) {
		   if( this.getPrice() > other.getPrice() )
			   return 1;
	       else if ( this.getPrice() == other.getPrice())
	    	   return 0;
	       return -1;
	}
	
	//---------------------------------------------------------//
	
}
