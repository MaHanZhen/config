package com.mhz.history.config.dao;

import com.mhz.history.config.domin.FactorDataGroupCfg;
import com.mhz.history.config.domin.Meter400V;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface IFactorDataGroupCfgDao extends JpaRepositoryImplementation<FactorDataGroupCfg,String> {
}
