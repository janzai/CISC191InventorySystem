package InventorySystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Lead Author(s):
 * 
 * @author Theodore Van Berlo
 * @author Jamie Anzai
 * 
 *         References:
 *         https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
 * 
 *         Version/date: v.1 5/25/2022
 * 
 *         Responsibilities of class:
 *         Contains the variables and methods required to create and update a
 *         GUI for a grocery store inventory system
 * 
 */

// InventoryView IS A JFrame
public class InventoryView extends JFrame
{
	// InventoryView HAS A checkoutPanel
	private JPanel checkoutPanel;
	// InventoryView HAS A checkoutLabel
	private JLabel checkoutLabel;
	// InventoryView HAS A checkoutUPCLabel
	private JLabel checkoutUPCLabel;
	// InventoryView HAS A checkoutUPCEntryBox
	private JTextField checkoutUPCEntryBox;
	// InventoryView HAS A amountLabel
	private JLabel amountLabel;
	// InventoryView HAS A amountEntryBox
	private JTextField amountEntryBox;
	// InventoryView HAS A checkoutButton
	private JButton checkoutButton;
	// InventoryView HAS A checkoutInfoLabel
	private JTextArea checkoutInfoLabel;

	// InventoryView HAS A checkStockPanel
	private JPanel checkStockPanel;
	// InventoryView HAS A checkStockLabel
	private JLabel checkStockLabel;
	// InventoryView HAS A checkStockUPCLabel
	private JLabel checkStockUPCLabel;
	// InventoryView HAS A checkStockUPCEntryBox
	private JTextField checkStockUPCEntryBox;
	// InventoryView HAS A checkStockButton
	private JButton checkStockButton;
	// InventoryView HAS A checkSTockInfoLabel
	private JTextArea checkStockInfoLabel;

	// InventoryView HAS A bottomPanel
	private JPanel bottomPanel;
	// InventoryView HAS A uploadStockListButton
	private JButton uploadStockListButton;
	// InventoryView HAS A shutdownButton
	private JButton shutdownButton;

	// InventoryView HAS A WINDOW_WIDTH
	final int WINDOW_WIDTH = 400;
	// InventoryView HAS A WINDOW_HEIGHT
	final int WINDOW_HEIGHT = 400;

	/**
	 * Constructor for the inventory view
	 * 
	 * @param model
	 */
	public InventoryView(InventoryModel model)
	{
		// Sets the main panel to border layout
		setLayout(new BorderLayout());

		setTitle("Inventory System");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sets the window size using the final variables
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Creates a checkout panel
		checkoutPanel = new JPanel();
		// Sets checkout panel to a GridBagLayout
		checkoutPanel.setLayout(new GridBagLayout());
		// Creates a constraints variable for grid bag components
		GridBagConstraints c = new GridBagConstraints();

		// Creates a checkout label with the given text
		checkoutLabel = new JLabel("Checkout");
		// Sets the font of the checkoutLabel
		checkoutLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		// Sets the width of the component to 2 boxes
		c.gridwidth = 2;
		// Sets the x coordinate of the component to 0 in the grid bag
		c.gridx = 0;
		// Sets the y coordinate of the component to 0 in the grid bag
		c.gridy = 0;
		// Adds the checkout label to the checkout panel
		checkoutPanel.add(checkoutLabel, c);

		// Creates a checkout upc label with the given text
		checkoutUPCLabel = new JLabel("Enter Product UPC:");
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		checkoutPanel.add(checkoutUPCLabel, c);

		// Creates a JTextField for the UPC
		checkoutUPCEntryBox = new JTextField(10);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		checkoutPanel.add(checkoutUPCEntryBox, c);

		// Creates an amount label with the given text
		amountLabel = new JLabel("Enter Amount:");
		// Sets the gridwidth to 1 to allow for the amountEntryBox next to it
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		checkoutPanel.add(amountLabel, c);

		// Creates a JTextField for the amount
		amountEntryBox = new JTextField(5);
		// Sets the gridwidth to 1 to allow for the amountLabel next to it
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		checkoutPanel.add(amountEntryBox, c);

		// Creates a JButton with a label on it
		checkoutButton = new JButton("Checkout");
		// Adds the CheckoutButtonListener to the checkoutButton
		checkoutButton.addActionListener(new CheckoutButtonListener(this));
		// Sets the gridwidth to 2 again
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		checkoutPanel.add(checkoutButton, c);

		// Creates a JTextArea that is 3 rows and 1 column
		checkoutInfoLabel = new JTextArea(3, 1);
		// Sets the color of the checkoutInfoLabel background to the same color
		// as the checkoutPanel background
		checkoutInfoLabel.setBackground(checkoutPanel.getBackground());
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 5;
		checkoutPanel.add(checkoutInfoLabel, c);

		// Adds the checkout panel to the west region
		add(checkoutPanel, BorderLayout.WEST);

		// Creates a new check stock panel
		checkStockPanel = new JPanel();
		// Sets the check stock panel layout to grid bag
		checkStockPanel.setLayout(new GridBagLayout());

		// Creates a check stock label with the given text
		checkStockLabel = new JLabel("Check Stock");
		// Sets the font of the checkStockLabel
		checkStockLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		checkStockPanel.add(checkStockLabel, c);

		// Creates a check stock UPC label with the given text
		checkStockUPCLabel = new JLabel("Enter Product UPC:");
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		checkStockPanel.add(checkStockUPCLabel, c);

		// Creates a check stock UPC entry box with the given text
		checkStockUPCEntryBox = new JTextField(10);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		checkStockPanel.add(checkStockUPCEntryBox, c);

		// Creates a check stock button with the given text
		checkStockButton = new JButton("Check Stock");
		// Adds the CheckStockButtonListener to the checkStockButton
		checkStockButton.addActionListener(new CheckStockButtonListener(this));
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		checkStockPanel.add(checkStockButton, c);

		// Creates a JTextArea with 3 rows and 1 column
		checkStockInfoLabel = new JTextArea(3, 1);
		// Sets the color of the checkStockInfoLabel background to the same color
		// as the checkStockPanel background
		checkStockInfoLabel.setBackground(checkStockPanel.getBackground());
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		checkStockPanel.add(checkStockInfoLabel, c);

		// Adds the checkStockPanel to the east region
		add(checkStockPanel, BorderLayout.EAST);

		// Creates a new bottom panel
		bottomPanel = new JPanel();
		// Sets the bottom panel layout to grid bag
		bottomPanel.setLayout(new GridBagLayout());

		// Creates a new upload stocklist button with the given text
		uploadStockListButton = new JButton("Upload Stocklist");
		// Adds the UploadStockListButtonListener to the uploadStockListButton
		uploadStockListButton
				.addActionListener(new UploadStockListButtonListener());
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		bottomPanel.add(uploadStockListButton, c);

		// Creates a new shutdown button with the given text
		shutdownButton = new JButton("Shutdown");
		// Sets the color of the shutdownButton text to red
		shutdownButton.setForeground(Color.red);
		// Adds the ShutdownButtonListener to the shutdownButton
		shutdownButton.addActionListener(new ShutdownButtonListener());
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		bottomPanel.add(shutdownButton, c);

		// Adds the bottomPanel to the south region
		add(bottomPanel, BorderLayout.SOUTH);

		// sets the window to visible
		setVisible(true);
	}

