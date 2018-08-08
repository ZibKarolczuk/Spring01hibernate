package pl.coderslab.spring01hibernate.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IsOverXYOValidator
        implements ConstraintValidator<IsOverXYO, Integer> {
    private int minimumAge;

    @Override
    public void initialize(IsOverXYO constraintAnnotation) {
        this.minimumAge = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return (LocalDate.now().getYear() - value)
                > this.minimumAge;
    }
}
