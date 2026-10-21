package es.upsa.dasi.domain.exceptions;

public class VideoJuegoNotFoundException extends VideoJuegoException{

    public VideoJuegoNotFoundException(String message) {
        super(message);
    }

    public VideoJuegoNotFoundException() {
        super("No existe el videojuego tt");
    }

    public VideoJuegoNotFoundException(long codigo) {
        super("No existe el videojuego con codigo"+codigo);
    }
}
