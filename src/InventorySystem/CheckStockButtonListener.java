package InventorySystem;

import java.awt.event.*;
import javax.swing.*;

public class CheckStockButtonListener implements ActionListener
{
	private InventoryView view;

	public CheckStockButtonListener(InventoryView view)
	{
		this.view = view;
	}

	public void actionPerformed(ActionEvent event)
	{
		String product = "";

		try
		{
			product = InventoryModel.checkStock(view.getCheckStockUPCEntryBox());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,
					"Input blank or not an integer");
			return;
		}

		view.updateCheckStockInfoLabel(product);
	}
}
