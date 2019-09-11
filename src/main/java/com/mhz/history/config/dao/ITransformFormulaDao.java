package com.mhz.history.config.dao;

import com.mhz.history.config.domin.MeterChannel;
import com.mhz.history.config.domin.TransformFormula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ITransformFormulaDao extends JpaRepositoryImplementation<TransformFormula,String> {

    @Query("FROM TransformFormula where meter400V.id = :meterId ")
    Page<TransformFormula> listTransformFormula(String meterId, Pageable pageRequest);
}
