package main.java.com.staff;
import main.java.com.item.Item;
import main.java.com.item.pet.*;
import main.java.com.item.supplies.CatLiter;
import main.java.com.item.supplies.Food;
import main.java.com.item.supplies.Leash;
import main.java.com.item.supplies.Toy;
import main.java.com.item.supplies.Type;
import main.java.com.store.DeliveryPackage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static main.java.com.item.supplies.SupplyType.Toy;


public class Employee {
	private int workedDays;
	Employee        base;
	ArrayList<Item> inventory;
	ArrayList<Pet>  sick;

	double cash;

	ArrayList<DeliveryPackage> mailBox;

	static ArrayList<String> NAME_TEMPLATE = new ArrayList<String>(Arrays.asList("Kevin", "Andrew", "Michelle", "David", "Sarah"));


	public Employee(int workedDays) {
		this.workedDays = workedDays;
		inventory = new ArrayList<>();
	}


	public Employee() {
		workedDays = 0;
		inventory = new ArrayList<>();
	}


	public String getName() {
		return base.getName();
	}



	public void setName(String name) {
		base.setName(name);
	}


	public void announce(String announcement) {
		System.out.println(getName() + announcement);
	}


	public void arrival() {
		String announcement = " enters the store...";
		announce(announcement);
	}


	private void leave() {
		String announcement = " leaves the store...";
		announce(announcement);
	}


	public void feedAnimals() {
		Random rand = new Random();
		inventory.forEach(item -> {
			if (item.getClass().getCanonicalName().contains("pet")) {
				// 5% chance of getting sick
				boolean willBeSick   = rand.nextInt(100) < 5;
				String  announcement = willBeSick ? " Feeds, and " + item.getName() + " got sick..." : " Feeds " + item.getName();
				announce(announcement);
				if (willBeSick) {
					sick.add((Pet) item);
					inventory.remove(item);
				}
			}
		});

		for (Pet pet : sick) {
			// 25% change of recovering
			boolean willRecover  = rand.nextInt(100) < 25;
			String  announcement = willRecover ? " Feeds, and " + pet.getName() + " recovered from sick." : " Feeds " + pet.getName();
			announce(announcement);
			if (willRecover) {
				inventory.add(pet);
				sick.remove(pet);
			}
		}
	}


	public void processInventory() {
		String announcement = " goes through store inventory...";

	}


	public void CheckRegister() {
		String announcement = " checks the register...";

	}


	public void GoToBank() {
		String announcement = " goes to the bank...";
		announce(announcement);

	}


	public void processDeliveries() {
		String announcement = " goes through today's deliveries...";
		announce(announcement);

		mailBox.forEach(item -> {
			if(item.getExpectedDeliveryDate() == workedDays) {
				String announcementDelivery = item.getPackageName() + " is added to the inventory.";
				announce(announcement);
				inventory.add(item.getItem());
				mailBox.remove(item);
			}
		});
	}


