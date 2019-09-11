package com.mhz.history.config.service;

import com.mhz.history.config.domin.TransformFormula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITransformFormulaService {
    Page<TransformFormula> listTransformFormula(String meterId, Pageable pageRequest);
}
