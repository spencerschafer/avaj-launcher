public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

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
                System.out.println("JetPlane " + this.name + " (#" + this.id + ") weather is RAIN");
                break;
            case "FOG":
                coordinates.changeCoordinates(0, 1, 0);
                System.out.println("JetPlane " + this.name + " (#" + this.id + ") weather is FOG");
                break;
            case "SNOW":
                coordinates.changeCoordinates(0, 0, -7);
                System.out.println("JetPlane " + this.name + " (#" + this.id + ") weather is SNOW");
                break;
        }

        if (this.coordinates.checkHeight() == -1) {
            System.out.println("TOWER: JetPlane " + this.name + " (#" + this.id + ") deregistered from weather tower.");
            printCoordinates();
            this.weatherTower.unregister(this);
        } else if (this.coordinates.checkHeight() == 1) {
            this.coordinates.setUpperLimit();
            System.out.println("Cannot go higher than 100, restricting height.");
        }
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        this.weatherTower = WeatherTower;
        weatherTower.register(this);
        System.out.println("TOWER: JetPlane " + this.name + " (#" + this.id + ") registered to weather tower.");

    }
}
