package com.mhz.history.config.dao;

import com.mhz.history.config.domin.Meter400V;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.transaction.annotation.Transactional;

public interface IMeter400VDao extends JpaRepositoryImplementation<Meter400V,String> {

    @Transactional
    @Modifying
    @Query(" update Meter400V t set t.enabled = false where  t.id=:id")
    void disable(String id);

}
