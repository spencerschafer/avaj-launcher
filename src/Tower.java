import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers;

	protected void conditionsChanged() {
		System.out.println("Conditions have changed");
	}

	public void register(Flyable flyable) {
		try {
			this.observers.add(flyable);
			System.out.println("TOWER: Registered " + flyable + " to the tower.");
		} catch (Exception e) {
			System.out.println("TOWER: Failed to register aircraft of type " + Flyable.class.getName() + ".");
		}
	}

	public void unregister(Flyable flyable) {
	    //observers.remove(flyable);
		System.out.println("TOWER: Unregistered " + flyable + " from the tower");
	}
}
