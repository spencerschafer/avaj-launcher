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

    public void printName() {
        System.out.println("AIRCRAFT NAME: " + this.name);
    }

    public void printCoordinates() {
        System.out.printf("\n(" + this.coordinates.getLongitude() + ")");
        System.out.printf("(" + this.coordinates.getLatitude() + ")");
        System.out.printf("(" + this.coordinates.getHeight() + ")\n");
    }
}
