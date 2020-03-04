package com.mhz.history.config.dao;

import com.mhz.history.config.domin.FactorDataGroupCfg;
import com.mhz.history.config.domin.Meter400V;
import com.mhz.history.config.domin.MeterChannel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface IFactorDataGroupCfgDao extends JpaRepositoryImplementation<FactorDataGroupCfg,String> {

    @Query("select t from FactorDataGroupCfg t where t.enabled = true and t.parentId = :parentId ")
    Page<FactorDataGroupCfg> findCfgPoint(String parentId, Pageable pageRequest);

    @Modifying
    @Query(" update FactorDataGroupCfg t set t.name = :name where  t.id=:id")
    void updateTreeNode(String id, String name);

    @Modifying
    @Query(" update FactorDataGroupCfg t set t.enabled = false where  t.layerOrder like :layerOrder ")
    void deleteTreeNode(String layerOrder);
}
