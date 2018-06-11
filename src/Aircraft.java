public class Aircraft {
	private long idCounter;
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	private long nextId() {
		return 0;
	}
}
