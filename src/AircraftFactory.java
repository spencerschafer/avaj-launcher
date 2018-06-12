public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Flyable temp = new Flyable() {
			@Override
			public void updateConditions() {

			}

			@Override
			public void registerTower(WeatherTower WeatherTower) {

			}
		};

		return (temp);
	}
}
