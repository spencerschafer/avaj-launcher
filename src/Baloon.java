public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	@Override
	public void updateConditions() {

	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {

	}
}
