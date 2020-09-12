package ro.orange.service1.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = { CNPValidator.class })
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CNP {
    String message() default "CNP invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int length() default 13;

    int nonDigit() default 0;
}
