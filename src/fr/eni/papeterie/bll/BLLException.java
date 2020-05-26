package fr.eni.papeterie.bll;

public class BLLException extends Exception{

    public BLLException() {super();}

    public BLLException(String message) {
        super(message);
    }

    public BLLException(String message, Throwable cause) {
        super(message, cause);
    }
}
