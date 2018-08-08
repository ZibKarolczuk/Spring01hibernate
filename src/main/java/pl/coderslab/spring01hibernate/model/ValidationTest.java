package pl.coderslab.spring01hibernate.model;

import pl.coderslab.spring01hibernate.validation.IsOverXYO;

public class ValidationTest {
    @IsOverXYO(10)
    public int yearOfBirth;
}
