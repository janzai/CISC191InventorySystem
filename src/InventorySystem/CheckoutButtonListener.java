package InventorySystem;

import java.awt.event.*;
import javax.swing.*;

public class CheckoutButtonListener implements ActionListener
{
	private InventoryModel model;
	private InventoryView view;
	private JButton button;

	public CheckoutButtonListener(InventoryModel model, InventoryView view,
			JButton button)
	{
		this.model = model;
		this.view = view;
		this.button = button;
	}

	public void actionPerformed(ActionEvent event)
	{
		String product = "";
		
		if (view.getAmountEntryBox() < 1)
		{
			JOptionPane.showMessageDialog(null,
					"Amount to sell cannot be less than 1");
			return;
		}
		
		try
		{
			product = InventoryModel.checkout(view.getCheckoutUPCEntryBox(),
					view.getAmountEntryBox());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,
					"Input blank or not an integer");
			return;
		}

		view.updateCheckoutInfoLabel(product);
	}
}
