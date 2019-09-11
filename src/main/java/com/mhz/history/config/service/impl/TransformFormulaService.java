package com.mhz.history.config.service.impl;

import com.mhz.history.config.dao.ITransformFormulaDao;
import com.mhz.history.config.domin.TransformFormula;
import com.mhz.history.config.service.ITransformFormulaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TransformFormulaService implements ITransformFormulaService {

    @Resource
    private ITransformFormulaDao transformFormulaDao;

    @Override
    public Page<TransformFormula> listTransformFormula(String meterId, Pageable pageRequest) {
        return this.transformFormulaDao.listTransformFormula(meterId,pageRequest);
    }
}
