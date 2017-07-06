package net.controller;



import net.model.Teacher;
import net.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
@org.springframework.stereotype.Controller
@RequestMapping("/teacherController")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    @Qualifier(value = "TeacherService")
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "teachers",method = RequestMethod.GET)
    public String TeachersList(Model model) throws SQLException {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers",this.teacherService.getAll());

        return "teachers";
    }

    @RequestMapping(value = "/teachers/add", method = RequestMethod.GET)
    public String addTeacher(@ModelAttribute("teacher") Teacher teacher) throws SQLException {
        if(teacher.getId() == 0) {
            this.teacherService.add(teacher);
        }
        else {
            this.teacherService.update(teacher);
        }
        return "redirect:/teacherController/teachers";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeTeacher(@PathVariable("id") int id) throws SQLException {
        this.teacherService.remove(id);

        return "redirect:/teacherController/teachers";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public String editTeacher(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("teacher", this.teacherService.getById(id));
        model.addAttribute("teachers", this.teacherService.getAll());

        return "redirect:/teacherController/teachers";
    }

    @RequestMapping("/teacherData/{id}")
    public String teacherData(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("teacher",this.teacherService.getById(id));

        return "teacherData";
    }
}
