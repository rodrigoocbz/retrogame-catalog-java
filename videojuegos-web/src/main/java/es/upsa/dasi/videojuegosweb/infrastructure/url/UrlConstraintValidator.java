package es.upsa.dasi.videojuegosweb.infrastructure.url;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.net.URI;
import java.net.URL;

public class UrlConstraintValidator implements ConstraintValidator<Url, String>
{

    @Override
    public void initialize(Url constraintAnnotation) {
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext)
    {
        try {
            URI uri = URI.create(string);
            return ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()))
                    && uri.getHost() != null;
        }catch (Exception ex){
            return false;
        }
    }
}
