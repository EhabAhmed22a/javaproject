
import java.util.LinkedList;

public class BookingManager {
	
	private static LinkedList <FoodItem> menu = new LinkedList();
	private static LinkedList <Table> tables = new LinkedList();
	
	//-------------------------------------------------//
	
	public static LinkedList<FoodItem> getMenu() {
		return menu;
	}
	
	public static LinkedList<Table> getTables() {
		return tables;
	}
	
	//-------------------------------------------------//
	
	public static void addFoodItemToMenu(FoodItem food) {
		menu.add(food);
		menu.sort(null);
	}
	
	public static void removeFoodItemToMenu(FoodItem food) {
		menu.remove(food);
		menu.sort(null);
	}
	
	//-------------------------------------------------//
	
	public static void addTable(Table table) {
		tables.add(table);
	}
	
	public static void removeTable(Table table) {
		tables.remove(table);
	}
	
	//-------------------------------------------------//
	public static LinkedList <Table> getCurrentlyAvailableTables(){
		LinkedList <Table> allTables = getTables();
		LinkedList <Table> currentlyAvailableTables = new LinkedList();
		for(Table availableTable : allTables ) {
			if(availableTable.isEmpty()) {
				currentlyAvailableTables.add(availableTable);
			}
		}
		return currentlyAvailableTables;
		
	}
	
	public static LinkedList <Table> getNextAvailableTables(){
		LinkedList <Table> allTables = getTables();
		LinkedList <Table> nextAvailableTables = new LinkedList();
		for(Table availableTable : allTables ) {
			if(availableTable.isNextOrderEmpty()) {
				nextAvailableTables.add(availableTable);
			}
		}
		
		return nextAvailableTables;
	}
	
	//-------------------------------------------------//
	
	public void createOrder(
			LinkedList<FoodItem> foodItems ,
			boolean isDelivary ,int duration, Table table , int price, boolean now
			) {
		
		Order newOrder = new Order(foodItems ,isDelivary ,duration );
		for(FoodItem fooditem : foodItems) {
			Resources.takeFromStoredIngredients(fooditem.getIngredients());
		}
		if(now) {
			table.bookTable(newOrder);
		} else {
			table.bookTableNext(newOrder);
		}
		 Resources.changeMoney(newOrder);
		
	}
	
	//-------------------------------------------------//
	
	
}
