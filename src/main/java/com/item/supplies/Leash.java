package main.java.com.item.supplies;
public class Leash extends Supplies {
  
  // The animal
  private String animal;

/**
 * Instantiates a new Leash
 * 
 * @param animal the animal
 */

 public Leash(String animal) {
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
  public String getAnimal() {
    return animal;
  }

  /**
   * Sets the animal
   * 
   * @param animal the animal
   */
  public void setAnimal(String animal) {
    this.animal = animal;
  }

}
