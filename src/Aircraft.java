public class Aircraft {
	private long idCounter;
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	Aircraft() {
		this.name = "default";
		this.coordinates = new Coordinates(0, 0, 0);
	}

	private long nextId() {
		return 0;
	}

	protected String getClassType() {
		return Aircraft.class.getSimpleName();
	}
}
