public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        System.out.print("Balloon    #" + this.name + " (" + this.id + "): ");

        switch (weather) {
            case "SUN":
                coordinates.changeCoordinates(2, 0, 4);
                sendMessage(weather);
                break;
            case "RAIN":
                coordinates.changeCoordinates(0, 0, -5);
                sendMessage(weather);
                break;
            case "FOG":
                coordinates.changeCoordinates(0, 0, -3);
                sendMessage(weather);
                break;
            case "SNOW":
                coordinates.changeCoordinates(0, 0, -15);
                sendMessage(weather);
                break;
        }

        if (this.coordinates.checkHeight() == -1) {
            System.out.println("Balloon    #" + this.name + " (" + this.id + "): Landing.");
            System.out.println("Tower:     Balloon " + this.name + " (#" + this.id + ") deregistered from weather tower.");
            this.weatherTower.setRemoveObserverTrue();
        } else if (this.coordinates.checkHeight() == 1) {
            this.coordinates.setUpperLimit();
            //System.out.println("Cannot go higher than 100, restricting height.");
        }
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        weatherTower = WeatherTower;
        weatherTower.register(this);
        System.out.println("Tower:     Balloon    #" + this.name + " (" + this.id + ") registered to weather tower.");
    }
}
