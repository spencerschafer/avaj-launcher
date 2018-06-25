public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    //TODO
    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                coordinates.changeCoordinates(0, 10, 2);
                System.out.println("JetPlane " + this.name + " (#" + this.id + ") weather is SUN");
                break;
            case "RAIN":
                coordinates.changeCoordinates(0, 5, 0);
                break;
            case "FOG":
                coordinates.changeCoordinates(0, 1, 0);
                break;
            case "SNOW":
                coordinates.changeCoordinates(0, 0, -7);
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
			System.out.println("TOWER: Balloon " + this.name + " (#" + this.id + ") deregistered from weather tower.");
		}

    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        this.weatherTower = WeatherTower;
        weatherTower.register(this);
        System.out.println("TOWER: JetPlane " + this.name + " (#" + this.id + ") registered to weather tower.");

    }
}

/*
◦ SUN - Latitude increases with 10, Height increases with 2
◦ RAIN - Latitude increases with 5
◦ FOG - Latitude increases with 1
◦ SNOW - Height decreases with 7
 */
