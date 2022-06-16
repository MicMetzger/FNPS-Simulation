package main.java.com.staff;
import main.java.com.inventory.StoreObserver;
import main.java.com.item.Item;
import java.util.ArrayList;
import java.util.Arrays;




public class Employee implements StoreObserver {
	private          int          workDays;
	Employee base;
	ArrayList<Item>     inventory;

	static ArrayList<String> NAME_TEMPLATE = new ArrayList<String>(Arrays.asList("Kevin", "Andrew", "Michelle", "David", "Sarah"));

	
	public Employee(int workDays) {
		this.workDays = workDays;
	}


	public Employee() {
		workDays = 0;
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
		String announcement = "enters the store...";
		announce(announcement);
	}


	private void leave() {
		String announcement = "leaves the store...";
		announce(announcement);
	}


	/**
	 * @return inventory so that Store inventory will be updated in Store
	 */
	public ArrayList<Item> feedAnimals() {
		// String announcement = "feeds "; //TODO

		return inventory;
	}


	public void processInventory() {
		String announcement = "goes through store inventory...";

	}


	public void CheckRegister() {
		String announcement = "checks the register...";

	}


	public void GoToBank() {
		String announcement = "goes to the bank...";

	}


	public void processDeliveries() {
		String announcement = "goes through today's deliveries...";

	}


	public void PlaceAnOrder() {
		// String announcement = "places an order for ";  //TODO


	}

	
	public int getWorkDays() {
		return workDays;
	}
	
	
	public void incWorkDays() {
		workDays++;
	}

	
	public void dayoff() {
		workDays = 0;
	}
	
	
	public void setInventory(ArrayList<Item> newInventory) {
		this.inventory = newInventory;
	}



	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
}
