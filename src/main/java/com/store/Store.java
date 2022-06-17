package main.java.com.store;
import main.java.com.item.Item;
import main.java.com.item.pet.*;
import main.java.com.item.supplies.CatLiter;
import main.java.com.item.supplies.Food;
import main.java.com.item.supplies.Leash;
import main.java.com.item.supplies.Type;
import main.java.com.staff.Clerk;
import main.java.com.staff.Employee;
import main.java.com.staff.Trainer;

import java.text.DecimalFormat;
import java.util.*;



public class Store {
	// The store's Inventory.
	ArrayList<Item> inventory;
	ArrayList<Pet>  sick;

	ArrayList<DeliveryPackage> mailBox;



	// The store's staff
	ArrayList<Employee> staff;
	Employee            currentStaff;

	// Money + day management
	double bankWithdrawal;
	double cash;
	int    day;

	// Data helpers
	DecimalFormat sizeFormat = new DecimalFormat("#####.00");
	protected final ArrayList<String> colors              = new ArrayList<String>(Arrays.asList("Black", "Brown", "White", "Gray", "Red"));
	protected final boolean[]         randomSelectionbool = {true, false};


	/**
	 * Instantiates a new Store.
	 * Main entry point.
	 * 
	 * Default constructor
	 */
	public Store() {
		staff = new ArrayList<Employee>();
		inventory = new ArrayList<Item>();
		sick = new ArrayList<Pet>();
		bankWithdrawal = 0;
		cash = 0;
		day = 0;
		initItemsAndStaff();
		new SimState(this);
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

		// (size, color, broken, purebred) / (breed, age, health)
		inventory.add(new Dog(Double.parseDouble(sizeFormat.format(new Random().nextDouble(50))), Color.values()[new Random().nextInt(Color.values().length)] /*colors.get(new Random().nextInt(colors.size()))*/, randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)]));
		// (color, broken, purebred) / (breed, age, health)
		inventory.add(new Cat(colors.get(new Random().nextInt(colors.size())), randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)]));
		// (size, mimicry, exotic, papers) / (breed, age, health)
		inventory.add(new Bird(Double.parseDouble(sizeFormat.format(new Random().nextDouble(8))), randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)]));		
		
		inventory.add(new Food(new Random().nextInt(100), Animal.values()[new Random().nextInt(Animal.values().length)], Type.values()[new Random().nextInt(Type.values().length)]));
		inventory.add(new CatLiter(new Random().nextInt(100)));
		inventory.add(new Leash(Animal.values()[new Random().nextInt(Animal.values().length)]));

	}


	/**
	 * Select staff to man store for this day.
	 * 
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
		// Active employee announcement
		currentStaff.arrival();
	}


	public void doInventory() {

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

	/**
	 * the mailbox
	 * @return mailBox
	 */
	public ArrayList<DeliveryPackage> getMailbox() {
		return this.mailBox;
	}


	public void goToBank() {
		currentStaff.GoToBank();
		addWithdrawal();
	}


	private void addWithdrawal() {
		this.bankWithdrawal += 1000.00;
		System.out.println("$1000.00 was withdrawn from the bank.");
		addCash(1000.00);
	}


	public double getCash() {
		return cash;
	}


	public void addCash(double cash) {
		this.cash = Double.parseDouble(sizeFormat.format(this.cash += cash));
		if (cash < 0) {
			System.out.println("$" + cash + " was removed from the register.");
		}
		else {
			System.out.println("$" + cash + " was added to the register.");
		}
	}

}


