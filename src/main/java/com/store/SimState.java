package main.java.com.store;


public class SimState {
	// Package level access, static, state control variables
	static State startDay, endDay, orderSupplies, checkInventory, visitBank;
	static State currentState;
	static State endState;
	static boolean  RUNNING;
	Store store;


	public SimState(Store sim) {
		store = sim;
		startDay = new StartDay(this);
		endDay = new EndDay(this);
		checkInventory = new CheckInventory(this);
		orderSupplies = new OrderSupplies(this);
		visitBank = new VisitBank(this);
		// currentState = startDay;
		RUNNING = true;
		// TODO: Design endState and program clean exit.

		/*if (cash < 0) {
			currentState = visitBank;
		}*/

		// Initial Entry
		startTheDay();
	}


	public void startTheDay() {
		currentState = startDay;
		currentState.enterState();
	}
	
	
	public void setStoreState(State state) {
		currentState = state;
	}

	
	public State goVisitBankState() {
		currentState = visitBank;
		currentState.enterState();
		return currentState;
	}

	public void exitStoreState() {
		currentState.exitState();
	}


	public void nextStoreState() {
		currentState.nextState();

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
		simState.store.day++;
		simState.store.selectStaff();
		System.out.println("Total Store Cash: " + simState.store.getCash());
		if (simState.store.cash < 200.0) {
			simState.store.GoToBank();
		}
		

	}


	@Override
	public void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	public void nextState() {
		// this.simState = 
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

	}


	@Override
	public void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	public void nextState() {
		// this.simState =
	}

}




/**
 * Order supplies.
 */
class OrderSupplies implements State {
	SimState simState;


	public OrderSupplies(SimState simState) {
		super();
		this.simState = simState;
	}


	@Override
	public void enterState() {
		// TODO: Get price cap
		if (simState.store.cash <= 0) {
			simState.setStoreState(simState.goVisitBankState());
		}
	}


	@Override
	public void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	public void nextState() {
		
	}

}




class CheckInventory implements State {
	SimState simState;


	public CheckInventory(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {

	}


	@Override
	public void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	public void nextState() {
		
	}

}




class VisitBank implements State {
	SimState simState;


	public VisitBank(SimState simState) {
		this.simState = simState;
	}


	@Override
	public void enterState() {

	}


	@Override
	public void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	public void nextState() {

	}

}
