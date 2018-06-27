package Aircraft;

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

    //own function for debugging
    public void printCoordinates() {
        System.out.printf("\n(" + this.coordinates.getLongitude() + ")");
        System.out.printf("(" + this.coordinates.getLatitude() + ")");
        System.out.printf("(" + this.coordinates.getHeight() + ")\n");
    }

    public void sendMessage(String weather) {

        int message = (int) (Math.random() * 3);

        String[] sun = {"This is hot!", "Wow, what a view!", "Just Beautiful."};
        String[] rain = {"Everything is getting a wash!", "Get your raincoats!", "I'm getting soaked!"};
        String[] fog = {"I can't see a thing!", "Visibility is low, be careful!", "I can't see my hands!"};
        String[] snow = {"Keep an eye out for snowballs!", "Good thing I brought extra socks.", "It's freezing!"};

        switch (weather) {
            case "SUN":
                System.out.println(sun[message]);
                break;
            case "RAIN":
                System.out.println(rain[message]);
                break;
            case "FOG":
                System.out.println(fog[message]);
                break;
            case "SNOW":
                System.out.println(snow[message]);
        }
    }
}
