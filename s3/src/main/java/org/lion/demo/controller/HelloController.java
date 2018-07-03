package org.lion.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/")
    public ModelAndView hello() {
        ModelAndView view = new ModelAndView("index");
        return view;
    }
}