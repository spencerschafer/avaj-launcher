package Exceptions;

public class CustomNoIterationsException extends Exception{

    public CustomNoIterationsException() {
        System.out.println("Valid file but there are no iterations.");
    }
}
