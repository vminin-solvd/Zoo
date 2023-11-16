package zoo.exceptions;

public class ExpiredTicketException extends Exception{

    public ExpiredTicketException(String message) {
        super(message);
    }
}
