package main.java.com.item.pet;
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


	// public Breed getBreed() {
	// 	return this;
	// }
}
