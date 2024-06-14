package ecom.Products;

import java.util.ArrayList;
import java.util.List;

/**
 * Product Super class. 
 * Provides common fields and method for all products. 
 * Also includes static fields and methods that are used across products
 * productList is used to serve as a collection of all products; 
 * ie a product catalog
 *
 */
public class Product {
	
	
	protected int productID;
	protected String name; //the name of description of the product
	protected float price;
	protected String productType = "Other";

	
	protected static int nextProductID = 0;	
	protected static List<Product> productList = new ArrayList<>();
	
	/**
	 * @return String Product.name
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * @return int Product.productID
	 */
	public int getID() {
		
		return productID;
	}
	/**
	 * @return float Product.price
	 */
	public float getPrice() {
		
		return price;
	}
	/**
	 * @return String Product.productType
	 */
	public String getType() {
		
		return productType;
	}
	/**
	 * Prints detailed attributes from Product instance to stdout
	 */
	public void printDetails() {
		
		System.out.printf("ID:\t%d\nName:\t%s\nType:\t%s\nPrice:\t$%.2f\n",
				this.getID(), this.getName(), this.getType(), this.getPrice());
		
	}
	/**
	 * Prints a Product instance to stdout as a row
	 * called by static methods which provide header 
	 */
	private void printShort() {
		
		System.out.printf("%10d\t%15.15s\t%15.15s\t$%,9.2f\n", 
				this.getID(), this.getName(), this.getType(), this.getPrice());
		
	}
	/**
	 * Primary product constructor
	 * @param name the name or description of the product
	 * @param price the price of the product
	 */
	public  Product(String name, float price) {
		
		
		this.name = name; 
		this.price = price; 
		
		//assign the next available product ID and then increment 
		this.productID = Product.nextProductID++;

		//add the new product to the static product list
		productList.add(this);
	}
	/**
	 * Prints details for every product to stdout. 
	 */
	public static void listProducts() {
		
		for (Product product: productList) {
			product.printDetails();
		}
	}
	/** Searches the product catalog (productList) for a a product matching
	 * the provided item number. 
	 * 
	 * @param itemNo the item number for which we are searching
	 * @return Product the Product instance which was found or null if not found
	 */
	public static Product lookupItem(int itemNo) {
		
		
		for (Product product: productList) {
			if (product.getID() == itemNo) {
				return product;
			}
		}
		return null; //returns null if item is not found
	}
	/**
	 * Utility function to check if the stated item number exists. 
	 * @param itemNo The requested item number
	 * @return true if found, otherwise false
	 */
	public static boolean exists(int itemNo) {
		
		for (Product product: productList) {
			if (product.getID() == itemNo) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Prints a table listing basic product details for all items in catalog.
	 */
	public static void print() {
		
		System.out.printf("%10s\t%15s\t%15s\t%10s\n", 
				"Product ID", "Description", "Type", "Price");
		for(Product product: productList) {
			product.printShort();
		}
	}
	
			
		
	

}
