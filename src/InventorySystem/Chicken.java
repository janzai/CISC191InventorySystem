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
 *         Marker class for Chicken objects
 * 
 */
// Chicken IS A Meat
public class Chicken extends Meat
{
	public Chicken(String name, int UPC, int stock)
	{
		super(name, UPC, stock);
	}

	@Override
	public String getProduct()
	{
		return this.getClass().getSimpleName() + " " + this.getProductName();
	}
}
