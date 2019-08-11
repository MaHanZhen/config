package com.mhz.history.config.controller;

import com.mhz.history.config.domin.MeterChannel;
import com.mhz.history.config.msg.Message;
import com.mhz.history.config.param.MeterChannelParam;
import com.mhz.history.config.service.IMeterChannelService;
import com.mhz.history.config.util.LayUiUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.ListUtils;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/MeterChannel")
public class MeterChannelController extends BaseController {

    @Resource
    private IMeterChannelService meterChannelService;



    @RequestMapping("listMeterChannel")
    @ResponseBody
    public Object listMeterChannel(MeterChannelParam  meterChannelParam){
        Page<MeterChannel> channels = this.meterChannelService.listMeterChannel(meterChannelParam,getPageRequest());
        return LayUiUtil.transformLayUiTableData(channels);
    }

    @RequestMapping("/index")
    public String index(){
        return "meterchannel/index";
    }

    @RequestMapping("/toNew")
    public String toNew(Model model){
        model.addAttribute("method","save");
        return "meterchannel/update";
    }


    @RequestMapping("/checkSaveData")
    @ResponseBody
    public Message checkSaveData(MeterChannel param){
        List<MeterChannel> result = this.meterChannelService.checkSaveData(param);

        if(ListUtils.isEmpty(result)){
            return Message.success();
        }

        return Message.error(result);
    }

    @RequestMapping("/save")
    @ResponseBody
    public Message save(MeterChannel param){
        MeterChannel save = this.meterChannelService.save(param);
        return Message.success(save);
    }

}
