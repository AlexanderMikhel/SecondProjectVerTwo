package net.controller;

import net.model.ClassUnit;
import net.model.Mark;
import net.model.Student;
import net.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.SQLException;

@org.springframework.stereotype.Controller
@RequestMapping("/markController")
public class MarkController {

    private MarkService markService;

    @Autowired
    @Qualifier(value = "MarkService")
     public void setMarkService(MarkService markService){
        this.markService = markService;
    }

    @RequestMapping(value = "marks",method = RequestMethod.GET)
    public String MarksList(Model model) throws SQLException {
        model.addAttribute("mark", new Mark());
        model.addAttribute("marks",this.markService.getAll());

        return "marks";
    }

    @RequestMapping(value = "/marks/add")
    public String addMark(@ModelAttribute("mark") Mark mark)  {
         //Заглушка для даты, не знаю как передать через ГУИ, там обычный текст не принимает
        // это надо во фронтенде разбираться
         mark.setDate(new Date(11,11,11));
        if(mark.getId() == 0) {
            this.markService.add(mark);
        }
        else {
            this.markService.update(mark);
        }
        return "redirect:/markController/marks";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeMark(@PathVariable("id") int id) {
        this.markService.remove(id);

        return "redirect:/markController/marks";
    }

    @RequestMapping("edit/{id}")
    public String editMark(@PathVariable("id") int id, Model model)  {
        model.addAttribute("mark", this.markService.getById(id));
        model.addAttribute("marks", this.markService.getAll());

        return "marks";
    }

    @RequestMapping("markData/{id}")
    public String markData(@PathVariable("id") int id, Model model)  {
        model.addAttribute("mark",this.markService.getById(id));

        return "markData";
    }

   }
