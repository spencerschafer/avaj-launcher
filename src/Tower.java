import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers;

	protected void conditionsChanged() {
		System.out.println("Conditions have changed");
	}

	public void register(Flyable flyable) {
	    observers.add(flyable);
		System.out.printf("TOWER: Registered " + flyable + " to the tower");
	}

	public void unregister(Flyable flyable) {
	    observers.remove(flyable);
		System.out.printf("TOWER: Unregistered " + flyable + " from the tower");
	}
}
