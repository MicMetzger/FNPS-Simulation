package main.java.com.staff;
import main.java.com.inventory.StoreObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public abstract class Employee implements StoreObserver {
	private          int          workDays;
	protected static List<String> NAME_TEMPLATE = new ArrayList<String>(Arrays.asList("Kevin", "Andrew", "Michelle", "David", "Sarah"));


	public Employee(int workDays) {
		this.workDays = workDays;
	}


	public Employee() {
		workDays = 0;
	}


	@Override
	public void announce() {
		System.out.println(getName() + "Enters the store...");
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


	private void arrival() {

	}


	private void leave() {

	}


	private void processInventory() {

	}


	private void feedAnimals() {

	}


}
