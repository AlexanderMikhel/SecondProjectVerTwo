package net.controller;


import net.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import net.service.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/users")
public class Controller {
    @Autowired
    private Service service;

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @RequestMapping(value = "/validate" , method = RequestMethod.GET)
    public ModelAndView validateUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userFromServer",new User());
        modelAndView.setViewName("users_check_page");
        return modelAndView;
    }


    @RequestMapping(value="/check",method = RequestMethod.POST)
    public @ResponseBody String checkUser(@ModelAttribute("userFromServer") User user){
        if("admin".equals(user.getName()) && "admin".equals(user.getPassword())){
            return "valid";
        }
        else
            return "invalid";
    }
}
