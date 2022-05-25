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
 *         Contains methods for food type classes to override
 * 
 */
public interface FoodType
{
	// Gets the stock of the product
	public int getStock();
	
	// Gets the product name
	public String getProductName();

	// Gets the product name and type
	public String getProduct();

	// Gets the product UPC
	public int getUPC();

	// Lowers the stock of the product by 1
	public void soldProduct();

}
