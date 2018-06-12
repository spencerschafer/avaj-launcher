import java.io.*;
import java.security.SignedObject;
import java.util.SortedMap;

public class Main {

	private static boolean isFirstLineValid(String[] line, int lineNumber) {

		if (line.length != 1) {
			System.out.println("ERROR: First line of file needs to be an integer.");
			System.out.println("FORMAT: 25 (Example)");
			System.out.print("See line [" + lineNumber + "]");
			return false;
		}

		try {
			Integer.parseInt(line[0]);
		} catch (NumberFormatException e) {
			System.out.println("ERROR: Integer value is invalid.");
			System.out.println("FORMAT: -2147483648 < value < 2147483647.");
			System.out.println("See line [" + lineNumber + "]. ");
			return false;
		}
		return true;
	}

	private static boolean isLineValid(String[] line, int lineNumber) {
		String type;

		//check array size, if size != 5 return error
		if (line.length != 5) {
			System.out.println("ERROR: Incorrect format.");
			System.out.println("FORMAT: [TYPE] [NAME] [LONGITUDE] [LATITUDE] [HEIGHT]");
			System.out.println("See Line [" + lineNumber + "].");
			return false;
		}

		//checking correct type
		type = line[0].toLowerCase();
		if (!(type.equalsIgnoreCase("balloon")) && !(type.equalsIgnoreCase("jetplane")) &&
				!(type.equalsIgnoreCase("helicopter"))) {
			System.out.println("ERROR: [" + line[0] + "]" + " is not a valid type of aircraft. ");
			System.out.println("TYPES: Balloon, JetPlane or Helicopter.");
			System.out.println("See line [" + lineNumber + "]. ");
			return false;
		}

		try {
			Integer.parseInt(line[2]);
			Integer.parseInt(line[3]);
			Integer.parseInt(line[4]);
		} catch (NumberFormatException e) {
			System.out.println("ERROR: Integer value is invalid.");
			System.out.println("FORMAT: -2147483648 < value < 2147483647.");
			System.out.println("See line [" + lineNumber + "]. ");
			return false;
		}
		return true;

	}

	private static boolean isFileValid(String file) {
		boolean valid;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			String line;
			String[] string;
			int lineNumber = 0;

			//getting first line
			if ((line = br.readLine()) != null) {
				string = line.split(" ");
				valid = isFirstLineValid(string, lineNumber);
				if (!valid)
					return false;
				lineNumber++;
			}

			//iterating through subsequent lines
			while ((line = br.readLine()) != null) {
				string = line.split(" ");
				valid = isLineValid(string, lineNumber);
				if (!valid)
					return false;
				lineNumber++;
			}
		} catch (IOException e) {
			System.out.println("ERROR: readFile\nCLASS: Main.java\n");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		if (isFileValid(args[0]))
			System.out.println("VALID FILE");
	}
}
