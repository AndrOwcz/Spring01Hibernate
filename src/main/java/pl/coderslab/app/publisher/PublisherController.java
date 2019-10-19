package pl.coderslab.app.publisher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private PublisherDao publisherDao;
    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherDao publisherDao, PublisherRepository publisherRepository) {
        this.publisherDao = publisherDao;
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping(value = "/addPublisherForm", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "addPublisherForm";
    }

    @RequestMapping(value = "/addPublisherForm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute @Valid Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addPublisherForm";
        }
        publisherDao.save(publisher);
        model.addAttribute("publishers", publisherDao.findAll());
        return "redirect:showAllPublishers";
    }

    @RequestMapping(value = "/showAllPublishers", method = RequestMethod.GET)
    public String showAllAuthors(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        return "publishers";
    }

    @RequestMapping(value = "/editForm/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("publisher", publisherDao.findById(id));
        return "addPublisherForm";
    }

    @RequestMapping(value = "/editForm/{id}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Publisher publisher, BindingResult result, Model model, @PathVariable String id) {
        if (result.hasErrors()) {
            return "addPublisherForm";
        }
        publisherDao.update(publisher);
        model.addAttribute("publisher", publisherDao.findAll());
        return "redirect:../showAllPublishers";
    }

    @ResponseBody
    @RequestMapping("/save")
    public String savePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);
        return "Id dodanego wydawnictwa to:" + publisher.getId();
    }

    @ResponseBody
    @RequestMapping("/edit/{id}")
    public String editPublisher(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        if (publisher == null) {
            return "publisher not found";
        }
        publisher.setName("Zaktualizowana nazwa");
        publisherDao.update(publisher);
        return "Id zaktualizowanego wydawnictwa to:" + publisher.getId() + " i nazwa: " + publisher.getName();
    }

    @ResponseBody
    @RequestMapping("/show/{id}")
    public String showPublisher(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherDao.deleteById(id);
        return "redirect:../showAllPublishers";
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public String findAll() {
        return publisherDao.findAll().toString();
    }
}
