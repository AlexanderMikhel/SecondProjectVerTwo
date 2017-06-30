package net.controller;

import net.model.ClassUnit;
import net.service.ClassUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@org.springframework.stereotype.Controller
@RequestMapping("/classes")
public class ClassUnitController {

    private ClassUnitService classUnitService;
    @Autowired
    public void setClassUnitService(ClassUnitService classUnitService){
        this.classUnitService = classUnitService;
    }

    @RequestMapping(value = "classes",method = RequestMethod.GET)
        public String classesList(Model model) throws SQLException {
        model.addAttribute("class", new ClassUnit());
        model.addAttribute("classesList",this.classUnitService.getAll());

        return "classes";
    }

    @RequestMapping(value = "/classes/add", method = RequestMethod.POST)
    public String addClass(@ModelAttribute("classUnit") ClassUnit classUnit) throws SQLException {
        if(classUnit.getId() == 0) {
            this.classUnitService.add(classUnit);
        }
        else {
            this.classUnitService.update(classUnit);
        }
        return "redirect:/classes";
    }

    @RequestMapping("/remove/{id}")
    public String removeClass(@PathVariable("id") int id) throws SQLException {
        this.classUnitService.remove(id);

        return "redirect:/classes";
    }

    @RequestMapping("edit/{id}")
    public String editClass(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("class", this.classUnitService.getById(id));
        model.addAttribute("classesList", this.classUnitService.getAll());

        return "classes";
    }

    @RequestMapping("/classData/{id}")
    public String classData(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("class",this.classUnitService.getById(id));

        return "classData";
    }







}
