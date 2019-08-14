package com.mhz.history.config.service;

import com.mhz.history.config.domin.MeterChannel;
import com.mhz.history.config.vo.MeterChannelVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMeterChannelService {


    Page<MeterChannel> listMeterChannel(MeterChannelVO meterChannelVO, Pageable pageable);

    MeterChannel save(MeterChannel meterChannel);

    List<MeterChannel> checkSaveData(MeterChannel param);

    MeterChannel getMeterChannel(String id);

    void disable(String ...ids);
}
