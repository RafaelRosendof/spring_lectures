package com.MVCE.figas.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //criando para o /hello
    @GetMapping("/hello")
    public String falaOi(Model model){
        model.addAttribute("A data" , java.time.LocalDate.now());

        return "helloworld";
    }


}
