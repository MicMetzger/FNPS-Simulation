package main.java.com.item;
import main.java.com.inventory.StoreObserver;
import java.util.Date;




/**
 *
 */
public abstract class Item implements StoreObserver {
	private String name;
	private Date   dayArrived;
	private Date   daySold;
	private double purchasePrice;
	private double listPrice;
	private double salePrice;


	/**
	 * Instantiates a new Item.
	 *
	 * @param name          the name
	 * @param dayArrived    the day arrived
	 * @param daySold       the day sold
	 * @param purchasePrice the purchase price
	 * @param listPrice     the list price
	 * @param salePrice     the sale price
	 */
	public Item(String name, Date dayArrived, Date daySold, double purchasePrice, double listPrice, double salePrice) {
		this.name = name;
		this.dayArrived = dayArrived;
		this.daySold = daySold;
		this.purchasePrice = purchasePrice;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
	}


	/**
	 * Default constructor of Item object.
	 */
	public Item() {}


	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Gets purchase price.
	 *
	 * @return the purchase price
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}


	/**
	 * Sets purchase price.
	 *
	 * @param purchasePrice the purchase price
	 */
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}


	/**
	 * Gets list price.
	 *
	 * @return the list price
	 */
	public double getListPrice() {
		return listPrice;
	}


	/**
	 * Sets list price.
	 *
	 * @param listPrice the list price
	 */
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}


	/**
	 * Gets sale price.
	 *
	 * @return the sale price
	 */
	public double getSalePrice() {
		return salePrice;
	}


	/**
	 * Sets sale price.
	 *
	 * @param salePrice the sale price
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}


	/**
	 * Gets day arrived.
	 *
	 * @return the day arrived
	 */
	public Date getDayArrived() {
		return dayArrived;
	}


	/**
	 * Sets day arrived.
	 *
	 * @param dayArrived the day arrived
	 */
	public void setDayArrived(Date dayArrived) {
		this.dayArrived = dayArrived;
	}


	/**
	 * Gets day sold.
	 *
	 * @return the day sold
	 */
	public Date getDaySold() {
		return daySold;
	}


	/**
	 * Sets day sold.
	 *
	 * @param daySold the day sold
	 */
	public void setDaySold(Date daySold) {
		this.daySold = daySold;
	}


	public void print() {
		System.out.println("Item{" +
				"name='" + name + '\'' +
				", dayArrived=" + dayArrived +
				", daySold=" + daySold +
				", purchasePrice=" + purchasePrice +
				", listPrice=" + listPrice +
				", salePrice=" + salePrice +
				'}');
	}


	public abstract void announce();

}
