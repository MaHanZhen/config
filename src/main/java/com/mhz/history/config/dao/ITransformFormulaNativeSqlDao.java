package com.mhz.history.config.dao;

import com.mhz.history.config.vo.TransformFormulaVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ITransformFormulaNativeSqlDao {

    Page<TransformFormulaVO> listTransformFormula(String meterId, Pageable pageRequest);

    List<Map<String,Object>> listTransformFormula(String meterId);
}
