package Exceptions;

public class CustomIncorrectFormatException extends Exception {
    public CustomIncorrectFormatException (int lineNumber) {
        System.out.println("ERROR: Incorrect format.");
        System.out.println("FORMAT: [TYPE] [NAME] [LONGITUDE] [LATITUDE] [HEIGHT]");
        System.out.println("See Line [" + lineNumber + "].");
    }
}
