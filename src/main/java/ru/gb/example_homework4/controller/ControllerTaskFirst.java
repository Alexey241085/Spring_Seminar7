package ru.gb.example_homework4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // // класс контроллер первого задания hello.html
public class ControllerTaskFirst {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "hello";
    }
}
