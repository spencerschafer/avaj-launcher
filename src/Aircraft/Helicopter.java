package Aircraft;

import Weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        System.out.print("Helicopter #" + this.name + " (" + this.id + "): ");
        switch (weather) {
            case "SUN":
                coordinates.changeCoordinates(10, 0, 2);
                sendMessage(weather);
                break;
            case "RAIN":
                coordinates.changeCoordinates(5, 0, 0);
                sendMessage(weather);
                break;
            case "FOG":
                coordinates.changeCoordinates(1, 0, 0);
                sendMessage(weather);
                break;
            case "SNOW":
                coordinates.changeCoordinates(0, 0, -12);
                sendMessage(weather);
                break;
        }

        if (this.coordinates.checkHeight() == -1) {
            System.out.println("Helicopter #" + this.name + " (" + this.id + "): Landing.");
            System.out.println("Tower:     Helicopter " + this.name + " (#" + this.id + ") deregistered from weather tower.");
            this.weatherTower.setRemoveObserverTrue();
        } else if (this.coordinates.checkHeight() == 1) {
            this.coordinates.setUpperLimit();
            //System.out.println("Cannot go higher than 100, restricting height.");
        }
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        this.weatherTower = WeatherTower;
        weatherTower.register(this);
        System.out.println("Tower:     Helicopter #" + this.name + " (" + this.id + ") registered to weather tower.");
    }
}
