import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    //update each condition of each aircraft per required iteration
    protected void conditionsChanged() {
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
}
