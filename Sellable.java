
abstract class Sellable implements  Pricable {
	
	protected String name;
	protected float price;
	protected int quantity =0;
	
	public String getName() {
		return this.name;
	}
	
	public float getPrice() { return this.price * this.getQuantity(); }
	
	public void changePrice(float newPrice) {
		this.price = newPrice;
	}

	public int getQuantity() {
		return this.quantity;
	}
	
	public int compareTo(Pricable other) {
		   if( this.getPrice() > other.getPrice() )
			   return 1;
	       else if ( this.getPrice() == other.getPrice())
	    	   return 0;
	       return -1;
	}
	
}
