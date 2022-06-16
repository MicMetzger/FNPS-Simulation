package main.java.com.item.supplies;
import main.java.com.item.pet.Animal;




public class Leash extends Supplies {

	// The animal
	private Animal animal;


	/**
	 * Instantiates a new Leash
	 *
	 * @param animal the animal
	 */

	public Leash(Animal animal) {
		this.animal = animal;
	}


	public Leash(String animal) {
		this.animal = Animal.valueOf(animal);
	}


	/**
	 * Default constructor
	 */

	public Leash() {}


	/**
	 * Gets the animal
	 *
	 * @return the animal
	 */
	public Animal getAnimal() {
		return animal;
	}


	/**
	 * Sets the animal
	 *
	 * @param animal the animal
	 */
	public void setAnimal(String animal) {
		this.animal = Animal.valueOf(animal);
	}

}
