public class WeatherTower extends Tower {

    //calls weatherProvider to return weather condition
    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    //uses the allocated weatherTower to make the function call to the parent class to change weather
    void changeWeather() {
        conditionsChanged();
    }
}
