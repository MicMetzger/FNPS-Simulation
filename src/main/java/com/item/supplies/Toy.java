package main.java.com.item.supplies;
import main.java.com.item.pet.Animal;
import main.java.com.item.pet.Pet;




public class Toy extends Supplies {

	// The animal
	private Animal animal;


	/**
	 * Instantiates a new Leash
	 *
	 * @param animal the animal
	 */

	public Toy(String name, double purchasePrice, double listPrice, double salePrice, int daySold, int dayArrived, Animal animal) {
		super(name, purchasePrice, listPrice, salePrice, dayArrived, daySold);
		this.animal = animal;
	}



	/**
	 * Default constructor
	 */

	public Toy() {
		super();
		super.supplyType = SupplyType.Toy;
	}

}
