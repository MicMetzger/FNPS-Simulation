package main.java.com.item.supplies;


/**
 * The type Cat liter.
 */
public class CatLiter extends Supplies {
	// The size of the cat liter.
	private int    size;



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

	public CatLiter(String name, double purchasePrice, double listPrice, double salePrice, int daySold, int dayArrived, int size) {
		super(name, purchasePrice, listPrice, salePrice, dayArrived, daySold);
		this.size = size;
	}

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
