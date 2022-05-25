package InventorySystem;

import java.awt.event.*;

public class ShutdownButtonListener implements ActionListener
{
	
	public void actionPerformed(ActionEvent e)
	{
		InventoryModel.shutdown();
	}
}
