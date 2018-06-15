public class Aircraft {
    private static long idCounter;
    protected long id = 0;
    protected String name;
    protected Coordinates coordinates;

    Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        nextId();
    }

    Aircraft() {
        this.name = "default";
        this.coordinates = new Coordinates(0, 0, 0);
        nextId();
    }

    private long nextId() {
        id++;
        return this.id;
    }

    protected String getClassType() {
        return Aircraft.class.getSimpleName();
    }
}
