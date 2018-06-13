public class Balloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Balloon(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	@Override
	public void updateConditions() {

	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {

	}

	protected String getClassType() {
		return Balloon.class.getSimpleName();
	}
}
