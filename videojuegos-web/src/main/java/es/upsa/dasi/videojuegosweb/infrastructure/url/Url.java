package es.upsa.dasi.videojuegosweb.infrastructure.url;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {UrlConstraintValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Url
{
    String message() default "Invalid URL";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
