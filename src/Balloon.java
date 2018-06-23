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
		//weatherTower = WeatherTower;
		//weatherTower.register(this);
		System.out.println("TOWER: Balloon " + this.name + " registered to weather tower.");
	}

	protected String getClassType() {
		return Balloon.class.getSimpleName();
	}
}

/*
◦ SUN - Longitude increases with 2, Height increases with 4 ◦ RAIN - Height decreases with 5
◦ FOG - Height decreases with 3
◦ SNOW - Height decreases with 15
 */
