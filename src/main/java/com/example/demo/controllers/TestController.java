package com.example.demo.controllers;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    @GetMapping(value = "/test")
    public String getTemplate(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        log.info("<<<<<<< START TestController >>>>>>>");
        model.addAttribute("name", name);
        return "test";
    }
    @PreDestroy
    public void preDestroy() {
        log.info("<<<<<<< THE END TestController >>>>>>>");
    }
}
