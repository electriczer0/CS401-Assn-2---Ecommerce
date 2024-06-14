package ecom.Products;
/**
 * Provides attributes and methods extending Products for the Electronics subtype.
 */
public class Electronics extends Product {
	
	private String brand;
	private int warrantyYears;
	/**
	 * Primary Electronics constructor. 
	 * @param name Name or description of Electronics product. 
	 * @param price Price of the Electronics product. 
	 * @param brand Brand of the Electronics product
	 * @param warrantyYears The length of the Electronics product's warranty as a integer number of years.
	 */
	public Electronics(String name, float price, String brand, int warrantyYears) {
		
		super(name, price);
		this.productType = "Electronics";
		this.brand = brand;
		this.warrantyYears = warrantyYears;
	}
	/**
	 * @return Electronics.brand
	 */
	public String getBrand() {
		
		return brand;
	}
	/**
	 * @return Electronics.warrantyYears
	 */
	public int getWarrantyYears() {
		
		return warrantyYears;
	}
	/**
	 * Overrides Product.printDetails to print additional Electronics details to stdout
	 */
	public void printDetails() {
		
		super.printDetails();
		System.out.printf("Brand:\t%s\nWarranty (years):\t%d\n", this.getBrand(), this.getWarrantyYears());
	}

}
