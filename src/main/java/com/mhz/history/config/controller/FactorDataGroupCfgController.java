package com.mhz.history.config.controller;

import com.mhz.history.config.domin.FactorDataGroupCfg;
import com.mhz.history.config.msg.Message;
import com.mhz.history.config.service.IFactorDataGroupCfgService;
import com.mhz.history.config.util.LayUiUtil;
import com.mhz.history.config.vo.FactorDataGroupCfgVO;
import com.mhz.history.config.vo.LayUiDTreeNode;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/FactorDataGroupCfg")
public class FactorDataGroupCfgController  extends BaseController {


    @Resource
    private IFactorDataGroupCfgService factorDataGroupCfgService;

    @RequestMapping("/index")
    public String index(){
        return "factordatagroupcfg/index";
    }


    @RequestMapping("/cfgTree")
    @ResponseBody
    public Object cfgTree(String parentId){
        List<LayUiDTreeNode> treeNodes = this.factorDataGroupCfgService.listAllTreeNode();
        return LayUiUtil.transformLayUiDTreeData(treeNodes);
    }

    @RequestMapping("/addTreeNode")
    @ResponseBody
    public Object addTreeNode(String name, String parentId){
        if(StringUtils.isEmpty(name)){
            return new FactorDataGroupCfg();
        }
        FactorDataGroupCfg factorDataGroupCfg = this.factorDataGroupCfgService.addTreeNode(parentId,name);
        return factorDataGroupCfg;
    }


    @RequestMapping("/updateTreeNode")
    @ResponseBody
    public Object updateTreeNode(String id, String name){
       this.factorDataGroupCfgService.updateTreeNode(id,name);
       return "";
    }

    @RequestMapping("/deleteTreeNode")
    @ResponseBody
    public Object deleteTreeNode(String id){
        this.factorDataGroupCfgService.deleteTreeNode(id);
        return "";
    }


    @RequestMapping("/cfgPoint")
    @ResponseBody
    public Object cfgPoint(String parentId){
        Page<FactorDataGroupCfgVO> data = this.factorDataGroupCfgService.findCfgPoint(parentId,getPageRequest());
        return LayUiUtil.transformLayUiTableData(data);
    }

    @RequestMapping("/toNew/{parentId}")
    public String toNew(@PathVariable String parentId, Model model){
        model.addAttribute("parentId",parentId);
        return "factordatagroupcfg/update";
    }


    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable String id, Model model){
        model.addAttribute("id",id);
        return "factordatagroupcfg/update";
    }


    @RequestMapping("/saveCfgPoint")
    @ResponseBody
    public Object saveCfgPoint(FactorDataGroupCfg factorDataGroupCfg){
        try {
            this.factorDataGroupCfgService.saveCfgPoint(factorDataGroupCfg);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.error(e.getMessage());
        }
        return Message.success();
    }


    @RequestMapping("/updateCfgPoint")
    @ResponseBody
    public Object updateCfgPoint(FactorDataGroupCfg baseItem){
        return baseItem;
    }

}
