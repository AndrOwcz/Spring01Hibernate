package pl.coderslab.app.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.author.Author;
import pl.coderslab.app.book.Book;
import pl.coderslab.app.publisher.Publisher;
import pl.coderslab.app.common.CustomError;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    private Validator validator;

    @RequestMapping("/validate/book")
    public String validateBook(Model model) {
        Book book = new Book();
        book.setTitle("new TITLE");
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        List<CustomError> customErrors = new ArrayList<>();
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
                customErrors.add(new CustomError(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()));
            }
        }
        model.addAttribute("violations", violations);
        model.addAttribute("customErrors", customErrors);
        return "validator";

    }

    @RequestMapping("/validate/author")
    public String validateAuthor(Model model) {
        Author author = new Author();
        author.setPesel("999");
        Set<ConstraintViolation<Author>> violations = validator.validate(author);
        List<CustomError> customErrors = new ArrayList<>();
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Author> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
                customErrors.add(new CustomError(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()));
            }
        }
        model.addAttribute("violations", violations);
        model.addAttribute("customErrors", customErrors);
        return "validator";
    }

    @RequestMapping("/validate/publisher")
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        publisher.setNip("012703asd");
        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);
        List<CustomError> customErrors = new ArrayList<>();
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Publisher> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
                customErrors.add(new CustomError(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()));
            }
        }
        model.addAttribute("violations", violations);
        model.addAttribute("customErrors", customErrors);
        return "validator";
    }
}
