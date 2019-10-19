package pl.coderslab.app.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.personDetails.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @ResponseBody
    @RequestMapping("/save")
    public String savePerson() {
        Person person = new Person();
        person.setLogin("personal login");
        person.setEmail("sample@mail.com");
        person.setPassword("password111");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Jedrula");
        personDetails.setLastName("Jedrzejewski");
        personDetails.setCity("Warsaw");
        personDetails.setStreet("Ks janusza");
        personDetails.setStreetNumber("42/61");

        person.setPersonDetails(personDetails);

        personDao.save(person);
        return "Added.";
    }

    @ResponseBody
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable Long id) {
        Person person = personDao.find(id);
        if (person == null) {
            return "person not found";
        }
        person.setEmail("Zaktualizowany Email");
        personDao.update(person);
        return "Updated";
    }

    @ResponseBody
    @RequestMapping("/show/{id}")
    public String showPerson(@PathVariable Long id) {
        Person person = personDao.find(id);
        return person.toString();
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personDao.delete(id);
        return "Deleted";
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public String findAll() {
        return personDao.findAll().toString();
    }


    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String simple(Model model) {
        model.addAttribute("person", new Person());
        return "simplePersonForm";
    }

    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Person person) {
        return "simpleFormSuccess";
    }



/*    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String simple() {
        return "simplePersonForm";
    }

    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public String processSimple(@RequestParam String login,
                                @RequestParam String password,
                                @RequestParam String email) {
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        return "simpleFormSuccess";
    }*/
}
