package Exceptions;

public class CustomEmptyFileException extends Exception{
    public CustomEmptyFileException() {
        System.out.println("ERROR: Empty file.");
    }
}
