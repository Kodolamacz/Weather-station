package com.pp.infa.i_budynki.controllers;

import com.pp.infa.i_budynki.domain.Login;
import com.pp.infa.i_budynki.domain.Sensor;
import com.pp.infa.i_budynki.domain.User;
import com.pp.infa.i_budynki.service.MeasureService;
import com.pp.infa.i_budynki.service.SensorService;
import com.pp.infa.i_budynki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Blazej on 13.11.2017.
 */
@Controller
@SessionAttributes(value = {"login","user","sensors","sensor"})
//@RequestMapping("/stacja")
//@Scope("session")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private SensorService sensorService;

    @Autowired
    private MeasureService measureService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("login",new Login());

//        Sensor sensor = sensorService.getSensorById(5);
//        measureService.getSensorData(sensor);
        return "login";

    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginProcess(Model model, @ModelAttribute("login") @Valid Login login, BindingResult result){


            if(result.hasErrors()){
                return "login";
            }
            User user = userService.checkUser(login);

            if(user != null) {
                System.out.println(user.getName());

                List<Sensor> sensors = sensorService.getSensors(user);
                //user.setSensorsList(sensors);
                model.addAttribute("user", user);
                model.addAttribute("sensors",sensors);
                model.addAttribute("sensor",new Sensor());

                return "redirect:/userPage";
            }
            else{
                return "redirect:/login";
            }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, SessionStatus status){

        HttpSession session = request.getSession();
        //System.out.println("PRZED " + session.getAttribute("user"));
        session.invalidate();
        status.setComplete();
        return "redirect:/login";
    }
//    @RequestMapping(value = "/loginProcess",method = RequestMethod.POST)
//    public String loginProcess(Model model, @ModelAttribute("login") @Valid Login login, BindingResult result){
//
//
//        if(result.hasErrors()){
//            return "login";
//        }
//        User user = userService.checkUser(login);
//
////        if(user != null) {
////            List<Sensor> sensors = sensorService.getSensors(user);
////            //user.setSensorsList(sensors);
////            model.addAttribute("user", user);
////            model.addAttribute("sensors",sensors);
////            model.addAttribute("sensor",new Sensor());
////
////            return "redirect:/loginProcess";
////        }
////        else{
////            return "redirect:/login";
////        }
//    }

//    @RequestMapping(value = "/loginProcess",method = RequestMethod.GET)
//    public String getChartView(Model model, @SessionAttribute("user") User user) {
//        //User user = userService.checkUser(login);
//
//        if (user != null) {
//            List<Sensor> sensors = sensorService.getSensors(user);
//            //user.setSensorsList(sensors);
//            //  model.addAttribute("user", user);
//            model.addAttribute("sensors", sensors);
//           // model.addAttribute("sensor", new Sensor());
//
//            // model.addAttribute()
//            return "redirect:/userPage";
//        }
//        return "redirect:/userPage";
   // }

    @RequestMapping(value = "/userPage",method = RequestMethod.GET)
    public String getUserPage(){

            return "userPage";

    }


    @RequestMapping(value = "/addSensor", method = RequestMethod.GET)
    public String insertSensor(Model model){
        model.addAttribute("sensor",new Sensor());
        return "addSensor";
    }
    @RequestMapping(value = "/addSensor", method = RequestMethod.POST)
    public String insertSensorProcess(Model model, @ModelAttribute("sensor") @Valid Sensor sensor,BindingResult result){

        if(result.hasErrors()){
            return "addSensor";
        }

        sensorService.addSensor(sensor.getName(),sensor.getOwner());
        User user = userService.findUserByUsername(sensor.getOwner());
//
        List<Sensor> sensors = sensorService.getSensors(user);
        model.addAttribute("user",user);
        model.addAttribute("sensors",sensors);
        return "redirect:/userPage";
    }




}
