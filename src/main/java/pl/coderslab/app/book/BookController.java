package pl.coderslab.app.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.author.AuthorDao;
import pl.coderslab.app.publisher.PublisherDao;
import pl.coderslab.app.author.Author;
import pl.coderslab.app.publisher.Publisher;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final PublisherDao publisherDao;
    private final BookRepository bookRepository;

    public BookController(BookDao bookDao, AuthorDao authorDao, PublisherDao publisherDao, BookRepository bookRepository) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/addBookForm", method = RequestMethod.GET)
    public String processForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBookForm";
    }

    @RequestMapping(value = "/addBookForm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute @Validated({BookValidationGroup.class}) Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addBookForm";
        }
        book.setProposition(false);
        bookDao.save(book);
        model.addAttribute("books", bookDao.findAll());
        return "redirect:showAllBooks";
    }

    @RequestMapping(value = "/showAllBooks", method = RequestMethod.GET)
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "books";
    }

    @RequestMapping(value = "/editForm/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookDao.findWithAuthors(id));
        return "addBookForm";
    }

    @RequestMapping(value = "/editForm/{id}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Validated({BookValidationGroup.class}) Book book, BindingResult result, Model model, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "addBookForm";
        }
        bookDao.update(book);
        model.addAttribute("books", bookDao.findAll());
        return "redirect:../showAllBooks";
    }

    @ModelAttribute("publishers")
    public List<Publisher> fetchAllPublishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> fetchAllAuthors() {
        return authorDao.findAll();
    }

    @ResponseBody
    @RequestMapping("/save")
    public String saveBook() {
        Book book = new Book();

        Author author = authorDao.findById(1L);
        book.setAuthors(Arrays.asList(author));

        Publisher publisher = publisherDao.findById(1L);
        book.setPublisher(publisher);

        book.setTitle("Thinking in Java");
        book.setDescription("Description");
        book.setRating(BigDecimal.valueOf(5.55));

        bookDao.save(book);
        return "Id dodanej ksiazki to:" + book.getId();
    }

    @ResponseBody
    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable Long id) {
        Book book = bookDao.findById(id);
        if (book == null) {
            return "book not found";
        }
        book.setDescription("Zaktualizowany Opis");
        bookDao.update(book);
        return "Id zaktualizowanej ksiazki to:" + book.getId() + " o opisie: " + book.getDescription();
    }

    @ResponseBody
    @RequestMapping("/show/{id}")
    public String showBook(@PathVariable Long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookDao.deleteById(id);
        return "redirect:../showAllBooks";
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public String findAll() {
        return bookDao.findAll().toString();
    }

    @ResponseBody
    @RequestMapping("/getRating/{rating}")
    public String getRatingList(@PathVariable BigDecimal rating) {
        return bookDao.getRatingList(rating).toString();
    }

    @GetMapping(value = "/change/{rating}")
    @ResponseBody
    public String testCustom(@PathVariable BigDecimal rating) {
        bookRepository.resetRating(rating);
        return "All data changed";
    }
}
