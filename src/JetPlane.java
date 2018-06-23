public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	@Override
	public void updateConditions() {
		System.out.println("JetPlane conditions updated");

	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		//this.weatherTower = WeatherTower;
		//weatherTower.register(this);
		System.out.println("TOWER: JetPlane " + this.name + " registered to weather tower.");

	}

	protected String getClassType() {
		return JetPlane.class.getSimpleName();
	}
}

/*
◦ SUN - Latitude increases with 10, Height increases with 2 ◦ RAIN - Latitude increases with 5
◦ FOG - Latitude increases with 1
◦ SNOW - Height decreases with 7
 */
