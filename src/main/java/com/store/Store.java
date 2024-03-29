package main.java.com.store;
import main.java.com.item.Item;
import main.java.com.item.pet.*;
import main.java.com.item.supplies.*;
import main.java.com.staff.Clerk;
import main.java.com.staff.Employee;
import main.java.com.staff.Trainer;

import java.security.SecureRandom;
import java.sql.Array;
import java.text.DecimalFormat;
import java.util.*;




public class Store {
	// The store's Inventory.
	ArrayList<Item>            inventory;
	ArrayList<Pet>             sick;
	ArrayList<Customer>        customers;
	ArrayList<DeliveryPackage> mailBox;
	// The store's staff
	ArrayList<Employee>        staff;

	ArrayList<Item> 			soldItems;
	Employee              currentStaff;
	// Money + day management
	double                bankWithdrawal;
	double                cash;
	int                   day;
	// Data helpers
	protected final ArrayList<String> colors              = new ArrayList<String>(Arrays.asList("Black", "Brown", "White", "Gray", "Red"));
	protected final boolean[]         randomSelectionbool = { true, false };
	DecimalFormat sizeFormat = new DecimalFormat("#####.00");


	/**
	 * Instantiates a new Store.
	 * Main entry point.
	 * <p>
	 * Default constructor
	 */
	public Store() {
		staff          = new ArrayList<Employee>();
		customers      = new ArrayList<Customer>();
		inventory      = new ArrayList<Item>();
		sick           = new ArrayList<Pet>();
		mailBox		   = new ArrayList<DeliveryPackage>();
		soldItems	   = new ArrayList<Item>();
		bankWithdrawal = 0;
		cash           = 0;
		day            = 0;
		initItemsAndStaff();
		new SimState(this);
	}


	/**
	 * Initiate starting objects.
	 * Adds items to the inventory
	 */
	public void initItemsAndStaff() {
		staff.add(new Clerk());
		staff.add(new Clerk());
		staff.add(new Trainer());
		staff.add(new Trainer());

		// (size, color, broken, purebred) / (breed, age, health)
		inventory.add(new Dog(Double.parseDouble(sizeFormat.format(new Random().nextDouble(50))), Color.values()[new Random().nextInt(Color.values().length)] /*colors.get(new Random().nextInt(colors.size()))*/, randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)]));
		// (color, broken, purebred) / (breed, age, health)
		inventory.add(new Cat(colors.get(new Random().nextInt(colors.size())), randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)]));
		// (size, mimicry, exotic, papers) / (breed, age, health)
		inventory.add(new Bird(Double.parseDouble(sizeFormat.format(new Random().nextDouble(8))), randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)]));

		inventory.add(new Food(new Random().nextInt(100), Animal.values()[new Random().nextInt(Animal.values().length)], Type.values()[new Random().nextInt(Type.values().length)]));
		inventory.add(new CatLitter(new Random().nextInt(100)));
		inventory.add(new Toy(Animal.values()[new Random().nextInt(Animal.values().length)]));
		inventory.add(new Leash(Animal.values()[new Random().nextInt(Animal.values().length)]));
		// inventory.add()

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
						currentStaff.incWorkDays();
						currentStaff.arrival();
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
		currentStaff.setInventory(this.inventory);
		currentStaff.setSickPet(this.sick);
		currentStaff.setMailBox(this.mailBox);
		currentStaff.setCash(this.cash);
		currentStaff.incWorkDays();

		currentStaff.arrival();
	}


	public void openStore() {
		int count = attractCustomers(new SecureRandom().nextInt(3, 10));
		System.out.println(currentStaff.getName() + " opens the store. \nCurrent inventory: " + inventory.size() + " item(s)\nRegister: " + cash);
		System.out.println(count + " potential customers enter the store...");
		boolean buyAtListPrice = new SecureRandom().nextInt(100) < 50;

		customers.forEach(customer -> {
			boolean selecting = customer.inspectInventory(inventory);

			if (selecting) {
				inventory.remove(customer.obj);
				System.out.println("[+] The customer has made a selection!");
				System.out.println("[+] The customer purchases " + customer.obj.getName() + " at $" + customer.getPurchasePrice() + (customer.discount ? " after a 10% discount" : "")) ;
				cash += customer.getPurchasePrice();
				customer.obj.setDaySold(day);
				soldItems.add(customer.obj);
			}
		});
		currentStaff.setCash(cash); // 2 way binding
		System.out.println("\nCurrent inventory: " + inventory.size() + " item(s)\nCash: " + cash);
	}


	private int attractCustomers(int count) {
		customers.clear();
		for (int i = 0; i < count; i++) {
			customers.add(new Customer());
		}
		
		return count;
	}


	public void updateInventory() {
		this.inventory = currentStaff.getInventory();
	}


	public void updateSickAnimal() {
		this.sick = currentStaff.getSickAnimal();
	}


	public void updateMailBox() {
		this.mailBox = currentStaff.getMailBox();
	}


	public void updateCash() {
		this.cash = currentStaff.getCash();
	}


	public void goToBank() {
		currentStaff.goToBank();
		addWithdrawal();
	}

	/**
	 * withdraw cash -> cash += withdrawal
	 */
	private void addWithdrawal() {
		System.out.println("$1000.00 was withdrawn from the bank.");
		cash += currentStaff.getCash();
		bankWithdrawal += 1000;
		System.out.println("Total withdrawal: " + bankWithdrawal);
		System.out.println("Total cash: "  + cash);
	}


	public double getCash() {
		return cash;
	}

	public boolean checkRegister() {
		return this.getCash() > 200;
	}


	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public ArrayList<Pet> getSick() {
		return sick;
	}

	public ArrayList<Item> getSoldItems() {
		return this.soldItems;
	}
}


