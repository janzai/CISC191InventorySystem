package InventorySystem;

import java.awt.event.*;

public class UploadStockListButtonListener implements ActionListener
{

	public void actionPerformed(ActionEvent event)
	{
			InventoryModel.stockList("StockListNew");
			InventoryView.stockListUploaded();
	}
}
