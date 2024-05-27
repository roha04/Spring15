package com.example.demo.controllers;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class TimeController {
    private static final Logger log = LoggerFactory.getLogger(TimeController.class);
    @GetMapping(value = "/time")
    public ModelAndView getTime() {
        ModelAndView result = new ModelAndView("time/current");
        result.addObject("now", LocalDateTime.now());
        return result;
    }
    /** 1 - Create current.html file in /resources/template/time directory of projects with example body
     *  <p th:text="'Hello, ' + ${now} + '!'" />
     *  2 - Run the Gradle project on right side ide panel: [project name]>[Tasks]>[Application]>[bootRun] - double Click!
     *  3 - On Browser type http://localhost:8080/time
     *  */
    @PreDestroy
    public void preDestroy() {
        log.info("<<<<<<< THE END TimeController >>>>>>>");
    }
}
