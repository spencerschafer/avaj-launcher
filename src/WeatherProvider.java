public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String weather[] = {"SUN", "RAIN", "FOG", "SNOW"};

    //TODO
    private WeatherProvider() {
        //not sure what to do here
        //probably just initialise weatherProvider to some preset value
    }

    //just return weatherProvider to be used by WeatherTower
    public static WeatherProvider getProvider() {
        return (weatherProvider);
    }

    //randomise value to return integer between 1 and 4 to select weather condition from array
    public String getCurrentWeather(Coordinates coordinates) {
        int index = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return (weather[index % 4]);
    }
}
