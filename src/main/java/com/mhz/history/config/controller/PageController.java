package com.mhz.history.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/layout")
    public String layout(){
        return "layout";
    }
}