	/**
	 * @param name
	 * @param expectedDeliveryDate
	 * @param purchasePrice
	 * @return Delivery Package
	 */
	public DeliveryPackage orderItem(String name, int expectedDeliveryDate, double purchasePrice) {
		// TODO: implement
		DecimalFormat sizeFormat 					= new DecimalFormat("#####.00");
		final ArrayList<String> colors              = new ArrayList<String>(Arrays.asList("Black", "Brown", "White", "Gray", "Red"));
		DeliveryPackage newPackage = new DeliveryPackage(name, expectedDeliveryDate);
		int daySold 	= 0;
		int salePrice 	= 0;
		int age			= new Random().nextInt(15);

		// TODO: Make Breeds for each animals in Breed enum
		if(name == "Dog") {
			newPackage.setItem(new Dog(name, expectedDeliveryDate, daySold, purchasePrice, purchasePrice*2, salePrice, Breed.values()[new Random().nextInt(Breed.values().length)], age, new Random().nextInt(2) == 1, Double.parseDouble(sizeFormat.format(new Random().nextDouble(50))), Color.values()[new Random().nextInt(Color.values().length)], new Random().nextInt(2) == 1, new Random().nextInt(2) == 1));
		} else if(name == "Cat") {
			newPackage.setItem(new Cat(name, expectedDeliveryDate, daySold, purchasePrice, purchasePrice*2, salePrice, Breed.values()[new Random().nextInt(Breed.values().length)], age, new Random().nextInt(2) == 1, colors.get(new Random().nextInt(colors.size())), new Random().nextInt(2) == 1, new Random().nextInt(2) == 1));
		} else if (name == "Bird") {
			newPackage.setItem(new Bird(name, expectedDeliveryDate, daySold, purchasePrice, purchasePrice*2, salePrice, Breed.values()[new Random().nextInt(Breed.values().length)], age, new Random().nextInt(2) == 1, Double.parseDouble(sizeFormat.format(new Random().nextDouble(8))), new Random().nextInt(2) == 1, new Random().nextInt(2) == 1, new Random().nextInt(2) == 1));
		} else if(name == "Food") {
			newPackage.setItem(new Food(name, purchasePrice, purchasePrice*2, salePrice, daySold, expectedDeliveryDate, new Random().nextInt(100), Animal.values()[new Random().nextInt(Animal.values().length)], Type.values()[new Random().nextInt(Type.values().length)]));
		} else if(name == "Leash") {
			newPackage.setItem(new Leash(name, purchasePrice, purchasePrice*2, salePrice, daySold, expectedDeliveryDate, Animal.values()[new Random().nextInt(Animal.values().length)]));
		} else if (name == "Toy") {
			newPackage.setItem(new Toy(name, purchasePrice, purchasePrice*2, salePrice, daySold, expectedDeliveryDate, Animal.values()[new Random().nextInt(Animal.values().length)]));
		} else if(name == "Cat Litter") {
			newPackage.setItem(new CatLiter(name, purchasePrice, purchasePrice*2, salePrice, daySold, expectedDeliveryDate, new Random().nextInt(100)));
		}

		return newPackage;
	}


	public void PlaceAnOrder() {
		// String announcement = "places an order for ";  //TODO
		Random rand = new Random();

		ArrayList<String> ITEM_TO_ORDER = new ArrayList<String>(Arrays.asList("Dog", "Cat", "Bird", "Food", "Leash", "Toy", "Cat Litter"));
		inventory.forEach(item -> {
			// TODO: test if these methods work to get the class name of the instance
			String itemName = item.getClass().getSimpleName();
			if(ITEM_TO_ORDER.contains(itemName)) {
				ITEM_TO_ORDER.remove(itemName);
			}
		});

		// ITEM_TO_ORDER is now left with items that need to be ordered (0 stock)
		for(String name:ITEM_TO_ORDER) {
			int    expectedDeliveryDate = workedDays + rand.nextInt(3);
			double purchasePrice        = rand.nextInt(100);
			if(cash >= purchasePrice) {
				mailBox.add(orderItem(name, expectedDeliveryDate, purchasePrice));
				cash -= purchasePrice;
			} else {
				// insufficient money
				ITEM_TO_ORDER.remove(name);
			}
		}
	}


	public int getWorkDays() {
		return workedDays;
	}


	public void incWorkDays() {
		workedDays++;
	}


	public void dayoff() {
		workedDays = 0;
	}


	public void setInventory(ArrayList<Item> newInventory) {
		this.inventory = newInventory;
	}


	public void setSickPet(ArrayList<Pet> newSickAnimals) {
		this.sick = newSickAnimals;
	}

	public ArrayList<DeliveryPackage> getMailBox() {
		return this.mailBox;
	}

	public void setMailBox(ArrayList<DeliveryPackage> newMailbox) {
		this.mailBox = newMailbox;
	}

	public void setCash(double newCash) {
		this.cash = newCash;
	}

	public double getCash() {
	 	return cash;
	}


	public ArrayList<Pet> getSickAnimal() {
		return sick;
	}


	public ArrayList<Item> getInventory() {
		return inventory;
	}

}
