package InventorySystem;

import java.awt.event.*;
import javax.swing.*;

public class UploadStockListButtonListener implements ActionListener
{
	private InventoryModel model;
	private InventoryView view;
	private JButton button;

	public UploadStockListButtonListener(InventoryModel model, InventoryView view,
			JButton button)
	{
		this.model = model;
		this.view = view;
		this.button = button;
	}

	public void actionPerformed(ActionEvent event)
	{
			InventoryModel.stockList("StockListNew");
			InventoryView.stockListUploaded();
	}
}
