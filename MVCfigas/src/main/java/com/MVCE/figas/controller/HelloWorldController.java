//package main.java.com.MVCE.figas.controller;
package com.MVCE.figas.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloWorldController{
    
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    //helloworld-form.html

    //precisa de um método controller para processar o formulário
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request , Model model){
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "Yo! " + theName;

        model.addAttribute("message" , result);
        
        return "helloworld"; 
    }

    @RequestMapping("/processFormVersionThree")
    public String requestMethodName(@RequestParam("studentName") String theName , Model model) {
        theName = theName.toUpperCase();
        String result = "Fala figas como vc vai?" + theName;

        model.addAttribute("message", result);
        return "helloworld";
    }
    //tiene que atualizar o helloworld-form.html na parte de $processFormVersionThree
    
}