package javaapplication4;


public class Supplier implements Comparable<Supplier> {
	
	private int soldPrice;
	
	Supplier(int soldPrice ){
		this.soldPrice = soldPrice;
	}
	
        @Override
	public int compareTo(Supplier other) {
	       if(this.getsoldPrice() > other.getsoldPrice())
	    	   return 1;
	       else if (this.getsoldPrice() == other.getsoldPrice())
	    	   return 0;
	       return -1;
	}
	
	public int getsoldPrice() {
		return this.soldPrice;
	}
	
}
