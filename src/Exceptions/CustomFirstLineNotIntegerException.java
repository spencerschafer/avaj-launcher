package Exceptions;

public class CustomFirstLineNotIntegerException extends Exception{

    public CustomFirstLineNotIntegerException(String message) {
        super(message);
    }

    public CustomFirstLineNotIntegerException(int lineNumber) {
        System.out.println("ERROR: First line of file needs to be an integer.\nFORMAT: 25 (Example)\nSee Line [" + lineNumber + "]");

    }
}
