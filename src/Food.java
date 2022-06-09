public class Food extends Supplies {
	private int  size;
	private Pet  animal;
	private Type type;


	public Food(int size, Pet animal, Type type) {
		this.size = size;
		this.animal = animal;
		this.type = type;
	}


	public Food() {}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public Pet getAnimal() {
		return animal;
	}


	public void setAnimal(Pet animal) {
		this.animal = animal;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}

}
