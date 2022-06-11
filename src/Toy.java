public class Toy extends Supplies {
  
  // The animal
  private Pet animal;

/**
 * Instantiates a new Leash
 * 
 * @param animal the animal
 */

 public Toy(Pet animal) {
  this.animal = animal;
 }


 /**
  * Default constructor
  */

  public Toy() {}

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
