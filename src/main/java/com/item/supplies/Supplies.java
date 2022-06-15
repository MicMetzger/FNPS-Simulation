package main.java.com.item.supplies;
import main.java.com.item.Item;
import java.util.Date;




/**
 *
 *
 */
public class Supplies extends Item {

	public Supplies() {
		super();
	}


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
	public Supplies(String name, Date dayArrived, Date daySold, double purchasePrice, double listPrice, double salePrice) {
		super(name, dayArrived, daySold, purchasePrice, listPrice, salePrice);
	}


	@Override
	public void announce() {
		
	}


	@Override
	public void announce(String announcement) {
		
	}


	@Override
	public void update() {

	}


	@Override
	public void subscribe() {

	}


	@Override
	public void unsubscribe() {

	}

}


