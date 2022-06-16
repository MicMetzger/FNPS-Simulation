package main.java.com.item.pet;

public enum Animal {
	// TODO: 1. Determine if an enum type is a viable option; 2. List breed selection

	Dog ("Dog"),
	Bird("Bird"),
	Cat("Cat");

	private final String name;
	private      Breed  breed;

	Animal(String animal) {
		this.name = animal;
	}


	public String toString() {
		return this.name;
	}
	

	public boolean equals(String name) {
		return this.name.equals(name);
	}
	

	public void setBreed(Breed breed) {
		this.breed = breed;
	}
	
	
	public Breed getBreed() {
		return breed;
	}


	


}


enum Breed {
	;
	private final String name;


	Breed(String name) {this.name = name;}

	public String toString() {
		return this.name;
	}

	public boolean equals(String breed) {
		return this.name.equals(breed);
	}
	// equals(br)
}
