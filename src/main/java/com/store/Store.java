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
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;




public class Store {
	/**
	 * The stores Inventory.
	 */
	ArrayList<Item>     inventory;
	ArrayList<Employee> staff;
	Employee            currentStaff;
	ArrayList<Pet>      sick;
	double              bankWithdrawal;
	double              cash;
	int                 day;

	protected final ArrayList<String> colors              = new ArrayList<String>(Arrays.asList("black", "brown", "white", "gray", "red"));
	protected final boolean[]         randomSelectionbool = {true, false};


	/**
	 * Instantiates a new Store.
	 * Main entry point.
	 * <p>
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
		inventory.add(new Dog(new Random().nextDouble(50.0), colors.get(new Random().nextInt(colors.size())), randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)]));
		// (color, broken, purebred) / (breed, age, health)
		inventory.add(new Cat(colors.get(new Random().nextInt(colors.size())), randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)]));
		// (size, mimicry, exotic, papers) / (breed, age, health)
		inventory.add(new Bird(new Random().nextDouble(8.0), randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)], randomSelectionbool[new Random().nextInt(1)]));
		inventory.add(new Food(new Random().nextInt(100), Animal.values()[new Random().nextInt(Animal.values().length)], Type.values()[new Random().nextInt(Type.values().length)]));
		inventory.add(new CatLiter(new Random().nextInt(100)));
		inventory.add(new Leash(Animal.values()[new Random().nextInt(Animal.values().length)]));

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
		currentStaff.incWorkDays();
		// Active employee announcement
		currentStaff.arrival();
	}


	public void doInventory() {
		
	}

	public void updateInventory(ArrayList<Item> updatedInventory) {
		this.inventory = updatedInventory;
	}

	public void GoToBank() {
		currentStaff.announce(" goes to the bank...");
		addWithdrawal();
		addCash(1000);
		
	}


	private void addWithdrawal() {
		this.bankWithdrawal += 1000;
		System.out.println("$1000 was withdrawn from the bank.");
	}


	public double getCash() {
		return cash;
	}


	public void addCash(double cash) {
		this.cash += cash;
		if (cash < 0) {
			System.out.println("$" + cash + " was removed from the register.");
		}
		else {
			System.out.println("$" + cash + " was added to the register.");			
		}
	}

}


