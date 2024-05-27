package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExitController {
    @Autowired
    private ApplicationContext apx;
    @GetMapping("/shutdown")
    public void shutdownApp(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        new ModelAndView("shutdown");
        model.addAttribute("name", name);
    }
}
