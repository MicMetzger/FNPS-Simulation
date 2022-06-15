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




public class Store {
	ArrayList<Item>     inventory;
	ArrayList<Employee> staff;
	Employee currentStaff;
	// List<StoreObserver> observers;
	double              cash;
	int                 day;


	public Store() {
		staff = new ArrayList<Employee>();
		inventory = new ArrayList<Item>();
		// currentStaff
		cash = 0;
		day = 0;
		initItemsAndStaff();
	}


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


	void selectStaff() {
		
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


