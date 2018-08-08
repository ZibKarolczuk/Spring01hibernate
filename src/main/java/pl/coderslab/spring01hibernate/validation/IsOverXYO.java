package pl.coderslab.spring01hibernate.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsOverXYOValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsOverXYO {
    int value() default 18;
    String message() default "Must be over X years old";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
