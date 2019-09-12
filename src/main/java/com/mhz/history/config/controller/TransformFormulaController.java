package com.mhz.history.config.controller;

import com.mhz.history.config.service.ITransformFormulaService;
import com.mhz.history.config.util.LayUiUtil;
import com.mhz.history.config.vo.TransformFormulaVO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller

@RequestMapping("/TransformFormula")
public class TransformFormulaController extends BaseController {

    @Resource
    private ITransformFormulaService transformFormulaService;


    @RequestMapping("/listTransformFormula")
    @ResponseBody
    public Object listTransformFormula(String meterId){
        Page<TransformFormulaVO> result = this.transformFormulaService.listTransformFormula(meterId,this.getPageRequest());
        return LayUiUtil.transformLayUiTableData(result);
    }

}
