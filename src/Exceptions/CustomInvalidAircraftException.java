package Exceptions;

public class CustomInvalidAircraftException extends Exception {

    public CustomInvalidAircraftException(int lineNumber) {
        System.out.println("ERROR:  No aircraft entered.");
        System.out.println("FORMAT: [TYPE] [NAME] [LONGITUDE] [LATITUDE] [HEIGHT]");
        System.out.println("See line [" + lineNumber + "]. ");
    }

    public CustomInvalidAircraftException(String input, int lineNumber) {
        System.out.println("ERROR: [" + input + "]" + " is not a valid type of aircraft. ");
        System.out.println("TYPES: Balloon, JetPlane or Helicopter.");
        System.out.println("See line [" + lineNumber + "]. ");
    }
}
