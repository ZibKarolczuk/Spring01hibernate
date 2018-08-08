package pl.coderslab.spring01hibernate.controller;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;
import pl.coderslab.spring01hibernate.model.ValidationTest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationController {
    @Autowired
    private Validator validator;

    @GetMapping("/validate")
    @ResponseBody
    public String validate(){
        Book b = new Book();
        b.setPages(42);
        Set<ConstraintViolation<Book>> violations
                = validator.validate(b);

        if (violations.isEmpty()){
            return "Obiekt poprawny! Przeszedł walidację.";
        } else {
            String resultTxt = "Naruszenia wymagań: <br>\r\n";
            for (ConstraintViolation<Book> v : violations){
                resultTxt += v.getPropertyPath()
                        + " : " + v.getMessage() + "<br>\r\n";
            }

            return resultTxt;
        }
    }

    @GetMapping("/myownerr")
    @ResponseBody
    public String myOwnValidatorErr(){
        Author a = new Author();
        a.setYearOfBirth(2005);
        Set<ConstraintViolation<Author>> violations
                = this.validator.validate(a);
        if(violations.isEmpty()){
            return "Validation ok";
        } else {
            String resultStr = "Violations: <br>\r\n";
            for(ConstraintViolation<Author> v : violations){
                resultStr += v.getPropertyPath() + " : "
                          + v.getMessage() + "<br>\r\n";
            }
            return resultStr;
        }
    }

    @GetMapping("/myownok")
    @ResponseBody
    public String myOwnValidatorOk(){
        Author a = new Author();
        a.setYearOfBirth(1997);
        Set<ConstraintViolation<Author>> violations
                = this.validator.validate(a);
        if(violations.isEmpty()){
            return "Validation ok";
        } else {
            String resultStr = "Violations: <br>\r\n";
            for(ConstraintViolation<Author> v : violations){
                resultStr += v.getPropertyPath() + " : "
                        + v.getMessage() + "<br>\r\n";
            }
            return resultStr;
        }
    }

    @GetMapping("/overxyo")
    @ResponseBody
    public String overXYO() {
        ValidationTest test = new ValidationTest();
        test.yearOfBirth = 2015;

        Set<ConstraintViolation<ValidationTest>> violations
                = this.validator.validate(test);
        if(violations.isEmpty()){
            return "Validation ok";
        } else {
            String resultStr = "Violations: <br>\r\n";
            for(ConstraintViolation<ValidationTest> v : violations){
                resultStr += v.getPropertyPath() + " : "
                        + v.getMessage() + "<br>\r\n";
            }
            return resultStr;
        }
    }
}
