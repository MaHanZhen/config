package com.mhz.history.config.dao;

import com.mhz.history.config.domin.FactorDataGroupCfg;
import com.mhz.history.config.domin.Meter400V;
import com.mhz.history.config.domin.MeterChannel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface IFactorDataGroupCfgDao extends JpaRepositoryImplementation<FactorDataGroupCfg,String> {

    @Query("select t from FactorDataGroupCfg t where t.enabled = true and t.parentId = :parentId ")
    Page<FactorDataGroupCfg> findCfgPoint(String parentId, Pageable pageRequest);
}
