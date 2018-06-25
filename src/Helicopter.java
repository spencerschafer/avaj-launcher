public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    //TODO
    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                coordinates.changeCoordinates(10, 0, 2);
                System.out.println("Helicopter " + this.name + " (#" + this.id + ") weather is SUN");
                break;
            case "RAIN":
                coordinates.changeCoordinates(5, 0, 0);
                break;
            case "FOG":
                coordinates.changeCoordinates(1, 0, 0);
                break;
            case "SNOW":
                coordinates.changeCoordinates(0, 0, -12);
                break;
        }
        if (this.coordinates.checkHeight() == -1) {
            weatherTower.unregister(this);
            System.out.println("TOWER: Helictoper " + this.name + " (#" + this.id + ") deregistered from weather tower.");
        }
        else if (this.coordinates.checkHeight() == 1) {
            this.coordinates.setUpperLimit();
            System.out.println("Cannot go higher than 100, limiting height.");
        }
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        this.weatherTower = WeatherTower;
        weatherTower.register(this);
        System.out.println("TOWER: Helicopter " + this.name + " (#" + this.id + ") registered to weather tower.");
    }
}

/*
◦ SUN - Longitude increases with 10, Height increases with 2
◦ RAIN - Longitude increases with 5
◦ FOG - Longitude increases with 1
◦ SNOW - Height decreases with 12
 */
