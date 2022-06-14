package main.java.com.item.pet;
import main.java.com.item.Item;
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
		super();
		this.breed = breed;
		this.age = age;
		this.healthy = healthy;
	}


	public Pet(Breed breed) { 
		super();
		this.breed = breed;
	}


	public Pet() {
		super();
	}


	@Override
	public void setName(String name) {
		super.setName(name);
	}


	@Override
	public void announce() {
		
	}


	@Override
	public void update() {
		
	}


	@Override
	public void subscribe() {

	}


	@Override
	public void unsubscribe() {

	}


	/**
	 * Sets list price.
	 *
	 * @param listPrice the list price
	 */
	@Override
	public void setListPrice(double listPrice) {
		super.setListPrice(listPrice);
	}


	/**
	 * Sets sale price.
	 *
	 * @param salePrice the sale price
	 */
	@Override
	public void setSalePrice(double salePrice) {
		super.setSalePrice(salePrice);
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


	@Override
	public String toString() {
		return "Pet{" +
				"breed=" + breed +
				", age=" + age +
				", healthy=" + healthy +
				"} " + super.toString();
	}

}

