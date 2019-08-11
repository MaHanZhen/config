package com.mhz.history.config.service;

import com.mhz.history.config.domin.MeterChannel;
import com.mhz.history.config.param.MeterChannelParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMeterChannelService {


    Page<MeterChannel> listMeterChannel(MeterChannelParam meterChannelParam, Pageable pageable);

    MeterChannel save(MeterChannel meterChannel);
}
