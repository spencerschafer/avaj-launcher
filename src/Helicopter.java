public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
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
		return Helicopter.class.getSimpleName();
	}
}
