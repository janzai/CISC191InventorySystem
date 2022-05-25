package InventorySystem;
/**
 * Lead Author(s):
 * 
 * @author Theodore Van Berlo
 * @author Jamie Anzai
 * 
 *         Version/date: v.1 4/8/2022
 * 
 *         Responsibilities of class:
 *         Marker class for Meat objects
 * 
 */
// Steak IS A Meat
public class Steak extends Meat
{
	/**
	 * Constructor that creates a Steak object
	 * 
	 * @param name
	 * @param UPC
	 * @param stock
	 */
	public Steak(String name, int UPC, int stock)
	{
		// Passes the given variables to the superclass
		super(name, UPC, stock);
	}

	/**
	 * Gets the product name and type
	 * 
	 * @return String that contains the name and product type
	 */
	@Override
	public String getProduct()
	{
		// Gets the simple name of the class (the product type)
		return this.getProductName() + " " + this.getClass().getSimpleName();
	}

}
