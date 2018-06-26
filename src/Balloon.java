public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                coordinates.changeCoordinates(2, 0, 4);
                System.out.println("Balloon " + this.name + " (#" + this.id + ") weather is SUN");
                break;
            case "RAIN":
                coordinates.changeCoordinates(0, 0, -5);
                System.out.println("Balloon " + this.name + " (#" + this.id + ") weather is RAIN");
                break;
            case "FOG":
                coordinates.changeCoordinates(0, 0, -3);
                System.out.println("Balloon " + this.name + " (#" + this.id + ") weather is FOG");
                break;
            case "SNOW":
                coordinates.changeCoordinates(0, 0, -15);
                System.out.println("Balloon " + this.name + " (#" + this.id + ") weather is SNOW");
                break;
        }

        if (this.coordinates.checkHeight() == -1) {
            System.out.println("TOWER: Balloon " + this.name + " (#" + this.id + ") deregistered from weather tower.");
            printCoordinates();
            this.weatherTower.unregister(this);
        } else if (this.coordinates.checkHeight() == 1) {
            this.coordinates.setUpperLimit();
            System.out.println("Cannot go higher than 100, restricting height.");
        }
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        weatherTower = WeatherTower;
        weatherTower.register(this);
        System.out.println("TOWER: Balloon " + this.name + " (#" + this.id + ") registered to weather tower.");
    }

}
