package InventorySystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class InventoryView extends JFrame
{
	private JPanel checkoutPanel;
	private JLabel checkoutLabel;
	private JLabel checkoutUPCLabel;
	private JTextField checkoutUPCEntryBox;
	private JLabel amountLabel;
	private JTextField amountEntryBox;
	private JButton checkoutButton;
	private JTextArea checkoutInfoLabel;

	private JPanel checkStockPanel;
	private JLabel checkStockLabel;
	private JLabel checkStockUPCLabel;
	private JTextField checkStockUPCEntryBox;
	private JButton checkStockButton;
	private JTextArea checkStockInfoLabel;

	private JPanel bottomPanel;
	private JButton uploadStockListButton;
	private JButton shutdownButton;

	final int WINDOW_WIDTH = 400;
	final int WINDOW_HEIGHT = 400;

	public InventoryView(InventoryModel model)
	{

		setLayout(new BorderLayout());

		setTitle("Inventory System");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		checkoutPanel = new JPanel();
		checkoutPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		checkoutLabel = new JLabel("Checkout");
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		checkoutPanel.add(checkoutLabel, c);

		checkoutUPCLabel = new JLabel("Enter Product UPC:");
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		checkoutPanel.add(checkoutUPCLabel, c);

		checkoutUPCEntryBox = new JTextField(10);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		checkoutPanel.add(checkoutUPCEntryBox, c);

		amountLabel = new JLabel("Enter Amount:");
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		checkoutPanel.add(amountLabel, c);

		amountEntryBox = new JTextField(5);
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		checkoutPanel.add(amountEntryBox, c);

		checkoutButton = new JButton("Checkout");
		checkoutButton.addActionListener(
				new CheckoutButtonListener(this));
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		checkoutPanel.add(checkoutButton, c);

		checkoutInfoLabel = new JTextArea(3, 1);
		;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 5;
		checkoutPanel.add(checkoutInfoLabel, c);

		add(checkoutPanel, BorderLayout.WEST);

		checkStockPanel = new JPanel();
		checkStockPanel.setLayout(new GridBagLayout());

		checkStockLabel = new JLabel("Check Stock");
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		checkStockPanel.add(checkStockLabel, c);

		checkStockUPCLabel = new JLabel("Enter Product UPC:");
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		checkStockPanel.add(checkStockUPCLabel, c);

		checkStockUPCEntryBox = new JTextField(10);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		checkStockPanel.add(checkStockUPCEntryBox, c);

		checkStockButton = new JButton("Check Stock");
		checkStockButton.addActionListener(
				new CheckStockButtonListener(this));
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		checkStockPanel.add(checkStockButton, c);

		checkStockInfoLabel = new JTextArea(3, 1);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		checkStockPanel.add(checkStockInfoLabel, c);

		add(checkStockPanel, BorderLayout.EAST);

		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridBagLayout());

		uploadStockListButton = new JButton("Upload Stocklist");
		uploadStockListButton
				.addActionListener(new UploadStockListButtonListener());
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		bottomPanel.add(uploadStockListButton, c);

		shutdownButton = new JButton("Shutdown");
		shutdownButton.addActionListener(
				new ShutdownButtonListener());
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		bottomPanel.add(shutdownButton, c);

		add(bottomPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	public int getCheckoutUPCEntryBox()
	{
		return Integer.parseInt(checkoutUPCEntryBox.getText());
	}

	public int getCheckStockUPCEntryBox()
	{
		return Integer.parseInt(checkStockUPCEntryBox.getText());
	}

	public int getAmountEntryBox()
	{
		return Integer.parseInt(amountEntryBox.getText());
	}

	public static void main(String[] args)
	{
		new InventoryView(new InventoryModel());
	}

	public static void stockListNotFound()
	{
		JOptionPane.showMessageDialog(null,
				"Could not find stock file, please upload new inventory. Please ensure new file is named \"StockListNew\"");
	}
	
	public static void stockListUploaded()
	{
		JOptionPane.showMessageDialog(null, "Stock list uploaded");
	}

	public void updateCheckoutInfoLabel(String product)
	{
		if (product == null)
		{
			JOptionPane.showMessageDialog(null, "UPC not found");
		}
		else
		{
			String productName;
			int stock;
			Scanner scanner = new Scanner(product);

			productName = scanner.next() + " " + scanner.next();
			stock = scanner.nextInt();

			checkoutInfoLabel.setText("Sold " + amountEntryBox.getText() + "\n"
					+ productName + "\n" + stock + " left");

			scanner.close();
		}
	}

	public void updateCheckStockInfoLabel(String product)
	{
		if (product == null)
		{
			JOptionPane.showMessageDialog(null, "UPC not found");
		}
		else
		{
			String productName;
			int stock;
			Scanner scanner = new Scanner(product);

			productName = scanner.next() + " " + scanner.next();
			stock = scanner.nextInt();

			checkStockInfoLabel
					.setText("Stock of: \n" + productName + ": " + stock);

			scanner.close();
		}
	}

}
