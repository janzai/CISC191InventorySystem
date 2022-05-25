package InventorySystem;

import java.awt.event.*;
import javax.swing.*;

public class ShutdownButtonListener implements ActionListener
{
	private InventoryModel model;
	private InventoryView view;
	private JButton button;

	public ShutdownButtonListener(InventoryModel model, InventoryView view,
			JButton button)
	{
		this.model = model;
		this.view = view;
		this.button = button;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		InventoryModel.shutdown();
	}
}
