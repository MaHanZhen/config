package com.mhz.history.config.service.impl;

import com.mhz.history.config.dao.ITransformFormulaDao;
import com.mhz.history.config.dao.ITransformFormulaNativeSqlDao;
import com.mhz.history.config.service.ITransformFormulaService;
import com.mhz.history.config.vo.TransformFormulaVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TransformFormulaService implements ITransformFormulaService {

    @Resource
    private ITransformFormulaDao transformFormulaDao;

    @Resource
    private ITransformFormulaNativeSqlDao transformFormulaNativeSqlDao;

    @Override
    public Page<TransformFormulaVO> listTransformFormula(String meterId, Pageable pageRequest) {
        return this.transformFormulaNativeSqlDao.listTransformFormula(meterId,pageRequest);
    }
}
