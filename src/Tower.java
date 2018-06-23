import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers = new ArrayList<>();

	//TODO
	protected void conditionsChanged() {
		System.out.println("Conditions have changed");
	}

	public void register(Flyable flyable) {
			observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
	    observers.remove(flyable);
	}

	//REMOVE THIS FUNCTION - tests if aircraft were registered
	public void printArray() {
		if (observers.size() == 0) {
			System.out.println("\nNO AIRCRAFT REGISTERED");
		}
		System.out.println();
		for (Flyable item : observers) {
			System.out.println("REGISTERED: " + item);
		}
	}
}
