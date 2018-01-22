package com.pp.infa.i_budynki.controllers;

import com.pp.infa.i_budynki.domain.User;
import com.pp.infa.i_budynki.service.UserService;
import com.pp.infa.i_budynki.validators.EmailValidator;
import com.pp.infa.i_budynki.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Blazej on 13.11.2017.
 */
@Controller
@SessionAttributes("user")
//@RequestMapping("/stacja")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerForm(Model model,  @ModelAttribute("user")  @Valid User user, BindingResult result) {

       if(result.hasErrors()){
            return "register";
        }

        userService.register(user);

            return "redirect:/login";
    }
    @InitBinder
    public void initialiseBinder(WebDataBinder binder){
        binder.setAllowedFields("name","surname","login","password","matchingPassword","email");
        //binder.addValidators(passwordValidator,emailValidator);
    }
}
