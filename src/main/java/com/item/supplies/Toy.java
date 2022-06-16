package main.java.com.item.supplies;
import main.java.com.item.pet.Pet;




public class Toy extends Supplies {

	// The animal
	private Pet animal;


	/**
	 * Instantiates a new Leash
	 *
	 * @param animal the animal
	 */

	public Toy(Pet animal) {
		super();
		this.animal = animal;
		super.supplyType = SupplyType.Toy;
	}


	/**
	 * Default constructor
	 */

	public Toy() {
		super();
		super.supplyType = SupplyType.Toy;
	}


	/**
	 * Gets the animal
	 *
	 * @return the animal
	 */
	public Pet getAnimal() {
		return animal;
	}


	/**
	 * Sets the animal
	 *
	 * @param animal the animal
	 */
	public void setAnimal(Pet animal) {
		this.animal = animal;
	}

}
