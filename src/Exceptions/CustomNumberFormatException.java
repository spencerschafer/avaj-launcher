package Exceptions;

public class CustomNumberFormatException extends NumberFormatException {
    public CustomNumberFormatException(int lineNumber) {
        System.out.println("ERROR:  Integer value is invalid.");
        System.out.println("FORMAT: 0 < value < 2147483647.");
        System.out.println("See line [" + lineNumber + "]. ");
    }
}
