package com.mhz.history.config.controller;

import com.mhz.history.config.service.IFactorDataGroupCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/FactorDataGroupCfg")
public class FactorDataGroupCfgController  extends BaseController {


    @Resource
    private IFactorDataGroupCfgService factorDataGroupCfgService;

    @RequestMapping("/index")
    public String index(){
        return "factordatagroupcfg/index";
    }

    @RequestMapping("cfgTree")
    @ResponseBody
    public Object cfgTree(String meterId){
        return  factorDataGroupCfgService.cfgTree(meterId);
    }
}
