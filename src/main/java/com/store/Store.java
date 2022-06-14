package main.java.com.store;
import main.java.com.inventory.StoreObserver;
import main.java.com.item.Item;
import main.java.com.staff.Employee;
import java.util.ArrayList;
import java.util.List;




public class Store {
	private List<Item>          inventory = new ArrayList<>();
	private List<Employee>      staff     = new ArrayList<>();
	private List<StoreObserver> observers = new ArrayList<>();
	private double cash = 0;
	
	public Store(List<StoreObserver> inventory) {
		// this.inventory = inventory;
	}
	
	public Store() {}
	
	
	public void initItemsAndStaff() {
		// assert () == 0;
		
	}
	

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
	
	
	public void addItem(Item item) {
		inventory.add(item);
	}
	
	
	public void removeItem(Item item) {
		inventory.remove(item);
	}
	
	
	public void addEmployee(Employee employee) {
		staff.add(employee);
	}
	
	
	public void removeEmployee(Employee employee) {
		staff.remove(employee);
	}
}
