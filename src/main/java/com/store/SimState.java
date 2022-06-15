package main.java.com.store;


public abstract class SimState extends Store {
	public static SimState startDay, endDay, orderSupplies, checkInventory, visitBank;
	public static SimState currentState;


	public SimState() {
		startDay = new StartDay(this);
		endDay = new EndDay(this);
		checkInventory = new CheckInventory(this);
		orderSupplies = new OrderSupplies(this);
		visitBank = new VisitBank(this);
		currentState = startDay;

		if (cash < 0) {
			currentState = visitBank;
		}

		currentState.enterState();
	}


	abstract void enterState();


	abstract void exitState();

}




class StartDay extends SimState {
	SimState simState;


	public StartDay(SimState simState) {
		this.simState = simState;
	}


	@Override
	void enterState() {
		day++;
		
	}


	@Override
	void exitState() {

	}

}




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

	}

}




class OrderSupplies extends SimState {
	SimState simState;


	public OrderSupplies(SimState simState) {
		this.simState = simState;
	}


	@Override
	void enterState() {

	}


	@Override
	void exitState() {

	}

}




class CheckInventory extends SimState {
	SimState simState;


	public CheckInventory(SimState simState) {
		this.simState = simState;
	}


	void enterState() {

	}


	void exitState() {

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

	}

}
