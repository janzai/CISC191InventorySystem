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
*         Holds variables required for a meat product type
*         Contains methods needed for getting the stored information
* 
*/

// Meat IS A FoodType
public abstract class Meat implements FoodType
{
	// Meat HAS A name
	private String name;
	// Meat HAS A UPC
	private int UPC;
	// Meat HAS A stock
	private int stock;

	/**
	 * Constructor for creating subclass objects
	 * 
	 * @param name
	 * @param UPC
	 * @param stock
	 */
	public Meat(String name, int UPC, int stock)
	{
		this.name = name;
		this.UPC = UPC;
		this.stock = stock;
	}

	/**
	 * Abstract method to get the product name and type
	 */
	abstract public String getProduct();
	
	/**
	 * Gets the name of the product
	 * 
	 * @return product name
	 */
	public String getProductName()
	{
		return name;
	}

	/**
	 * Gets the UPC of the product
	 * 
	 * @return UPC
	 */
	public int getUPC()
	{
		return UPC;
	}

	/**
	 * Gets the stock of the product
	 * 
	 * @return stock
	 */
	public int getStock()
	{
		return stock;
	}

	/**
	 * Lowers the stock of the product by 1
	 * 
	 */
	public void soldProduct()
	{
		stock--;
	}

}
