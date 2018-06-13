import java.io.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int iterations;
		int totalAircraft;
		File file = new File(args[0]);
		ArrayList<Aircraft> list;

		if ((iterations = isFileValid(file)) == -1) {
			System.exit(1);
		}
		list = createAllAircraft(file);
		totalAircraft = list.size();
		for (int counter = 0; counter < iterations; ++counter) {
			for (int aircraft = 0; aircraft < totalAircraft; ++aircraft) {
				System.out.println(list.get(aircraft).name);
				System.out.println(list.get(aircraft).getClassType());
			}
		}
	}

	private static int isFirstLineValid(String[] line, int lineNumber) {
		int iterations;

		//checking that length is only 1 as we are expecting only 1 integer value on the first line
		if (line.length != 1) {
			System.out.println("ERROR: First line of file needs to be an integer.");
			System.out.println("FORMAT: 25 (Example)");
			System.out.print("See line [" + lineNumber + "]");
			return -1;
		}

		//if the integer entered cannot be stored in an int it's considered invalid
		try {
			iterations = Integer.parseInt(line[0]);
		} catch (NumberFormatException e) {
			System.out.println("ERROR: Integer value is invalid.");
			System.out.println("FORMAT: -2147483648 < value < 2147483647.");
			System.out.println("See line [" + lineNumber + "]. ");
			return -1;
		}
		return iterations;
	}

	private static int isLineValid(String[] line, int lineNumber) {
		String type;

		//check array size, if size != 5 return error
		if (line.length != 5) {
			System.out.println("ERROR: Incorrect format.");
			System.out.println("FORMAT: [TYPE] [NAME] [LONGITUDE] [LATITUDE] [HEIGHT]");
			System.out.println("See Line [" + lineNumber + "].");
			return -1;
		}

		//checking correct type
		type = line[0].toLowerCase();
		if (!(type.equalsIgnoreCase("balloon")) && !(type.equalsIgnoreCase("jetplane")) &&
				!(type.equalsIgnoreCase("helicopter"))) {
			System.out.println("ERROR: [" + line[0] + "]" + " is not a valid type of aircraft. ");
			System.out.println("TYPES: Balloon, JetPlane or Helicopter.");
			System.out.println("See line [" + lineNumber + "]. ");
			return -1;
		}

		//if the integer entered cannot be stored in an int it's considered invalid
		try {
			Integer.parseInt(line[2]);
			Integer.parseInt(line[3]);
			Integer.parseInt(line[4]);
		} catch (NumberFormatException e) {
			System.out.println("ERROR: Integer value is invalid.");
			System.out.println("FORMAT: -2147483648 < value < 2147483647.");
			System.out.println("See line [" + lineNumber + "]. ");
			return -1;
		}
		return 1;
	}

	private static int isFileValid(File file) {
		int isValid;
		int iterations = 0;
		int lineNumber = 1;

		//checking for empty file
		if (file.length() == 0) {
			System.out.println("ERROR: Empty file.");
			return -1;
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			String line;
			String[] string;

			//getting first line
			if ((line = br.readLine()) != null) {
				string = line.split(" ");
				iterations = isFirstLineValid(string, lineNumber);
				if (!(iterations > 0)) {
					System.out.println("Valid file but there are no iterations. Exiting.");
					return -1;
				}
				lineNumber++;
			}

			//iterating through subsequent file lines
			while ((line = br.readLine()) != null) {
				string = line.split(" ");
				isValid = isLineValid(string, lineNumber);
				if (isValid == -1)
					return -1;
				lineNumber++;
			}

		} catch (IOException e) {
			System.out.println("ERROR: IOException in function isFileValid() in class Main.java]\n");
			return -1;
		}

		//if correct integer was entered on first line, but no following lines were entered
		if (lineNumber == 2) {
			System.out.println("ERROR: No aircraft entered.");
			System.out.println("FORMAT: [TYPE] [NAME] [LONGITUDE] [LATITUDE] [HEIGHT]");
			System.out.println("See line [" + lineNumber + "]. ");
			return -1;
		}
		return iterations;
	}

	private static Aircraft createAircraft(String[] line) {
		Aircraft aircraft = null;
		String type = line[0].toLowerCase();
		String name = line[1];
		int longitude = Integer.parseInt(line[2]);
		int latitude = Integer.parseInt(line[3]);
		int height = Integer.parseInt(line[4]);
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		switch (type) {
			case "balloon":
				aircraft = new Balloon(name, coordinates);
				break;
			case "jetplane":
				aircraft = new JetPlane(name, coordinates);
				break;
			case "helicopter":
				aircraft = new Helicopter(name, coordinates);
				break;
		}
		return aircraft;
	}

	private static ArrayList<Aircraft> createAllAircraft(File file) {
		ArrayList<Aircraft> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			String line;
			String[] string;

			//skipping first line
			br.readLine();

			//iterating through subsequent file lines
			while ((line = br.readLine()) != null) {
				string = line.split(" ");
				list.add(createAircraft(string));
			}
		} catch (IOException e) {
			System.out.println("ERROR: IOException in function isFileValid() in class Main.java]\n");
			System.exit(2);
		}
		return list;
	}
}