	/**
	 * Gets the text in the CheckoutUPCEntryBox
	 * 
	 * @return The integer in the field
	 */
	public int getCheckoutUPCEntryBox()
	{
		// Returns the text in the field as an integer
		return Integer.parseInt(checkoutUPCEntryBox.getText());
	}

	/**
	 * Gets the text in the CheckStockUPCEntryBox
	 * 
	 * @return The integer in the field
	 */
	public int getCheckStockUPCEntryBox()
	{
		// Returns the text in the field as an integer
		return Integer.parseInt(checkStockUPCEntryBox.getText());
	}

	/**
	 * Gets the text in the amountEntryBox
	 * 
	 * @return The integer in the field
	 */
	public int getAmountEntryBox()
	{
		// Returns the text in the field as an integer
		return Integer.parseInt(amountEntryBox.getText());
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Creates a new InventoryView object and passes a new InventoryModel as
		// the parameter
		new InventoryView(new InventoryModel());
	}

	/**
	 * Creates an error message for when a current or new stock file could not
	 * be found
	 */
	public static void stockListNotFound()
	{
		JOptionPane.showMessageDialog(null,
				"Could not find stock file, please upload new inventory. Please ensure new file is named \"StockListNew\"");
	}

	/**
	 * Creates a message for when the stock list was successfully uploaded
	 */
	public static void stockListUploaded()
	{
		JOptionPane.showMessageDialog(null, "Stock list uploaded");
	}

	/**
	 * Updates the checkout info label when a product is sold
	 * 
	 * @param product information
	 */
	public void updateCheckoutInfoLabel(String product)
	{
		// Checks if the given product is null, indicating the UPC was not found
		if (product == null)
		{
			// Creates an error message
			JOptionPane.showMessageDialog(null, "UPC not found");
		}
		else
		{
			String productName;
			int stock;
			// Creates a scanner for parsing the information from the product
			// string
			Scanner scanner = new Scanner(product);

			// Grabs the first two tokens from the product string which will be
			// the product type and name
			productName = scanner.next() + " " + scanner.next();
			// Grabs the third token from the product string which will be the
			// stock level
			stock = scanner.nextInt();

			// Sets the text of the checkoutInfoLabel using the parsed
			// information
			checkoutInfoLabel.setText("Sold " + amountEntryBox.getText() + "\n"
					+ productName + "\n" + stock + " left");

			scanner.close();
		}
	}

	/**
	 * Updates the check stock info label
	 * 
	 * @param product information
	 */
	public void updateCheckStockInfoLabel(String product)
	{
		// Checks if the given product is null, indicating the UPC was not found
		if (product == null)
		{
			// Creates an error message
			JOptionPane.showMessageDialog(null, "UPC not found");
		}
		else
		{
			String productName;
			int stock;
			// Creates a scanner for parsing the information from the product
			// string
			Scanner scanner = new Scanner(product);

			// Grabs the first two tokens from the product string which will be
			// the product type and name
			productName = scanner.next() + " " + scanner.next();
			// Grabs the third token from the product string which will be the
			// stock level
			stock = scanner.nextInt();

			// Sets the text of the checkStockInfoLabel using the parsed
			// information
			checkStockInfoLabel
					.setText("Stock of: \n" + productName + ": " + stock);

			scanner.close();
		}
	}

}
