package main.java.com.staff;
import main.java.com.inventory.StoreObserver;
import java.util.ArrayList;
import java.util.Arrays;




public class Employee implements StoreObserver {
	private          int          workDays;
	Employee base;
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


	private void feedAnimals() {
		// String announcement = "feeds "; //TODO

	}


	private void processInventory() {
		String announcement = "goes through store inventory...";

	}


	private void CheckRegister() {
		String announcement = "checks the register...";

	}


	private void GoToBank() {
		String announcement = "goes to the bank...";

	}


	private void processDeliveries() {
		String announcement = "goes through today's deliveries...";

	}


	private void PlaceAnOrder() {
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
}
