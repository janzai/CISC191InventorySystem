package InventorySystem;

import java.awt.event.*;

/**
 * Lead Author(s):
 * 
 * @author Theodore Van Berlo
 * @author Jamie Anzai
 * 
 *         Version/date: v.1 5/25/2022
 * 
 *         Responsibilities of class:
 *         Contains the needed method for an action listener for an upload stock
 *         button
 * 
 */

// UploadStockListButtonListener IS A ActionListener
public class UploadStockListButtonListener implements ActionListener
{

	/**
	 * Catches the button event and calls the correct method for uploading a
	 * stock list
	 */
	public void actionPerformed(ActionEvent event)
	{
		// Calls the stockList method from the InventoryModel using a new stock
		// list
		InventoryModel.stockList("StockListNew");
		// Creates a message stating the stock list has been uploaded
		InventoryView.stockListUploaded();
	}
}
