package InventorySystem;

import java.awt.event.*;

/**
 * Lead Author(s):
 * 
 * @author Theodore Van Berlo
 * @author Jamie Anzai
 * 
 *         Version/date: v.1 4/8/2022
 * 
 *         Responsibilities of class:
 *         Contains the needed method for an action listener for a shutdown
 *         button
 * 
 * 
 */

// ShutdownButtonListener IS A ActionListener
public class ShutdownButtonListener implements ActionListener
{

	/**
	 * Catches the button event and calls the correct method for shutdown
	 */
	public void actionPerformed(ActionEvent e)
	{
		// Calls the shutdown method in the InvetoryModel class
		InventoryModel.shutdown();
	}
}
