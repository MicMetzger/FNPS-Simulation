package main.java.com.inventory;
import main.java.com.item.Item;
import java.util.ArrayList;
import java.util.List;




public class Inventory implements StoreComponent {
	private List<Item> stock = new ArrayList<>();


	@Override
	public String getName() {
		return null;
	}


	@Override
	public void setName(String name) {

	}


	@Override
	public void print() {
		
	}
}
