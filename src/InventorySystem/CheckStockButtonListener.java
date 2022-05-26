package InventorySystem;

import java.awt.event.*;
import javax.swing.*;

/**
 * Lead Author(s):
 * 
 * @author Theodore Van Berlo
 * @author Jamie Anzai
 * 
 *         Version/date: v.1 5/25/2022
 * 
 *         Responsibilities of class:
 *         Contains the needed method and variable for an action listener for a
 *         checkstock button
 * 
 */

// CheckStockButtonLisenter IS A ActionListener
public class CheckStockButtonListener implements ActionListener
{
	// CheckStockButtonListener HAS A view
	private InventoryView view;

	/**
	 * Constructor
	 * 
	 * @param view
	 */
	public CheckStockButtonListener(InventoryView view)
	{
		this.view = view;
	}

	/**
	 * Catches the button event and calls the correct methods for checking stock
	 */
	public void actionPerformed(ActionEvent event)
	{
		// Declares and initializes a blank string
		String product = "";

		
		try
		{
			// Calls the checkStock method, passing the UPC in the entry box as
			// a parameter
			// Assigns the returned string to product
			product = InventoryModel
					.checkStock(view.getCheckStockUPCEntryBox());
		}
		// Catches any exceptions 
		catch (Exception e)
		{
			// Creates an error message if the input is invalid
			JOptionPane.showMessageDialog(null,
					"Input blank or not an integer");
			// Returns to prevent the info label from updating
			return;
		}
		
		//Calls the updateCheckStockInfoLabel method 
		view.updateCheckStockInfoLabel(product);
	}
}
