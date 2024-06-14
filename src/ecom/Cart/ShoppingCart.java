package ecom.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;



import ecom.Products.Product;
/**
 * Class represents an ecommerce cart. 
 * Includes a private class representing each cart line
 * and an an array representing everything in the cart. 
 * 
 */
public class ShoppingCart {
	
	/**
	 * An Array of all line items which have been added to the cart. 
	 */
	private List<CartLine> cartLines = new ArrayList<>();

	/**
	 * Serial number for CartLine lineNo. Unique to ea ShoppingCart.
	 */
	protected int nextLine = 0; 
	
	/**
	 * The sum total of the extended price from all CartLines
	 * Currently synonymous with grand total, but future versions may add
	 * tax, shipping, etc. 
	 */
	protected float subTotal=0;
	/**
	 * CartLine class is private to ShoppingCart and represents a single line item
	 * added to a cart. 
	 */
	protected class CartLine{
		
		private int itemNo;
		private int qty;
		private String description; 
		private float price; 
		private float priceExt; 
		private Product product; 
		private int lineNo;
		/**
		 * Primary CartLine constructor. 
		 * @param itemNo the item number being added to the cart
		 * @param qty the quantity of specified item being added to the cart
		 */		
		private CartLine(int itemNo, int qty) {
			
			this.itemNo = itemNo;
			this.qty = qty; 
			this.product = Product.lookupItem(itemNo);
			this.description = this.product.getName();
			this.price = this.product.getPrice();
			this.priceExt = this.price * this.qty;
			this.lineNo = nextLine++; 
			
		}
		/**
		 * @return CartLine.lineNo
		 */
		private int getLineNo() {
			
			return this.lineNo;
		}
		/**
		 * @return CartLine.itemNo
		 */
		private int getItemNo() {
			
			return this.itemNo;
			
		}
		/**
		 * @return CartLine.qty
		 */
		private int getQTY() {
			
			return this.qty;
		}
		/**
		 * @return CartLine.description
		 */
		private String getDescription() {
			
			return this.description;
		}
		/**
		 * @return CartLine.price
		 */
		private float getPrice() {
			
			return this.price; 
		}
		/** returns the extended price (qty * price)
		 * @return CartLine.priceExt
		 */
		private float getPriceExt() {
			
			return this.priceExt;
		}
		/**
		 * Prints the CartLine instance as a row to stdout. 
		 * Called by static methods which provide header. 
		 */
		private void printLine() {
			
			System.out.printf("%10d\t%10d\t%15.15s\t%10d\t$%9.2f\t$%,14.2f\n",
					this.getLineNo(), this.getItemNo(), this.getDescription(),
					this.getQTY(), (float) this.getPrice(), this.getPriceExt());
		}
		
	}
	/**
	 * Checks if the specified line number exists among the ShoppingCart's lines. 
	 * @param lineNo the requested CartLine number. 
	 * @return true if found, else false. 
	 */
	private boolean exists(int lineNo) {
		
		for (CartLine line: cartLines) {
			if(line.getLineNo() == lineNo) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Adds a CartLine to the ShoppingCart. Prints an error to stdout if
	 * qty less than or equal to 0 or if itemNo does not exist among Product catalog. 
	 * @param itemNo the item which should be added to the ShoppingCart.
	 * @param qty the qty of item which should be added. 
	 */
	public void addLine(int itemNo, int qty) {
		
		if(!Product.exists(itemNo) || qty <= 0) {
			System.out.println("Invalid Entry");
			return;
		}
		cartLines.add(new CartLine(itemNo, qty));
		this.updateTotal();
	}
	/**
	 * Removes a CartLine item from the ShoppingCart as specified by lineNo. 
	 * Prints an error to stdout if lineNo does not exist in ShoppingCart.
	 * NOTE: Remaining ShoppingCart lineNo's are not updated after deletion. 
	 * As such, a ShoppingCart's lineNo's may not be sequential. 
	 * @param lineNo The line which is requested to be removed.
	 */
	public void delLine(int lineNo) {
		
		
		//catches invalid line numbers
		if(!this.exists(lineNo)) {
			System.out.println("Invalid Entry!");
			return;
		}
		
		/*
		 * Because an element is being deleted, ArrayList requires us 
		 * to create an iterator for conducting the operation. 
		 */
		Iterator<CartLine> iterator = cartLines.iterator();
        while (iterator.hasNext()) {
            CartLine line = iterator.next();
            if (line.getLineNo() == lineNo) {
                iterator.remove();
            }
        }
		this.updateTotal(); //updates the cart total value after deletion. 
	}
	/**
	 * Prints all ShoppingCart line items. Starts by printing a header. 
	 * Then loops through all CartLine's printing each as a row. 
	 * Then prints the subtotal. 
	 */
	public void printCart() {
		
		
		System.out.printf("%10s\t%10s\t%15s\t%10s\t%10s\t%15s\n",
				"Line No","Item No","Description","QTY","Price","EXT");
		for (CartLine line: cartLines) {
			line.printLine();
		}
		System.out.printf("Total:\t$%,.2f\n", this.subTotal);
	}
	/**
	 * Calculates the cart subtotal by iterating over all CartLines
	 */
	private void updateTotal() {
		
		this.subTotal = 0 ;
		for ( CartLine line: cartLines) {
			this.subTotal += line.getPriceExt();
		}
	}
	/**
	 * Default Constructor
	 */
	public ShoppingCart() {
		
		
	}
}

