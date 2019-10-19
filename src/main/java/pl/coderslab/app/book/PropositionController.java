package pl.coderslab.app.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.app.author.Author;
import pl.coderslab.app.author.AuthorDao;
import pl.coderslab.app.publisher.Publisher;
import pl.coderslab.app.publisher.PublisherDao;

import java.util.List;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    private BookDao bookDao;
    private AuthorDao authorDao;
    private PublisherDao publisherDao;

    public PropositionController(BookDao bookDao, AuthorDao authorDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
    }

    @RequestMapping(value = "/addPropositionForm", method = RequestMethod.GET)
    public String processForm(Model model) {
        model.addAttribute("book", new Book());
        return "addPropositionForm";
    }

    @RequestMapping(value = "/addPropositionForm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute @Validated({PropositionValidationGroup.class}) Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addPropositionForm";
        }
        book.setProposition(true);
        bookDao.save(book);
        model.addAttribute("propositions", bookDao.findAllWithPropositions());
        return "redirect:showAllPropositions";
    }

    @RequestMapping(value = "/showAllPropositions", method = RequestMethod.GET)
    public String showAllPropositions(Model model) {
        model.addAttribute("propositions", bookDao.findAllWithPropositions());
        return "propositions";
    }

    @RequestMapping(value = "/editForm/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookDao.findWithAuthors(id));
        return "addPropositionForm";
    }

    @RequestMapping(value = "/editForm/{id}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Validated({PropositionValidationGroup.class}) Book book, BindingResult result, Model model, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "addPropositionForm";
        }
        book.setProposition(true);
        bookDao.update(book);
        model.addAttribute("propositions", bookDao.findAllWithPropositions());
        return "redirect:../showAllPropositions";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProposition(@PathVariable Long id) {
        bookDao.deleteById(id);
        return "redirect:../showAllPropositions";
    }

    @ModelAttribute("publishers")
    public List<Publisher> fetchAllPublishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> fetchAllAuthors() {
        return authorDao.findAll();
    }
}
