package net.controller;

import net.model.ClassUnit;
import net.service.ClassUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/classController")
public class ClassUnitController {

    private ClassUnitService classUnitService;

    @Autowired
    @Qualifier(value = "ClassUnitService")
    public void setClassUnitService(ClassUnitService classUnitService){
        this.classUnitService = classUnitService;
    }

    @RequestMapping(value = "classes",method = RequestMethod.GET)
        public String classesList(Model model) throws SQLException {
        model.addAttribute("classUnit", new ClassUnit());
        model.addAttribute("classes",this.classUnitService.getAll());

        return "classes";
    }

    @RequestMapping(value = "/classes/add")
    public String addClass(@ModelAttribute("classUnit") ClassUnit classUnit) throws SQLException {
        if(classUnit.getId() == 0) {
            this.classUnitService.add(classUnit);
        }
        else {
            this.classUnitService.update(classUnit);
        }
        return "redirect:/classController/classes";
    }


    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeClass(@PathVariable("id") int id) throws SQLException {
        this.classUnitService.remove(id);

        return "redirect:/classController/classes";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editClass(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("classUnit", this.classUnitService.getById(id));
        model.addAttribute("classesList", this.classUnitService.getAll());

        return "redirect:/classController/classes";
    }

    @RequestMapping("/classData/{id}")
    public String classData(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("classUnit",this.classUnitService.getById(id));

        return "classData";
    }







}
