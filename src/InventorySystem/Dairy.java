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
*         Holds variables required for a dairy product type
*         Contains methods needed for getting the stored information
* 
*/
// Dairy IS A FoodType
public abstract class Dairy implements FoodType
{
	// Dairy HAS A name
	private String name;
	// Dairy HAS A UPC
	private int UPC;
	// Dairy HAS A stock
	private int stock;

	public Dairy(String name, int UPC, int stock)
	{
		this.name = name;
		this.UPC = UPC;
		this.stock = stock;
	}

	abstract public String getProduct();

	public String getProductName()
	{
		return name;
	}

	public int getUPC()
	{
		return UPC;
	}

	public int getStock()
	{
		return stock;
	}

	public void soldProduct()
	{
		stock--;
	}
}
