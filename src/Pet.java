import java.util.*;




public abstract class Pet extends Item {
	private Breed   breed;
	private int     age;
	private boolean healthy;


	public Pet(String name, Date dayArrived, Date daySold, double purchasePrice, double listPrice, double salePrice, Breed breed, int age, boolean healthy) {
		super(name, dayArrived, daySold, purchasePrice, listPrice, salePrice);
		this.breed = breed;
		this.age = age;
		this.healthy = healthy;
	}


	public Pet(Breed breed, int age, boolean healthy) {
		this.breed = breed;
		this.age = age;
		this.healthy = healthy;
	}


	public Pet() {}


	@Override
	public String toString() {
		return "Pet{} " + super.toString();
	}


	public Breed getBreed() {
		return breed;
	}


	public void setBreed(Breed breed) {
		this.breed = breed;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public boolean isHealthy() {
		return healthy;
	}


	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}

}


