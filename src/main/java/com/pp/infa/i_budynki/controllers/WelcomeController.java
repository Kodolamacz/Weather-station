package com.pp.infa.i_budynki.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Blazej on 17.10.2017.
 */
@Controller
//@RequestMapping("/stacja")
public class WelcomeController {


    @RequestMapping(value = "/welcome")
    public String welcome(Model model){
        model.addAttribute("message","Aplikacja na zaliczenie");
        return "welcome";
    }





}
