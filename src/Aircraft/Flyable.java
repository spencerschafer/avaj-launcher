package Aircraft;

import Weather.WeatherTower;

public interface Flyable {

    void updateConditions();

    void registerTower(WeatherTower WeatherTower);
}
