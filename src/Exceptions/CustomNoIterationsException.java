package Exceptions;

public class CustomNoIterationsException extends Exception{

    public CustomNoIterationsException() {
        System.out.println("ERROR:  Iteration value is invalid.");
        System.out.println("FORMAT: 0 < value < 2147483647.");
        System.out.println("See line [1].");
    }
}
