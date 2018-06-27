package Weather;

import Aircraft.AircraftFactory;
import Aircraft.Flyable;

import java.io.*;
import java.util.ArrayList;

import Exceptions.*;

//Check positive values for coordinates
//Create an output message function for weather changes and landing of each class (think random message)
//Do something with default weatherProvider constructor
//Write output to file
//Error when deregistering an aircraft from ArrayList (two aircraft are removed instead of 1)
//Incorporate packages
//Create shell script that allows user to test a specific file (i.e choose option 1 for scenario.txt)
//TODO: Create Custom exceptions for handling errors (BONUS)
//TODO: Make sure only java 7, and earlier, functions were used

public class Main {
    public static void main(String[] args) {

        int iterations;
        File file = new File(args[0]);
        ArrayList<Flyable> listOfAircraft;
        WeatherTower weatherTower = new WeatherTower();

        //checking for valid file
        if ((iterations = isFileValid(file)) == -1) {
            //no error message is needed as it is printed by isFileValid
            System.exit(1);
        }

        //adding aircraft to array
        listOfAircraft = createAllAircraft(file);

        //register each aircraft to tower
        for (Flyable aircraft : listOfAircraft) {
            aircraft.registerTower(weatherTower);
        }

        //iterating through each aircraft updating the conditions on each iteration
        System.out.println();
        for (int counter = 0; counter < iterations; ++counter) {
            weatherTower.changeWeather();
            if ((counter + 1) != iterations)
                System.out.println();
        }
    }

    private static int isFirstLineValid(String[] line, int lineNumber) {
        int iterations;

        //checking that length is only 1 as we are expecting only 1 integer value on the first line
        try {
            if (line.length != 1) {
                //throw new CustomFirstLineNotIntegerException("ERROR:First line of file needs to be an integer.\nFORMAT: 25 (Example)\nSee :ome [");
                throw new CustomFirstLineNotIntegerException(lineNumber);
            }
        } catch (CustomFirstLineNotIntegerException e) {
            System.exit(1);
        }

        //if the integer entered cannot be stored in an int it's considered invalid
        try {
            iterations = Integer.parseInt(line[0]);
            if (iterations == 0) {
                System.out.println("Valid file but there are no iterations.");
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Integer value is invalid.");
            System.out.println("FORMAT: 0 < value < 2147483647.");
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
            int a, b, c;
            a = Integer.parseInt(line[2]);
            b = Integer.parseInt(line[3]);
            c = Integer.parseInt(line[4]);

            //checking for negative coordinates
            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.println("ERROR: Integer value needs to be greater than 0.");
                System.out.println("FORMAT: 0 < value < 2147483647.");
                System.out.println("See line [" + lineNumber + "]. ");
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Integer value is invalid.");
            System.out.println("FORMAT: 0 < value < 2147483647.");
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
                if (iterations < 0)
                    return -1;
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
            System.out.println("ERROR: IOException in function isFileValid() in class Weather.Main.java]\n");
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

    private static Flyable createAircraft(String[] line) {
        String type = line[0].toLowerCase();
        String name = line[1];
        int longitude = Integer.parseInt(line[2]);
        int latitude = Integer.parseInt(line[3]);
        int height = Integer.parseInt(line[4]);

        AircraftFactory aircraftFactory = new AircraftFactory();
        return (aircraftFactory.newAircraft(type, name, longitude, latitude, height));
    }

    private static ArrayList<Flyable> createAllAircraft(File file) {
        ArrayList<Flyable> listOfAircraft = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            String[] string;

            //skipping first line
            br.readLine();

            //iterating through subsequent file lines and create each aircraft
            while ((line = br.readLine()) != null) {
                string = line.split(" ");
                listOfAircraft.add(createAircraft(string));
            }
        } catch (IOException e) {
            System.out.println("ERROR: IOException in function isFileValid() in class Weather.Main.java]\n");
            System.exit(2);
        }
        return listOfAircraft;
    }
}
