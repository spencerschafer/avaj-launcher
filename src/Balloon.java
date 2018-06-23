public class Balloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Balloon(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	//TODO
	@Override
	public void updateConditions() {
/*		if (this.coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
			System.out.println("TOWER: Balloon " + this.name + " (#" + this.id + ") registered to weather tower.");
		}*/
		System.out.println("Balloon conditions updated");
	}


	@Override
	public void registerTower(WeatherTower WeatherTower) {
		weatherTower = WeatherTower;
		weatherTower.register(this);
		System.out.println("TOWER: Balloon " + this.name + " (#" + this.id + ") registered to weather tower.");
	}
}

/*
◦ SUN - Longitude increases with 2, Height increases with 4 ◦ RAIN - Height decreases with 5
◦ FOG - Height decreases with 3
◦ SNOW - Height decreases with 15
 */
