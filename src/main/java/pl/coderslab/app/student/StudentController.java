package pl.coderslab.app.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String simple(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @ResponseBody
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Student student) {
        return student.toString();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("sport", "traveling", "programming", "cooking", "reading books");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("java", "python", "javaScript", "Ruby", "PHP");
    }

}
