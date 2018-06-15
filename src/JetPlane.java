public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	@Override
	public void updateConditions() {

	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		this.weatherTower = WeatherTower;
		weatherTower.register(this);
		System.out.printf("Registered with weather tower.");

	}

	protected String getClassType() {
		return JetPlane.class.getSimpleName();
	}
}
