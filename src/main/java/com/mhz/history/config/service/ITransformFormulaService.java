package com.mhz.history.config.service;

import com.mhz.history.config.vo.TransformFormulaVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITransformFormulaService {
    Page<TransformFormulaVO> listTransformFormula(String meterId, Pageable pageRequest);
}
