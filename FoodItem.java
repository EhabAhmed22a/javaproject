package javaapplication4;

import java.util.ArrayList;
import java.util.List;


public class FoodItem extends Sellable   {

	import java.util.LinkedList;

	

		//	here the name of the food Objects is the name of ingredient
		
		private  LinkedList<Ingredient> ingredients = new LinkedList<>(); 
		
		FoodItem( String n , int price , LinkedList<Ingredient> ings){
			this.ingredients = ings;
			this.name = n;
			this.price = price ;
		}	

		//---------------------------------------------------------//
		
		public LinkedList<Ingredient> getIngredients(){
			return this.ingredients;
		}
		


	//	here the name of the food Objects is the name of ingredient
        
        //adding function to select the quantity
        public void Select_Quantity( int quantity){
         this.quantity= quantity;
        }
	
	//---------------------------------------------------------//
	
 
	public static List<FoodItem> getFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        
        foodItems.add(new FoodItem("Burger", 150));
        foodItems.add(new FoodItem("Pizza", 110));
        foodItems.add(new FoodItem("Coffe", 50));
        foodItems.add(new FoodItem("Soup", 40));
        foodItems.add(new FoodItem("Salad", 50));
        
        
        
        // Add more food items as needed
        return foodItems;
    }
	
	//---------------------------------------------------------//
	
       
}
