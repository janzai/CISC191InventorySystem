package InventorySystem;

import java.util.Scanner;
import java.io.*;

/**
 * Lead Author(s):
 * 
 * @author Theodore Van Berlo
 * @author Jamie Anzai
 * 
 *         Version/date: v.1 4/8/2022
 * 
 *         Responsibilities of class:
 *         Contains the main method for the program
 *         Contains variables and methods required for maintaining a grocery
 *         store inventory
 * 
 */
public class InventoryModel
{
	private static FoodType[][][] foodTypeArray;

	public InventoryModel()
	{
		foodTypeArray = InventoryModel.stockList("StockListCurrent");
	}

	/**
	 * Purpose: Allows user to call the soldProduct method on an object in the
	 * array, lowering the stock count of the product by 1
	 * 
	 * @param foodTypeArray[FoodType][ProductType][Product]
	 */
	public static String checkout(int UPC, int amount)
	{
		int amountToSell = amount;
		int upcToSell = UPC;

		// Three for loops to search the array
		for (int foodType = 0; foodType < foodTypeArray.length; foodType++)
		{
			for (int productType = 0; productType < foodTypeArray[foodType].length; productType++)
			{
				for (int product = 0; product < foodTypeArray[foodType][productType].length; product++)
				{
					// Conditional to check if the current object's UPC matches
					// the input UPC
					if (upcToSell == foodTypeArray[foodType][productType][product]
							.getUPC())
					{
						// Calls soldProduct method on the current object a
						// given amount of times
						for (int sellTimes = 0; sellTimes < amountToSell; sellTimes++)
						{
							foodTypeArray[foodType][productType][product]
									.soldProduct();
						}

						return foodTypeArray[foodType][productType][product]
								.getProduct() + " "
								+ foodTypeArray[foodType][productType][product]
										.getStock();
					}

				}

			}

		}
		return null;

	}

	/**
	 * Purpose: Allows user to check the stock level of a certain object in the
	 * FoodType array
	 *
	 * @param foodTypeArray[FoodType][ProductType][Product]
	 */
	public static String checkStock(int UPC)
	{
		int upcToCheck = UPC;

		// Three for loops to search the array
		for (int foodType = 0; foodType < foodTypeArray.length; foodType++)
		{
			for (int productType = 0; productType < foodTypeArray[foodType].length; productType++)
			{
				for (int product = 0; product < foodTypeArray[foodType][productType].length; product++)
				{
					// Conditional to check if the current object's UPC matches
					// the input UPC
					if (upcToCheck == foodTypeArray[foodType][productType][product]
							.getUPC())
					{
						// Returns the current objects name and stock
						return foodTypeArray[foodType][productType][product]
								.getProduct() + " "
								+ foodTypeArray[foodType][productType][product]
										.getStock();
					}

				}

			}

		}
		// Checks to see if the input UPC was found in the array
		// 0 means UPC was not found
		return null;

	}

