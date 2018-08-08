package pl.coderslab.spring01hibernate.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IsOver18YOValidator
        implements ConstraintValidator<IsOver18YO, Integer> {
    @Override
    public void initialize(IsOver18YO constraintAnnotation) {
        // todo later
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return (LocalDate.now().getYear() - value) > 18;
    }
}
