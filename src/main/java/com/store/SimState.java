package main.java.com.store;
import java.util.ArrayList;
import java.util.List;




public class SimState {
	// Package level access, static, state control variables
	static State newDay, startDay, endDay, processDelivery, orderSupplies, checkInventory, visitBank, checkRegister, doInventory;
	static State       currentState;
	static State       endState;
	static State       previousState;
	static List<State> stateList;

	static boolean RUNNING;
	Store store;


	public SimState(Store sim) {
		stateList = new ArrayList<State>();
		store = sim;
		newDay = new NewDay(this);
		startDay = new StartDay(this);
		endDay = new EndDay(this);
		checkInventory = new CheckInventory(this);
		orderSupplies = new OrderSupplies(this);
		visitBank = new VisitBank(this);
		checkRegister = new CheckRegister(this);
		doInventory = new DoInventory(this);
		processDelivery = new ProcessDelivery(this);
		RUNNING = true;

		stateList.add(startDay);
		stateList.add(endDay);
		stateList.add(checkInventory);
		stateList.add(orderSupplies);
		stateList.add(visitBank);
		stateList.add(checkRegister);
		stateList.add(doInventory);
		goNewDay();
	}


	public void setStoreState(State state) {
		previousState = currentState;
		currentState = state;
		// currentState.enterState();
	}


	public void goNewDay() {
		currentState = newDay;
		currentState.enterState();
	}



	public State goStartDay() {return startDay;	}


	public State goProcessDelivery() {return processDelivery;}
	
	public State goCheckRegister() {return checkRegister; }


	public State goVisitBankState() {return visitBank;}


	public State goCheckInventory() {return checkInventory;}


	public State goDoInventory() {return doInventory;}
	
	
	public State goOpenStore() {return openStore; }
	
	
	public State goClaenStore() { return cleanStore; }


	public State goEndDay() {return endDay;	}


	public void goEnterState() {currentState.enterState();}


	// public void update() {stateList.forEach(state -> state.update(this));}

}




class NewDay implements State {
	SimState simState;


	NewDay(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {

		simState.store.day++;
		simState.store.selectStaff();
		System.out.println("Day: " + simState.store.day + "\n");
		nextState();
	}


	@Override
	public void exitState() {
		// simState.startTheDay();
		//TODO : temporary 
		simState.goEnterState();
	}


	@Override
	public void nextState() {
		// simState.update();
		simState.setStoreState(simState.goStartDay());
		exitState();
	}

}




/**
 * Start day.
 * <p>
 * Daily route starting point.
 */
class StartDay implements State {
	SimState simState;


	public StartDay(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {
		System.out.println("Total Store Cash: " + simState.store.getCash());
		if (simState.store.cash < 200.0) {
			simState.setStoreState(simState.goVisitBankState());
			nextState();
		}
	}


	@Override
	public void exitState() {
		simState.goEnterState();

		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	public void nextState() {
		// simState.update();
		simState.setStoreState(simState.goProcessDelivery());
		simState.setStoreState(simState.goCheckInventory());
		exitState();
	}

}




class ProcessDelivery implements State {

	SimState simState;


	public ProcessDelivery(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {
		simState.store.currentStaff.processDeliveries();
	}


	@Override
	public void exitState() {
		simState.goEnterState();


	}


	@Override
	public void nextState() {

	}


	

}




/**
 * End day.
 * Completion of daily route.
 * <p>
 * Clean-up and preparation for sequence restart.
 */
class EndDay implements State {
	SimState simState;


	public EndDay(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {
		// TODO: 4
		nextState();
	}


	@Override
	public void exitState() {
		simState.goNewDay();
	}


	@Override
	public void nextState() {
		System.out.println("The workday ends...");
		// simState.setStoreState(simState.goEndDay());
		exitState();
	}

}




class DoInventory implements State {
	SimState simState;


	public DoInventory(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {
		// if approriate, call orderSupplies
		if (simState.store.currentStaff.doInventory()) {
			simState.setStoreState(simState.goOrderSupplies());
		}
	}


	@Override
	public void exitState() {
		simState.goEnterState();

		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	public void nextState() {

	}

}




class CheckRegister implements State {
	SimState simState;
	double   totalWithdrawn = 0;


	public CheckRegister(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {
		if (!simState.store.checkRegister()) {
			System.out.println("Register cash is low... ");
			simState.setStoreState(simState.goVisitBankState());
		} else {
			System.out.println("Cash is sufficient.");
		}
	}


	@Override
	public void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
		simState.store.currentStaff.processInventory();
		simState.goEnterState();
	}


	@Override
	public void nextState() {
		totalWithdrawn = simState.store.bankWithdrawal;
		System.out.println("Total Bank Withdraw: " + totalWithdrawn);
		System.out.println("Register: " + simState.store.getCash());
		simState.setStoreState(simState.goDoInventory());
		exitState();

	}

}




/**
 * Order supplies.
 */
class OrderSupplies implements State {
	SimState simState;


	public OrderSupplies(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {
		simState.setStoreState(simState.goOrderSupplies());
		simState.goEnterState();
		simState.setStoreState(SimState.previousState);

		simState.store.currentStaff.placeAnOrder();
	}


	@Override
	public void exitState() {
		simState.goEnterState();

		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	public void nextState() {
		simState.store.updateCash();
		simState.store.updateMailBox();
		simState.store.updateInventory();
	}

}




class CheckInventory implements State {
	SimState simState;


	public CheckInventory(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {
		simState.store.currentStaff.feedAnimals();
	}


	@Override
	public void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	public void nextState() {
		simState.store.updateInventory();
		simState.store.updateSickAnimal();
	}

}




class VisitBank implements State {
	SimState simState;


	public VisitBank(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {
		simState.store.goToBank();
		exitState();
	}


	@Override
	public void exitState() {
		// simState.update();
		simState.setStoreState(SimState.previousState);
	}


	@Override
	public void nextState() {

	}

}
