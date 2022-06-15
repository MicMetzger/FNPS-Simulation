package main.java.com.item.pet;
import java.util.Date;




public class Bird extends Pet {

	/**
	 * the size
	 */
	public double size;

	/**
	 * the mimicry
	 */
	public boolean mimicry;

	/**
	 * the exotic
	 */
	public boolean exotic;

	/**
	 * the papers
	 */
	public boolean papers;


	/**
	 * Instantiates a new bird
	 *
	 * @param name
	 * @param dayArrived
	 * @param daySold
	 * @param purchasePrice
	 * @param listPrice
	 * @param salePrice
	 * @param breed
	 * @param age
	 * @param healthy
	 */

	public Bird(String name, Date dayArrived, Date daySold, double purchasePrice, double listPrice, double salePrice, Breed breed, int age, boolean healthy, double size, boolean mimicry, boolean exotic, boolean papers) {
		super(name, dayArrived, daySold, purchasePrice, listPrice, salePrice, breed, age, healthy);
		this.size = size;
		this.mimicry = mimicry;
		this.exotic = exotic;
		this.papers = papers;
	}


	/**
	 * Instantiates a new bird
	 *
	 * @param breed
	 * @param age
	 * @param healthy
	 * @param size
	 * @param mimicry
	 * @param exotic
	 * @param papers
	 */

	public Bird(Breed breed, int age, boolean healthy, double size, boolean mimicry, boolean exotic, boolean papers) {
		super(breed, age, healthy);
		this.size = size;
		this.mimicry = mimicry;
		this.exotic = exotic;
		this.papers = papers;
	}


	/**
	 * Instantiates a new bird
	 *
	 * @param size
	 * @param mimicry
	 * @param exotic
	 * @param papers
	 */

	public Bird(double size, boolean mimicry, boolean exotic, boolean papers) {
		this.size = size;
		this.mimicry = mimicry;
		this.exotic = exotic;
		this.papers = papers;
	}


	/**
	 * Instantiates a new bird
	 */
	public Bird() {

	}


	@Override
	public String toString() {
		return "Dog{" +
				"size=" + size +
				", mimicry='" + mimicry + '\'' +
				", exotic=" + exotic +
				", papers=" + papers +
				"} " + super.toString();
	}


	/**
	 * sets the size
	 *
	 * @param size
	 */
	public void setSize(double size) {
		this.size = size;
	}


	/**
	 * sets the mimicry
	 *
	 * @param mimicry
	 */
	public void setMimicry(boolean mimicry) {
		this.mimicry = mimicry;
	}


	/**
	 * sets the exotic
	 *
	 * @param exotic
	 */
	public void setExotic(boolean exotic) {
		this.exotic = exotic;
	}


	/**
	 * sets the papers
	 *
	 * @param papers
	 */
	public void setPapers(boolean papers) {
		this.papers = papers;
	}


	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}


	/**
	 * @return the mimicry
	 */
	public boolean isMimicry() {
		return mimicry;
	}


	/**
	 * @return the exotic
	 */

	public boolean isExotic() {
		return exotic;
	}


	/**
	 * @return the papers
	 */
	public boolean isPapers() {
		return papers;
	}


	@Override
	public void announce(String announcement) {
		
	}

}
