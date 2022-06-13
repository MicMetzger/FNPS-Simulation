package main.java.com.store;
import main.java.com.inventory.StoreComponent;
import main.java.com.item.Item;
import main.java.com.staff.Employee;
import java.util.ArrayList;
import java.util.List;




public class Store {
	// private List<StoreComponent> inventory = new ArrayList<>();
	private List<Item>     inventory = new ArrayList<>();
	private List<Employee> staff = new ArrayList<>();


	public Store(List<StoreComponent> inventory) {
		// this.inventory = inventory;
	}

}
