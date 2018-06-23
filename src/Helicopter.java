public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	@Override
	public void updateConditions() {
		/*if (this.coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
			System.out.println("TOWER: Balloon " + this.name + " (#" + this.id + ") registered to weather tower.");
		}*/
		System.out.println("Helicopter conditions updated");
	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {
		this.weatherTower = WeatherTower;
		weatherTower.register(this);
		System.out.println("TOWER: Helicopter " + this.name + " (#" + this.id +  ") registered to weather tower.");
	}

	protected String getClassType() {
		return Helicopter.class.getSimpleName();
	}
}

/*
◦ SUN - Longitude increases with 10, Height increases with 2 ◦ RAIN - Longitude increases with 5
◦ FOG - Longitude increases with 1
◦ SNOW - Height decreases with 12
 */
