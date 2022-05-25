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
 *         Marker class for Dairy objects
 * 
 */
// Cheese IS A Dairy
public class Cheese extends Dairy
{
	public Cheese(String name, int UPC, int stock)
	{
		super(name, UPC, stock);
	}

	@Override
	public String getProduct()
	{
		return this.getProductName() + " " + this.getClass().getSimpleName();
	}

}
