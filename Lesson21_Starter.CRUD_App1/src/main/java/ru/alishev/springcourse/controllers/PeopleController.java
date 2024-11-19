package ru.alishev.springcourse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alishev.springcourse.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        //получим всех людей из DAO и передадим их в представление
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        //получим одного человека по его id из DAO и передадим его в представление
        return "people/show";
    }
}
