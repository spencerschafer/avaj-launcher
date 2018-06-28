package Exceptions;

public class CustomFirstLineNotIntegerException extends Exception{

    public CustomFirstLineNotIntegerException(int lineNumber) {
        System.out.println("ERROR:  First line of file needs to be an integer.");
        System.out.println("FORMAT: 25 (Example)");
        System.out.println("See Line [1].");
    }
}
