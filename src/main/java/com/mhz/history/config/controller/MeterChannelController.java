package com.mhz.history.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MeterChannel")
public class MeterChannelController extends BaseController {

    @RequestMapping("index")
    public String index(){
        return "meterchannel/index";
    }
}
