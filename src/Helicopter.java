public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
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
