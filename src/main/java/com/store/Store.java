package main.java.com.store;
import main.java.com.item.Item;
import main.java.com.item.pet.Bird;
import main.java.com.item.pet.Cat;
import main.java.com.item.pet.Dog;
import main.java.com.item.supplies.CatLiter;
import main.java.com.item.supplies.Food;
import main.java.com.item.supplies.Leash;
import main.java.com.staff.Clerk;
import main.java.com.staff.Employee;
import main.java.com.staff.Trainer;
import java.util.ArrayList;
import java.util.Random;




public class Store {
	/**
	 * The stores Inventory.
	 */
	ArrayList<Item>     inventory;
	ArrayList<Employee> staff;
	Employee            currentStaff;
	// List<StoreObserver> observers;
	double              cash;
	int                 day;


	/**
	 * Instantiates a new Store.
	 * Main entry point.
	 * 
	 * Default constructor
	 */
	public Store() {
		staff = new ArrayList<Employee>();
		inventory = new ArrayList<Item>();
		// currentStaff
		cash = 0;
		day = 0;
		initItemsAndStaff();
	}


	/**
	 * Initiate starting objects.
	 * TODO: Not finished. Need to setup randomization of  subclasses.
	 */
	public void initItemsAndStaff() {
		staff.add(new Clerk());
		staff.add(new Clerk());
		staff.add(new Trainer());
		staff.add(new Trainer());

		inventory.add(new Dog());
		inventory.add(new Cat());
		inventory.add(new Bird());
		inventory.add(new Food());
		inventory.add(new CatLiter());
		inventory.add(new Leash());

		// staff.forEach(hire -> hire.arrival());
	}


	/**
	 * Select staff to man store for this day.
	 */
	void selectStaff() {
		int num = new Random().nextInt(4);
		currentStaff = staff.get(num);

		if (currentStaff.getWorkDays() <= 2) {
			staff.forEach(employee -> {
				if (employee != currentStaff) {
					employee.dayoff();
				}
			});
		}
		else {
			if (currentStaff.getWorkDays() >= 3) {
				staff.forEach(employee -> {
					if (employee != currentStaff) {
						// currentStaff.dayoff();
						currentStaff = employee;

						staff.forEach(restream -> {
							if (restream != currentStaff) {
								restream.dayoff();
							}
							return;
						});

					}
				});
			}
		}
	}
	
	
	
	/*	
	public void updateObserver() {
		for (StoreObserver observer : observers) {
			observer.update();
		}
	}


	public void addObserver(StoreObserver observer) {
		observers.add(observer);
	}


	public void removeObserver(StoreObserver observer) {
		observers.remove(observer);
	}
	*/

}


