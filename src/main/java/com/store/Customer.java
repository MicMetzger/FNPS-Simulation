package main.java.com.store;
import main.java.com.item.Item;
import main.java.com.item.supplies.PurchaseType;
import java.security.SecureRandom;
import java.util.ArrayList;




public class Customer {
	PurchaseType desire;
	Item obj;
	
	Customer() {
		desire = PurchaseType.values()[new SecureRandom().nextInt(PurchaseType.values().length)];
		obj = null;
	}
	
	public boolean inspectInventory(ArrayList<Item> inventory) {
		System.out.println("The customer inspects the store's offerings...");
		inventory.forEach(item -> {
			int roll = new SecureRandom().nextInt(0, 10);
			if (roll == 1) {
				obj = item;
			}
		});
		return obj != null;
	}
	
}
