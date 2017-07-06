package net.controller;


import net.model.Subject;
import net.service.SubjectService;
import org.codehaus.jackson.map.annotate.JacksonInject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@org.springframework.stereotype.Controller
@RequestMapping("/subjectController")
public class SubjectController {
    private SubjectService subjectService;


    @Autowired
    @Qualifier(value = "SubjectService")
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

        @RequestMapping(value = "subjects",method = RequestMethod.GET)
    public String SubjectsList(Model model) throws SQLException {
        model.addAttribute("subject", new Subject());
        model.addAttribute("subjects",this.subjectService.getAll());

        return "subjects";
    }

    @RequestMapping(value = "/subjects/add")
    public String addSubject(@ModelAttribute("subject") Subject subject) throws SQLException {
        if(subject.getId() == 0) {
            this.subjectService.add(subject);
        }
        else {
            this.subjectService.update(subject);
        }
        return "redirect:/subjectController/subjects";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeSubject(@PathVariable("id") int id) throws SQLException {
        this.subjectService.remove(id);

        return "redirect:/subjectController/subjects";
    }

    @RequestMapping(value = "edit/{id}")
    public String editSubject(@PathVariable("id") int id,Model model) throws SQLException {
        model.addAttribute("subject", this.subjectService.getById(id));
        model.addAttribute("subjects", this.subjectService.getAll());

        return "subjects";
    }

    @RequestMapping("/subjectData/{id}")
    public String subjectData(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("subject",this.subjectService.getById(id));

        return "subjectData";
    }
}
