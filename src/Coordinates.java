public class Coordinates {
	private int latitude;
	private int longitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.height = height;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getHeight() {
		return height;
	}

	public void changeCoordinates(int longitude, int latitude, int height) {
		this.latitude += longitude;
		this.latitude += latitude;
		this.height += height;
	}
}
