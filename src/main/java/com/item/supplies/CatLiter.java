package main.java.com.item.supplies;
/**
 * The type Cat liter.
 */
public class CatLiter extends Supplies {
	// The size of the cat liter.
	private       int        size;
	private String animal;

	/**
	 * Instantiates a new Cat liter.
	 *
	 * @param size the size
	 */
	public CatLiter(int size) {
		this.size = size;
	}


	/**
	 * Default Constructor of CatLiter object
	 */
	public CatLiter() {}


	/**
	 * Gets the cat liter size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}


	/**
	 * Sets the cat liter size.
	 *
	 * @param size the cat liter size
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
