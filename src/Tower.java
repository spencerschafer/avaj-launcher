import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers = new ArrayList<>();

	//TODO
	protected void conditionsChanged() {
		//update each condition of each aircraft per required iteration
	    for (int i = 0; i < observers.size(); ++i) {
	    	observers.get(i).updateConditions();
		}
	}

	public void register(Flyable flyable) {
			observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
	    observers.remove(flyable);
	}

	//REMOVE THIS FUNCTION - tests if aircraft were registered
	public void printStatus() {
		if (observers.size() == 0) {
			System.out.println("\nNO AIRCRAFT REGISTERED");
		}
		System.out.println();
		for (Flyable item : observers) {
			System.out.println("REGISTERED: " + item);
		}
	}
}
