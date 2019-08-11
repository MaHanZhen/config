package com.mhz.history.config.dao;

import com.mhz.history.config.domin.MeterChannel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMeterChannelDao extends JpaRepositoryImplementation<MeterChannel,String> {


    @Transactional
    @Query(" update MeterChannel  set enabled = false where  id=:id")
    MeterChannel disable(String id);

    @Query(" FROM MeterChannel t where t.enabled = true and (t.name = :name or t.address = :address) ")
    List<MeterChannel> findCheckData(String name,String address);

}
