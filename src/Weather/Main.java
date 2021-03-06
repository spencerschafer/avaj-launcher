package Weather;

import Aircraft.AircraftFactory;
import Aircraft.Flyable;

import java.io.*;
import java.util.ArrayList;

import Exceptions.*;

public class Main {
    public static void main(String[] args) {

        int iterations;
        File file = new File(args[0]);
        ArrayList<Flyable> listOfAircraft;
        WeatherTower weatherTower = new WeatherTower();

        //checking for valid file
        if ((iterations = isFileValid(file)) == -1) {
            //no error message is needed as it is printed by isFileValid
            System.exit(0);
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
        int iterations = 0;

        //checking that length is only 1 as we are expecting only 1 integer value on the first line
        try {
            if (line.length != 1) {
                throw new CustomFirstLineNotIntegerException(lineNumber);
            }
        } catch (CustomFirstLineNotIntegerException e) {
            System.exit(1);
        }

        //if the integer entered cannot be stored in an int it's considered invalid
        try {
            iterations = Integer.parseInt(line[0]);
            try {
                if (iterations <= 0) {
                    throw new CustomNoIterationsException();
                }
            } catch (CustomNoIterationsException e) {
                System.exit(2);
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Integer value is invalid.");
            System.out.println("FORMAT: 0 < value < 2147483647.");
            System.out.println("See line [" + lineNumber + "]. ");
            System.exit(3);
        }
        return iterations;
    }

    private static int isLineValid(String[] line, int lineNumber) {
        String type;

        //check array size, if size != 5 return error
        try {
            if (line.length != 5) {
                throw new CustomIncorrectFormatException(lineNumber);
            }
        } catch (CustomIncorrectFormatException e) {
            System.exit(4);
        }

        //checking correct type
        type = line[0].toLowerCase();
        try {
            if (!(type.equalsIgnoreCase("balloon")) && !(type.equalsIgnoreCase("jetplane")) &&
                    !(type.equalsIgnoreCase("helicopter"))) {
                throw new CustomInvalidAircraftException(line[0], lineNumber);
            }
        } catch (CustomInvalidAircraftException e) {
            System.exit(5);
        }

        //if the integer entered cannot be stored in an int it's considered invalid
        try {
            int a, b, c;
            a = Integer.parseInt(line[2]);
            b = Integer.parseInt(line[3]);
            c = Integer.parseInt(line[4]);

            //checking for negative coordinates
            try {
                if (a <= 0 || b <= 0 || c <= 0) {
                    throw new CustomNumberFormatException(lineNumber);
                }
            } catch (CustomNumberFormatException e) {
                System.exit(6);
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Integer value is invalid.");
            System.out.println("FORMAT: 0 < value < 2147483647.");
            System.out.println("See line [" + lineNumber + "]. ");
            System.exit(7);
        }
        return 1;
    }

    private static int isFileValid(File file) {
        int isValid;
        int iterations = 0;
        int lineNumber = 1;

        //checking for empty file
        try {
            if (file.length() == 0) {
                throw new CustomEmptyFileException();
            }
        } catch (CustomEmptyFileException e) {
            System.exit(8);
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
            System.exit(9);
        }

        //if correct integer was entered on first line, but no following lines were entered
        try {
            if (lineNumber == 2) {
                throw new CustomInvalidAircraftException(lineNumber);
            }
        } catch (CustomInvalidAircraftException e) {
            System.exit(10);
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
