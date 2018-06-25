public class WeatherTower extends Tower {

    //TODO
    public String getWeather(Coordinates coordinates) {
        //call WeatherProvider to return weather condition
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    //TODO
    void changeWeather() {
        //call conditionsChanged()
        //honestly not sure what needs to be done here
        //but instead of a call to the Tower class I would randomise the weather here and make a call to getWeather
        //to return the weather that was just changed
        //i,e this class changes the weather and getWeather just returns the current weather
        conditionsChanged();
    }
}
