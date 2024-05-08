//package javaapplication4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Table {
        private static List<Table> allTables;
	private int TableNumber;
	private Order currentOrder;
	private Order nextOrder;
        private String table;
        private Date orderTime;
        private int duration;
        private boolean isAvailable;
	Table(int Tablenumber, String table_two){
		this.TableNumber = Tablenumber;
                this.table=table;
                this.isAvailable = true; // Initially, the table is available
	}
	
	//----------------------------------------------//
	
	
	public Order getCurrrentOrder() {
		return this.currentOrder;
	}

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() {
        return orderTime;
    }
	
	public Order getNextOrder() {
		return this.nextOrder;
	}
	
	//----------------------------------------------//
	
	public boolean isEmpty() {
		return (this.getCurrrentOrder() == null)? true :false ;
	}
	
	public boolean isNextOrderEmpty() {
		return (this.getNextOrder() == null)? true :false ;
	}
	
	//----------------------------------------------//
	
	public void bookTable(Order order) {
		this.currentOrder = order;
	}
	
	public void bookTableNext(Order order) {
		this.nextOrder = order;
	}
	
	//----------------------------------------------//

    public int getTableNumber() {
        return TableNumber;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
     public String getTable() {
        return table;
    }
     public static List<Table> getAvailableTables() {
        // Implement logic to retrieve available tables from the database or any other source
        // For demonstration purposes, let's initialize a list of tables here
        if (allTables == null) {
            allTables = new ArrayList<>();
            // Add some sample tables
            allTables.add(new Table(1,"table one"));
            allTables.add(new Table(2,"table tow"));
            allTables.add(new Table(3,"table three"));
        }
        return allTables;
    }
        @Override
     public String toString() {
        return "Table " + TableNumber ;
    }
}
