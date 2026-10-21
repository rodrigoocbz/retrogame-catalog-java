package es.upsa.dasi.videojuegosws.infrastructure.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {UrlConstraintValidator.class})
@Target({ElementType.FIELD,ElementType.RECORD_COMPONENT})
@Retention(RetentionPolicy.RUNTIME)
public @interface Url {
    String message() default "URL invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
