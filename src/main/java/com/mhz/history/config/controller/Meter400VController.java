package com.mhz.history.config.controller;

import com.mhz.history.config.domin.Meter400V;
import com.mhz.history.config.msg.Message;
import com.mhz.history.config.service.IMeter400VService;
import com.mhz.history.config.util.LayUiUtil;
import com.mhz.history.config.vo.Meter400VVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Meter400V")
public class Meter400VController extends BaseController {

    @Resource
    private IMeter400VService meter400VService;

    @RequestMapping("/index")
    public String index(){
        return "meter400v/index";
    }

    @RequestMapping("/listMeter400V")
    @ResponseBody
    public Object listMeter400V(Meter400VVO param){
        Pageable pageRequest = this.getPageRequest();
        Page<Meter400V> meters = this.meter400VService.listMeter400V(param,pageRequest);
        return LayUiUtil.transformLayUiTableData(meters);
    }

    @RequestMapping("/toNew")
    public String toNew(Model model){
        model.addAttribute("method","save");
        return "meter400v/update";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Message save(Meter400V param){
        Meter400V meter400V = this.meter400VService.save(param);
        return Message.success(meter400V);
    }

    @RequestMapping("/toEdit")
    public String toEdit (String id,Model model){
        model.addAttribute("method","update");
        model.addAttribute("id",id);
        return "meter400v/update";
    }

    @RequestMapping("/getMeter400V")
    @ResponseBody
    public Message getMeter400V(String id){
        Meter400V meter400V = this.meter400VService.getMeter400V(id);
        return Message.success(meter400V);
    }

    @RequestMapping("disable")
    @ResponseBody
    public Message disable(String ids){
        this.meter400VService.disable(ids.split(","));
        return Message.success();
    }

}
