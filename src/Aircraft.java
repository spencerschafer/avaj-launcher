public class Aircraft {
    protected String name;
    protected Coordinates coordinates;
    protected long id;

    private static long idCounter = 0;


    //unused constructor as specific aircraft class sets the values
    Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    //default constructor
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

    //own function
    public void printCoordinates() {
        System.out.printf("\n(" + this.coordinates.getLongitude() + ")");
        System.out.printf("(" + this.coordinates.getLatitude() + ")");
        System.out.printf("(" + this.coordinates.getHeight() + ")\n");
    }
}
