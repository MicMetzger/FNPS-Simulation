package main.java.com.store;


public abstract class SimState extends Store {
	// Package level access, static, state control variables
	static SimState startDay, endDay, orderSupplies, checkInventory, visitBank;
	static SimState currentState;
	static SimState endState;
	static boolean  RUNNING;


	public SimState() {
		startDay = new StartDay(this);
		endDay = new EndDay(this);
		checkInventory = new CheckInventory(this);
		orderSupplies = new OrderSupplies(this);
		visitBank = new VisitBank(this);
		currentState = startDay;
		RUNNING = true;
		// TODO: Design endState and program clean exit.

		/*if (cash < 0) {
			currentState = visitBank;
		}*/

		// Initial Entry
		currentState.enterState();
	}


	abstract void enterState();


	abstract void exitState();


	abstract void nextState();

}




/**
 * Start day.
 * <p>
 * Daily route starting point.
 */
class StartDay extends SimState {
	SimState simState;


	public StartDay(SimState simState) {
		this.simState = simState;
	}


	@Override
	void enterState() {
		day++;
		selectStaff(); // TODO: %%%% Left Off %%%%
	}


	@Override
	void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	void nextState() {
		// this.simState = 
	}

}




/**
 * End day.
 * Completion of daily route.
 * <p>
 * Clean-up and preparation for sequence restart.
 */
class EndDay extends SimState {
	SimState simState;


	public EndDay(SimState simState) {
		this.simState = simState;
	}


	@Override
	void enterState() {

	}


	@Override
	void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	void nextState() {
		// this.simState =
	}

}




/**
 * Order supplies.
 */
class OrderSupplies extends SimState {
	SimState simState;


	public OrderSupplies(SimState simState) {
		this.simState = simState;
	}


	@Override
	void enterState() {
		// TODO: Get price cap
		if (cash <= 0) {
			currentState = visitBank;
		}
	}


	@Override
	void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	void nextState() {
		// this.simState =
	}

}




class CheckInventory extends SimState {
	SimState simState;


	public CheckInventory(SimState simState) {
		this.simState = simState;
	}


	@Override
	void enterState() {

	}


	@Override
	void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	void nextState() {
		// this.simState =
	}

}




class VisitBank extends SimState {
	SimState simState;


	public VisitBank(SimState simState) {
		this.simState = simState;
	}


	@Override
	void enterState() {

	}


	@Override
	void exitState() {
		// TODO: update information and report. Afterwards, call nextState()
	}


	@Override
	void nextState() {
		// this.simState =
	}

}
