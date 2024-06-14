package ecom.Products;
/**
 * Provides attributes and methods specific to Product subtype Clothing
 */
public class Clothing extends Product {
	
	private String size;
	private String material;
	/**
	 * Primary constructor for Product subtype Clothing
	 * @param name The name or Description for the product.
	 * @param price The price for the product. 
	 * @param size The size of the Clothing product
	 * @param material The material from which the Clothing product is made. 
	 */
	public Clothing(String name, float price, String size, String material) {
		
		super(name, price);
		this.productType = "Clothing";
		this.size = size;
		this.material = material;
	}
	/**
	 * @return Clothing.size
	 */
	public String getSize() {
		
		return size;
	}
	/**
	 * @return Clothing.material
	 */
	public String getMaterial() {
		
		return material;
	}
	/**
	 * Overrides Product.printDetails; printing additional Clothing details to stdout. 
	 */
	public void printDetails() {
		
		super.printDetails();
		System.out.printf("Size:\t%s\nMaterial:\t%s\n", this.getSize(), this.getMaterial());
	}

}