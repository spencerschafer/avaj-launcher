public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Flyable aircraft = null;
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        switch (type) {
            case "balloon":
                aircraft = new Balloon(name, coordinates);
                break;
            case "jetplane":
                aircraft = new JetPlane(name, coordinates);
                break;
            case "helicopter":
                aircraft = new Helicopter(name, coordinates);
                break;
        }
        return aircraft;
    }
}
