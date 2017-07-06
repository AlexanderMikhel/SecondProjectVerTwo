package net.controller;


import net.model.Mark;
import net.model.Student;
import net.model.Subject;
import net.service.StudentService;
import net.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
@org.springframework.stereotype.Controller
@RequestMapping("/studentController")
public class StudentController {
    private StudentService studentService;

    @Autowired
    @Qualifier(value = "StudentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "students",method = RequestMethod.GET)
    public String StudentsList(Model model) throws SQLException {
        model.addAttribute("student", new Student());
        model.addAttribute("students",this.studentService.getAll());

        return "students";
    }

    @RequestMapping(value = "/students/add", method = RequestMethod.GET)
    public String addSStudent(@ModelAttribute("student") Student student) throws SQLException {
        if(student.getId() == 0) {
            this.studentService.add(student);
        }
        else {
            this.studentService.update(student);
        }
        return "redirect:/studentController/students";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeStudent(@PathVariable("id") int id) throws SQLException {
        this.studentService.remove(id);

        return "redirect:/studentController/students";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String editStudent(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("student", this.studentService.getById(id));
        model.addAttribute("students", this.studentService.getAll());

        return "redirect:/studentController/students";
    }

    @RequestMapping("/studentData/{id}")
    public String subjectData(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("student",this.studentService.getById(id));

        return "studentData";
    }
}
