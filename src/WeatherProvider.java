public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static String weather[];

	private WeatherProvider() {

	}

	//TODO: make static
	public  WeatherProvider getProvider() {
		return (this.weatherProvider);

	}

	public String getCurrentWeather(Coordinates coordinates) {
		return ("");
	}
}
