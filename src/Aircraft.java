public class Aircraft {
    protected String name;
    protected Coordinates coordinates;
    protected long id;

    private static long idCounter = 0;

    Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    Aircraft() {
        this.name = "default";
        this.coordinates = new Coordinates(0, 0, 0);
        id = nextId();
    }

    private long nextId() {
        idCounter++;
        id = idCounter;
        return this.id;
    }
}