	/**
	 * Purpose: Takes a text file of all the information and puts it into the
	 * FoodType array
	 * 
	 * @param fileName name of file to open
	 * @return foodTypeArray[FoodTypes][ProductTypes][Products]
	 */
	public static FoodType[][][] stockList(String fileName)
	{
		// Creates file object
		File file;
		// Creates Scanner object allowing scope throughout entire method
		Scanner reader = null;
		// Creates the foodTypeArray with known array sizes
		FoodType[][][] foodTypeArray = new FoodType[4][2][3];

		try
		{
			// Opens the file of the given fileName
			file = new File(fileName);
			// Wraps the file object in a scanner for reading the file
			reader = new Scanner(file);
		}
		// Catches error if file was not found
		catch (FileNotFoundException e)
		{
			// Prints out the error
			System.out.println(e);
			// Checks if the program was looking for the current stock list
			if (fileName.equals("StockListCurrent"))
			{
				// Could not find StockListCurrent, searching for StockListNew
				// Calls the method again, passing StockListNew to see if that
				// file exists
				foodTypeArray = stockList("StockListNew");
				// Only will happen if StockListNew is found because program
				// will exit otherwise
				
				// Return foodTypeArray, exiting the method so it does not try
				// to read from the missing file
				return foodTypeArray;
			}
			// Will enter else statement if couldn't find StockListNew
			else
			{
				InventoryView.stockListNotFound();
				System.exit(0);
			}
		}
		// Creates all the necessary arrays for all objects
		// Inventory HAS MANY Steaks
		Meat[] steakArray = new Meat[3];
		// Inventory HAS MANY Chicken products
		Meat[] chickenArray = new Meat[3];
		// Inventory HAS MANY Meats
		Meat[][] meatArray = new Meat[2][3];

		// Inventory HAS MANY Milks
		Dairy[] milkArray = new Dairy[3];
		// Inventory HAS MANY Cheeses
		Dairy[] cheeseArray = new Dairy[3];
		// Inventory HAS MANY Dairies
		Dairy[][] dairyArray = new Dairy[2][3];

		// Inventory HAS MANY Apples
		Produce[] appleArray = new Produce[3];
		// Inventory HAS MANY Grapes
		Produce[] grapeArray = new Produce[3];
		// Inventory HAS MANY Produce products
		Produce[][] produceArray = new Produce[2][3];

		// Inventory HAS MANY Pastas
		General[] pastaArray = new General[3];
		// Inventory HAS MANY Soups
		General[] soupArray = new General[3];
		// Inventory HAS MANY General products
		General[][] generalArray = new General[2][3];

		// Holds the name of the object (eg Ribeye)
		String name = "";
		// Holds the type of product (eg Steak)
		String product = "";
		int upc = 0;
		int stock = 0;
		// Holds the amount of types of product (eg 2 Meat products)
		int typeAmount = 0;
		// Holds the amount of product names (eg 3 Steak names)
		int productAmount = 0;

		// Loops if there is more to read in the text file
		while (reader.hasNext())
		{
			// Skips the type in the file
			reader.next();
			// Assigns typeAmount to the next int in the file
			typeAmount = reader.nextInt();

			// For loop that loops through the types of food
			// Stops at given typeAmount
			for (int foodType = 0; foodType < typeAmount; foodType++)
			{
				// Assigns product to the next String in the file
				product = reader.next();
				// Assigns productAmount to the next int in the file
				productAmount = reader.nextInt();

				// For loop that loops through the types of product
				// Stops at given productAmount
				for (int productType = 0; productType < productAmount; productType++)
				{
					// Assigns name to the next String in the file
					name = reader.next();
					// Assigns upc to the next int in the file
					upc = reader.nextInt();
					// Assigns stock to the next int in the file
					stock = reader.nextInt();

					switch (product)
					{
						// Checks if the current product is a Steak
						case "Steak":

							// Creates a new steak object and assigns it to the
							// current array index
							steakArray[productType] = new Steak(name, upc,
									stock);
							// Assigns the current steakArray index to the
							// current
							// meatArray index
							meatArray[foodType][productType] = steakArray[productType];
							break;

						// Checks if the current product is a Chicken
						case "Chicken":

							// Creates a new Chicken object and assigns it to
							// the
							// current array index
							chickenArray[productType] = new Chicken(name, upc,
									stock);
							// Assigns the current chickenArray index to the
							// current
							// meatArray index
							meatArray[foodType][productType] = chickenArray[productType];
							break;

						// Checks if the current product is a Milk
						case "Milk":

							// Creates a new Milk object and assigns it to the
							// current array index
							milkArray[productType] = new Milk(name, upc, stock);
							// Assigns the current milkArray index to the
							// current
							// dairyArray index
							dairyArray[foodType][productType] = milkArray[productType];
							break;

						// Checks if the current product is a Cheese
						case "Cheese":

							// Creates a new Cheese object and assigns it to the
							// current array index
							cheeseArray[productType] = new Cheese(name, upc,
									stock);
							// Assigns the current cheeseArray index to the
							// current
							// dairyArray index
							dairyArray[foodType][productType] = cheeseArray[productType];
							break;

						// Checks if the current product is a Apple
						case "Apple":

							// Creates a new Apple object and assigns it to the
							// current array index
							appleArray[productType] = new Apple(name, upc,
									stock);
							// Assigns the current appleArray index to the
							// current
							// produceArray index
							produceArray[foodType][productType] = appleArray[productType];
							break;

						// Checks if the current product is a Grape
						case "Grape":

							// Creates a new Grape object and assigns it to the
							// current array index
							grapeArray[productType] = new Grape(name, upc,
									stock);
							// Assigns the current grapeArray index to the
							// current
							// produceArray index
							produceArray[foodType][productType] = grapeArray[productType];
							break;

						// Checks if the current product is a Pasta
						case "Pasta":

							// Creates a new Pasta object and assigns it to the
							// current array index
							pastaArray[productType] = new Pasta(name, upc,
									stock);
							// Assigns the current pastaArray index to the
							// current
							// generalArray index
							generalArray[foodType][productType] = pastaArray[productType];
							break;
						// Checks if the current product is a Soup
						case "Soup":
							// Creates a new Soup object and assigns it to the
							// current array index
							soupArray[productType] = new Soup(name, upc, stock);
							// Assigns the current soupArray index to the
							// current
							// generalArray index
							generalArray[foodType][productType] = soupArray[productType];
							break;
					}
				}
			}
		}
		// Closes the reader and file
		reader.close();

		// Assigns each product type array to an index in the 3D foodTypeArray
		foodTypeArray[0] = meatArray;
		foodTypeArray[1] = dairyArray;
		foodTypeArray[2] = produceArray;
		foodTypeArray[3] = generalArray;
		
		// returns the array
		return foodTypeArray;
	}

