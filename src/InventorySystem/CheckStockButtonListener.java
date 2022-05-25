package InventorySystem;

import java.awt.event.*;
import javax.swing.*;

public class CheckStockButtonListener implements ActionListener
{
	private InventoryModel model;
	private InventoryView view;
	private JButton button;

	public CheckStockButtonListener(InventoryModel model, InventoryView view,
			JButton button)
	{
		this.model = model;
		this.view = view;
		this.button = button;
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
