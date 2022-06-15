package main.java.com.item.pet;
import java.util.Date;




/**
 * The type Dog.
 */
public class Dog extends Pet {
	/**
	 * The Size.
	 */
	public double  size;
	/**
	 * The Color.
	 */
	public String  color;
	/**
	 * The Housebroken.
	 */
	public boolean housebroken;
	/**
	 * The Purebred.
	 */
	public boolean purebred;


	/**
	 * Instantiates a new Dog.
	 *
	 * @param name          the name
	 * @param dayArrived    the day arrived
	 * @param daySold       the day sold
	 * @param purchasePrice the purchase price
	 * @param listPrice     the list price
	 * @param salePrice     the sale price
	 * @param breed         the breed
	 * @param age           the age
	 * @param healthy       the healthy
	 * @param size          the size
	 * @param color         the color
	 * @param housebroken   the housebroken
	 * @param purebred      the purebred
	 */
	public Dog(String name, Date dayArrived, Date daySold, double purchasePrice, double listPrice, double salePrice, Breed breed, int age, boolean healthy, double size, String color, boolean housebroken, boolean purebred) {
		super(name, dayArrived, daySold, purchasePrice, listPrice, salePrice, breed, age, healthy);
		this.size = size;
		this.color = color;
		this.housebroken = housebroken;
		this.purebred = purebred;
	}


	/**
	 * Instantiates a new Dog.
	 *
	 * @param breed       the breed
	 * @param age         the age
	 * @param healthy     the healthy
	 * @param size        the size
	 * @param color       the color
	 * @param housebroken the housebroken
	 * @param purebred    the purebred
	 */
	public Dog(Breed breed, int age, boolean healthy, double size, String color, boolean housebroken, boolean purebred) {
		super(breed, age, healthy);
		this.size = size;
		this.color = color;
		this.housebroken = housebroken;
		this.purebred = purebred;
	}


	/**
	 * Instantiates a new Dog.
	 *
	 * @param size        the size
	 * @param color       the color
	 * @param housebroken the housebroken
	 * @param purebred    the purebred
	 */
	public Dog(double size, String color, boolean housebroken, boolean purebred) {
		super();
		this.size = size;
		this.color = color;
		this.housebroken = housebroken;
		this.purebred = purebred;
	}


	public Dog(String name, Date dayArrived, Date daySold, double purchasePrice, double listPrice, double salePrice, Breed breed, int age, boolean healthy) {
		super(name, dayArrived, daySold, purchasePrice, listPrice, salePrice, breed, age, healthy);
	}


	/**
	 * Instantiates a new Dog.
	 *
	 * @param breed   the breed
	 * @param age     the age
	 * @param healthy the healthy
	 */
	public Dog(Breed breed, int age, boolean healthy) {
		super(breed, age, healthy);
	}


	/**
	 * Instantiates a new Dog.
	 */
	public Dog() {super();}


	/**
	 * Sets list price.
	 *
	 * @param listPrice the list price
	 */
	@Override
	public void setListPrice(double listPrice) {
		super.setListPrice(listPrice);
	}


	@Override
	public void setHealthy(boolean healthy) {
		super.setHealthy(healthy);
	}


	@Override
	public String toString() {
		return "Dog{" +
				"size=" + size +
				", color='" + color + '\'' +
				", housebroken=" + housebroken +
				", purebred=" + purebred +
				"} " + super.toString();
	}


	/**
	 * Gets size.
	 *
	 * @return the size
	 */
	public double getSize() {
		return size;
	}


	/**
	 * Sets size.
	 *
	 * @param size the size
	 */
	public void setSize(double size) {
		this.size = size;
	}


	/**
	 * Gets color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * Sets color.
	 *
	 * @param color the color
	 */
	public void setColor(String color) {
		this.color = color;
	}


	/**
	 * Is housebroken boolean.
	 *
	 * @return the boolean determining if the dog is housebroken or not.
	 */
	public boolean isHousebroken() {
		return housebroken;
	}


	/**
	 * Sets housebroken.
	 *
	 * @param housebroken the housebroken
	 */
	public void setHousebroken(boolean housebroken) {
		this.housebroken = housebroken;
	}


	/**
	 * Is the dog a purebred.
	 *
	 * @return the boolean
	 */
	public boolean isPurebred() {
		return purebred;
	}


	/**
	 * Sets purebred status.
	 *
	 * @param purebred the purebred
	 */
	public void setPurebred(boolean purebred) {
		this.purebred = purebred;
	}


	@Override
	public void announce(String announcement) {
		
	}

}
