package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    // Handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){ return "Hello, Spring!"; }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){ return "Goodbye, Spring"; }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language, Model model){
        String  languageText = "";

        if(language.equals("english")){
            languageText = "Hello";
        } else if(language.equals("french")){
            languageText = "Bonjour";
        } else if(language.equals("spanish")){
            languageText = "Hola";
        } else if(language.equals("latin")){
            languageText = "Salve";
        } else if(language.equals("russian")){
            languageText = "Привет";
        }

        String textToDisplay = languageText + ", " + name + "!";

        model.addAttribute("textToDisplay", textToDisplay);

        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String textToDisplay = "Hello, " + name + "!";

        model.addAttribute("textToDisplay", textToDisplay);

        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello/list")
    public String listOfNames(Model model){
        String[] names = {"Josh", "James", "Bill", "Frank"};

        model.addAttribute("names", names);

        return "hello-list";
    }
}
