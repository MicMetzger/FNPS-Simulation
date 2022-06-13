public class Leash extends Supplies {
  
  // The animal
  private Pet animal;

/**
 * Instantiates a new Leash
 * 
 * @param animal the animal
 */



 public Leash(Pet animal) {
  this.animal = animal;
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
