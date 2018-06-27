package Weather;
import Aircraft.Flyable;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
    private boolean removeObserver = false;
    private int sizeOfObservers = 0;

    //update each condition of each aircraft per required iteration
    protected void conditionsChanged() {
        sizeOfObservers = observers.size();
        for (int i = 0; i < sizeOfObservers; ++i) {
            observers.get(i).updateConditions();

            /*
            when observer was removed the size of observers decreased by 1 but the value of i remained the same
            therefore i was accessing the next value in the array
            i.e i = 3: With an array of size 6: {a,b,c,d,e,f} then we removed array[3]: {a,b,c,e,f}
            i.e i = 3: With an array of size 5. {a,b,c,e,f} then if we access array[3]: then our value is 'e'
            but in the current loop we still wanted to print the value of 'd' therefore we had to remove the value
            'd' but also decrease i by 1 to access 'e' and not 'f'
            */
            if (removeObserver == true) {
                setRemoveObserverFalse();
                unregister(observers.get(i));
                sizeOfObservers = observers.size();
                --i;
            }
        }
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    public void setRemoveObserverTrue() {
        this.removeObserver = true;
    }

    public void setRemoveObserverFalse() {
        this.removeObserver = false;
    }
}
