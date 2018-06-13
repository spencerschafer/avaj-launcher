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
		this.weatherTower = WeatherTower;
		System.out.printf("Registered with weather tower.");
		weatherTower.getWeather(coordinates);

	}

	protected String getClassType() {
		return Helicopter.class.getSimpleName();
	}
}
