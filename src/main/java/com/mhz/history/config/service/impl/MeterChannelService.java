package com.mhz.history.config.service.impl;

import com.mhz.history.config.dao.MeterChannelDao;
import com.mhz.history.config.service.IMeterChannelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MeterChannelService implements IMeterChannelService {

    @Resource
    private MeterChannelDao meterChannelDao;



}
