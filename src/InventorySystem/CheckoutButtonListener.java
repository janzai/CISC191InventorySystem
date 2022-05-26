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
 *         checkout button
 * 
 */
public class CheckoutButtonListener implements ActionListener
{
	// CheckoutButtonListener HAS-A InventoryView
	private InventoryView view;

	/**
	 * Constructor
	 * 
	 * @param view
	 */
	public CheckoutButtonListener(InventoryView view)
	{
		this.view = view;
	}

	/**
	 * Catches the button event and calls the correct methods for checkout
	 */
	public void actionPerformed(ActionEvent event)
	{
		// Declares and initializes a blank string
		String product = "";
		
		try
		{
			// Checks if the amount in the entry box is less than 1
			if (view.getAmountEntryBox() < 1)
			{
				// Creates an error message if so
				JOptionPane.showMessageDialog(null,
						"Amount to sell cannot be less than 1");
				// Returns to end the method
				return;
			}

			// Calls the checkStock method, passing the UPC in the entry box as
			// a parameter
			// Assigns the returned string to product
			product = InventoryModel.checkout(view.getCheckoutUPCEntryBox(),
					view.getAmountEntryBox());

			// Catches any exceptions
		}
		catch (Exception e)
		{
			// Creates an error message if the input is invalid
			JOptionPane.showMessageDialog(null,
					"Input blank or not an integer");
			// Returns to prevent the info label from updating
			return;
		}

		// Calls the updateCheckoutInfoLabel method
		view.updateCheckoutInfoLabel(product);
	}
}
