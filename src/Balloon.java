public class Balloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Balloon(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	@Override
	public void updateConditions() {
		System.out.println("Balloon conditions updated");
	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		this.weatherTower = WeatherTower;
		weatherTower.register(this);
		System.out.printf("Registered with weather tower.");
	}

	protected String getClassType() {
		return Balloon.class.getSimpleName();
	}
}
