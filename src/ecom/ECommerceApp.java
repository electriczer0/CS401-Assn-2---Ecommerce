package ecom;

import ecom.Products.*;
import ecom.Cart.*;


import java.util.Scanner;
/**
 * Primary user interface class simulates an e-commerce shopping experience
 * User is allowed to browse product catalog, and add items to cart with arbitrary quantity
 * they can then view the cart, add or delete cart line items, and "checkout." 
 * When they are done, the user can choose to exit the program. 
 *
 */
public class ECommerceApp {

	private  ECommerceApp() {}
	private static ShoppingCart userCart = new ShoppingCart(); 
	private static Scanner userIn = new Scanner(System.in);
	
	/**
	 * Presents the user with a menu of options
	 * loops until a valid integer is returned.
	 * NOTE: integer is NOT checked against menu choices
	 * for validity. THe validity check is provided by the 
	 * caller. 
	 * 
	 * @return the user input integer
	 * 
	 */
	private static int getAction() {
		
		
		int selection=0; 
		boolean validInput = false;
		String menuOptions = """
				Please select an option. 
				1) Display Catalog.
				2) Show Item Details.
				3) Show Cart.
				4) Add an Item to Your Cart. 
				5) Remove an Item from your Cart. 
				6) Checkout. 
				7) Exit. 
				""";
		System.out.println(menuOptions);
		
		while(!validInput) {
			try {
				selection = userIn.nextInt();
				validInput = true;
			} catch (Exception e) {
				System.out.println("Invalid Entry!");
				userIn.next(); //clears the invalid input
			}
		}
		
		return selection;
		
				
	}
	/**
	 * User interface for adding an item to a cart. 
	 * Prompts the user to enter an item no. 
	 * loops until a valid integer is entered. 
	 * Prompts for a desired quantity. 
	 * Loops until a valid integer is entered. 
	 * 
	 * NOTE: function does NOT provide error checking on the
	 * two input integers, this is expected to be completed by 
	 * userCart.addLine().
	 * 
	 * Calls userCart.addLine() to actually add the item. 
	 */
	public static void addItem() {
		
		
		boolean validEntry = false;
		
		int itemNo = -1;
		int quantity = -1; 
		System.out.print("Enter Item No: ");
		while(!validEntry) {
			try {
				itemNo = userIn.nextInt();
				validEntry = true;
			} catch (Exception e) {
				System.out.println("Invalid Entry!");
				userIn.next(); //clear erroneous entry
			}
		}
		System.out.println();
		System.out.print("Enter Desired Quantity: ");
		
		validEntry = false;
		while(!validEntry) {
			try {
				quantity = userIn.nextInt();
				validEntry = true;
			} catch (Exception e) {
				System.out.println("Invalid Entry!");
				userIn.next(); //clear erroneous entry
			}
		}
		
		System.out.println();
		userCart.addLine(itemNo, quantity);
		
	}
	/**
	 * User interface for deleting an item from the cart.
	 * Prompts the user to enter a cart line no and then
	 * loops until a valid int is entered. 
	 * Calls userCart.delLine() to actually delete the line. 
	 * 
	 * NOTE: this method does NOT actually check if the provided
	 * int is a valid lineNo. This validation is provided by 
	 * ShoppingCart.delLine()
	 */
	public static void delItem() {
		
		boolean validEntry = false;
		int lineNo = -1;
		
		System.out.print("Enter ShoppingCart Line No: ");
		while(!validEntry) {
			try {
				lineNo = userIn.nextInt();
				validEntry = true;
			} catch (Exception e) {
				System.out.println("Invalid Entry!");
				userIn.next(); //clear invalid entry
			}
		}
		
		System.out.println();
		userCart.delLine(lineNo);
	}
	/**
	 * Simulates the user interface for checking out a cart. 
	 * Returns a confirmation message to the user. 
	 * Abandons the old cart and generates a fresh cart 
	 * which can be used for new purchases. 
	 */
	public static void checkOut() {
		

		System.out.println("Thank You! Your account has been charged.");
		userCart = new ShoppingCart();
	}
	/**
	 * Provides user interface through which the user can 
	 * request full details for a specific product
	 * Prompts user for an Item No and then loops until a valid 
	 * int is provided. 
	 * 
	 * Looks up the itemNo in the Product class and if it is found
	 * then calls printDetails() to show details for that item; 
	 *  
	 */
	public static void getDetails() {
		
		boolean validEntry = false;
		int itemNo = -1;
		Product foundItem = null;
		
		System.out.print("Enter Item No: ");
		while(!validEntry) {
			try {
				itemNo = userIn.nextInt();
				validEntry = true;
			} catch (Exception e) {
				System.out.println("Invalid Entry!");
				userIn.next(); //clear invalid entry
			}
		}
		
		System.out.println();
		foundItem = Product.lookupItem(itemNo);
		if(foundItem != null) {
			foundItem.printDetails();
		} else {
			System.out.println("Item not Found!");
		}
	}
	public static void main(String[] args) {
		//Generate product library:
		
		new Product("Book", (float) 12.55);
		new Product("Calculator", (float) 25.32);
		new Book("For Whom the Bell Tolls", (float) 22.45, "Ernest Hemingway", "Literature");
		new Electronics("Flatscreen TV", (float) 1486.99, "Samsung", 4);
		new Clothing("Tshirt", (float) 19.99, "XL", "Cotton");
		

		
		System.out.println("Welcome to our online Store!");
		
		/*
		 * Primary user interface. Calls appropriate method based on user input
		 * Catches integers not provided by the menu and prompts for new input. 
		 */
		
		interfaceLoop:
		while(true) {
			System.out.println();
			switch(getAction()) {
				case 1: //Display Catalog
					Product.print()	;
					break;
				case 2: //Show product details from item no. 
					getDetails();
					break;
				case 3: //Show ShoppingCart
					userCart.printCart();
					break;
				case 4: //Add item to cart
					addItem();
					break;
				case 5: //Remove item from cart
					delItem();
					break;
				case 6: //Check out
					checkOut();
					break;
				case 7: //Exit
					break interfaceLoop;
				default:
					System.out.println("Invalid Entry!");
					break;
				
			}
		}

		//release the user interface scanner
		userIn.close();
		
	}

}
