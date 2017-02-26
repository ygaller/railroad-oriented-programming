package railroad;

public class RailroadException extends Exception {
    public RailroadException(String message) {
        super(message);
    }

    public RailroadException(String message, Throwable cause) {
        super(message, cause);
    }
}
