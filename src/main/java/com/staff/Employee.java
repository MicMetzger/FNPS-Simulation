package main.java.com.staff;
import main.java.com.inventory.StoreObserver;
import main.java.com.item.Item;
import main.java.com.item.pet.Pet;
import main.java.com.store.DeliveryPackage;
import main.java.com.store.deliveryProcesser.ItemOrderProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;




public class Employee implements StoreObserver {
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


	@Override
	public String getName() {
		return base.getName();
	}


	@Override
	public void setName(String name) {
		base.setName(name);
	}


	@Override
	public void announce(String announcement) {
		System.out.println(getName() + announcement);
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
				boolean willBeSick   = rand.nextInt(5) < 100;
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
			boolean willRecover  = rand.nextInt(25) < 100;
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
		if(name == "Dog") {

		}

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

		// ITEM_TO_ORDER is now left with items that need to be ordered
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
