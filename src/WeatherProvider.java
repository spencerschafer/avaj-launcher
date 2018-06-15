public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static String weather[];

	private WeatherProvider() {

	}

	public static WeatherProvider getProvider() {
		return (this.weatherProvider);

	}

	public String getCurrentWeather(Coordinates coordinates) {
		return ("");
	}
}
