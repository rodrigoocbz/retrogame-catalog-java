package es.upsa.dasi.domain.exceptions;

public class VideoJuegoException extends Exception{
    public VideoJuegoException() {
    }

    public VideoJuegoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public VideoJuegoException(Throwable cause) {
        super(cause);
    }

    public VideoJuegoException(String message, Throwable cause) {
        super(message, cause);
    }

    public VideoJuegoException(String message) {
        super(message);
    }
}
