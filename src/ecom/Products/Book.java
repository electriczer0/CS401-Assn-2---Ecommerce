package ecom.Products;
/**
 * Provides attributes and methods for Product subtype Book. 
 */
public class Book extends Product {
	/**
	 * The Book's Author, an arbitrary string
	 */
	private String author;
	/**
	 * The Book's Genre, an arbitrary string. 
	 */
	private String genre;
	/**
	 * Primary constructor for Product subtype Book. 
	 * @param name Name or description of Book Product. 
	 * @param price Price of Book Product. 
	 * @param author The author of the Book Product. 
	 * @param genre The genre of the Book Product. 
	 */
	public Book(String name, float price, String author, String genre) {
		
		super(name, price);
		this.productType = "Book";
		this.author = author;
		this.genre = genre;
	}
	/**
	 * @return Book.author
	 */
	public String getAuthor() {
		
		return author;
	}
	/**
	 * @return Book.genre
	 */
	public String getGenre() {
		
		return genre;
	}
	/**
	 * Overrides Product.printDetails to print additional Book details to stdout
	 */
	public void printDetails() {
		
		super.printDetails();
		System.out.printf("Author:\t%s\nGenre:\t%s\n", this.getAuthor(), this.getGenre());
	}

}
