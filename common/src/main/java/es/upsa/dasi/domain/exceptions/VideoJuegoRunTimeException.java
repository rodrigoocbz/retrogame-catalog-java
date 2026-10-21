package es.upsa.dasi.domain.exceptions;

public class VideoJuegoRunTimeException extends RuntimeException{
    public VideoJuegoRunTimeException() {
    }

    public VideoJuegoRunTimeException(String message) {
        super(message);
    }

    public VideoJuegoRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VideoJuegoRunTimeException(Throwable cause) {
        super(cause);
    }

    public VideoJuegoRunTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