	/**
	 * Purpose: Saves the updated information to the text file and shuts down
	 * 
	 * @param foodTypeArray[FoodTypes][ProductTypes][Products]
	 */
	public static void shutdown()
	{
		// Creates file object
		File file;
		// Creates PrinterWriter object
		PrintWriter writer = null;

		try
		{
			// Opens the file StockList or creates the file if it does not exist
			file = new File("StockListCurrent");
			// Wraps the file in a PrintWriter object for writing
			writer = new PrintWriter(file);
		}
		// Catches an error if the file was not found
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}

		// For loop that iterates through the food types (the first 'row')
		for (int foodType = 0; foodType < foodTypeArray.length; foodType++)
		{
			// Since the first 'row' of the foodTypeArray will always be the
			// product type arrays (eg meatArray), and will always be in order,
			// use the i index of the array to write the correct product type
			// and amount to the file
			if (foodType == 0)
			{
				writer.println("Meat " + foodTypeArray[foodType].length);
			}
			if (foodType == 1)
			{
				writer.println("Dairy " + foodTypeArray[foodType].length);
			}
			if (foodType == 2)
			{
				writer.println("Produce " + foodTypeArray[foodType].length);
			}
			if (foodType == 3)
			{
				writer.println("General " + foodTypeArray[foodType].length);
			}

			// Second for loop that iterates through the product types
			for (int productType = 0; productType < foodTypeArray[foodType].length; productType++)
			{
				// Gets the simple name of the object class (eg Steak), and the
				// length of the product array (eg steakArray), and writes them
				// to the file. Uses 0 for the last index in foodTypeArray to
				// get the name of the correct class, since all objects in the
				// array will have the same class.
				writer.println(foodTypeArray[foodType][productType][0]
						.getClass().getSimpleName() + " "
						+ foodTypeArray[foodType][productType].length);
				// Third for loop that iterates through the products in the
				// array
				for (int product = 0; product < foodTypeArray[foodType][productType].length; product++)
				{
					// Writes the productName, UPC, and stock to the file
					writer.println(foodTypeArray[foodType][productType][product]
							.getProductName()
							+ " "
							+ foodTypeArray[foodType][productType][product]
									.getUPC()
							+ " "
							+ foodTypeArray[foodType][productType][product]
									.getStock());
				}
			}
		}
		// Flushes the writer
		writer.flush();
		// Closes the writer
		writer.close();

		System.exit(0);
	}

}
