package pl.coderslab.app.author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.book.Book;


import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorDao authorDao;
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorDao authorDao, AuthorRepository authorRepository) {
        this.authorDao = authorDao;
        this.authorRepository = authorRepository;
    }

    @RequestMapping(value = "/addAuthorForm", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthorForm";
    }

    @RequestMapping(value = "/addAuthorForm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute @Valid Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addAuthorForm";
        }
        authorDao.save(author);
        model.addAttribute("authors", authorDao.findAll());
        return "redirect:showAllAuthors";
    }

    @RequestMapping(value = "/showAllAuthors", method = RequestMethod.GET)
    public String showAllAuthors(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "authors";
    }

    @RequestMapping(value = "/editForm/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorDao.findById(id));
        return "addAuthorForm";
    }

    @RequestMapping(value = "/editForm/{id}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Author author, BindingResult result, Model model, @PathVariable String id) {
        if (result.hasErrors()) {
            return "addAuthorForm";
        }
        authorDao.update(author);
        model.addAttribute("authors", authorDao.findAll());
        return "redirect:../showAllAuthors";
    }

    @ResponseBody
    @RequestMapping("/save")
    public String saveAuthor() {
        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Eckel");
        Book book = new Book();
        book.setTitle("title1");
        authorDao.save(author);
        return "Id dodanego autora to:" + author.getId();
    }

    @ResponseBody
    @RequestMapping("/edit/{id}")
    public String editAuthor(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        if (author == null) {
            return "author not found";
        }
        author.setLastName("Zaktualizowane Nazwisko");
        authorDao.update(author);
        return "Id zaktualizowanego autora to:" + author.getId() + " i nazwisko: " + author.getLastName();
    }

    @ResponseBody
    @RequestMapping("/show/{id}")
    public String showAuthor(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorDao.deleteById(id);
        return "redirect:../showAllAuthors";
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public String findAll() {
        return authorDao.findAll().toString();
    }
}
