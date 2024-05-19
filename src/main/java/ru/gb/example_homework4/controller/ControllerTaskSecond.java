package ru.gb.example_homework4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // класс контроллер вторго задания calc.html
public class ControllerTaskSecond {

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public String getCalc(){
        return "calc";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public String postCalc(Model model, @RequestParam(name = "num1") double num1,
                           @RequestParam(name = "num2") double num2){
        double result1 = num1 + num2;
        double result2 = num1 - num2;
        double result3 = num1 / num2;
        double result4 = num1 * num2;
        model.addAttribute("res1", result1);
        model.addAttribute("res2", result2);
        model.addAttribute("res3", result3);
        model.addAttribute("res4", result4);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "calc";
    }
}
