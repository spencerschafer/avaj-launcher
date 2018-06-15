public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return ("Returned Weather: getWeather()");
    }

    void changeWeather() {
        System.out.println("Weather has changed");
    }
}
