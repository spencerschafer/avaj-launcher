public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    //TODO
    @Override
    public void updateConditions() {
        //make a call to get the current weather
        //changed coordinates depending on the current weather
        //relevant changes to coordinates are at the bottom of this class

        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                coordinates.changeCoordinates(2, 0, 4);
                System.out.println("Balloon " + this.name + " (#" + this.id + ") weather is SUN");
                break;
            case "RAIN":
                coordinates.changeCoordinates(0, 0, -5);
                break;
            case "FOG":
                coordinates.changeCoordinates(0, 0, -3);
                break;
            case "SNOW":
                coordinates.changeCoordinates(0, 0, -15);
                break;
        }

        if (this.coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            System.out.println("TOWER: Balloon " + this.name + " (#" + this.id + ") deregistered from weather tower.");
        }
    }


    @Override
    public void registerTower(WeatherTower WeatherTower) {
        weatherTower = WeatherTower;
        weatherTower.register(this);
        System.out.println("TOWER: Balloon " + this.name + " (#" + this.id + ") registered to weather tower.");
    }
}

/*
◦ SUN - Longitude increases with 2, Height increases with 4
◦ RAIN - Height decreases with 5
◦ FOG - Height decreases with 3
◦ SNOW - Height decreases with 15
 */
