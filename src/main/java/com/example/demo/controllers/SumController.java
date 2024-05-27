package com.example.demo.controllers;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SumController {
    private static final Logger log = LoggerFactory.getLogger(SumController.class);
    @GetMapping("/sum")
    public ModelAndView sumInt(@RequestParam(name="a", required=false, defaultValue="0") int a,
                               @RequestParam(name="b", required=false, defaultValue="0") int b) {
        /** пояснення що до конвертації defaultValue > int
         *  https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/expressions.html
         *  */
        ModelAndView result = new ModelAndView("summa");
        result.addObject("result", a+b);
        return result;
    }
    @PreDestroy
    public void preDestroy() {
        log.info("<<<<<<< THE END SumController >>>>>>>");
    }
}
