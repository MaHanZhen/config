package com.mhz.history.config.service.impl;

import com.mhz.history.config.dao.IMeterChannelDao;
import com.mhz.history.config.domin.MeterChannel;
import com.mhz.history.config.vo.MeterChannelVO;
import com.mhz.history.config.service.IMeterChannelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeterChannelService implements IMeterChannelService {

    @Resource
    private IMeterChannelDao meterChannelDao;


    @Override
    public Page<MeterChannel> listMeterChannel(final MeterChannelVO meterChannelVO, Pageable pageable) {

        Specification<MeterChannel> specification = (Specification<MeterChannel>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(cb.isTrue(root.get("enabled")));

            if (!StringUtils.isEmpty(meterChannelVO.getKeyWord())) {
                predicates.add(cb.or(cb.like(root.get("name"), "%"+ meterChannelVO.getKeyWord()+"%"),cb.like(root.get("address"), "%"+ meterChannelVO.getKeyWord()+"%")));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        Page<MeterChannel> channels = meterChannelDao.findAll(specification, pageable);
        return channels;
    }

    @Override
    public MeterChannel save(MeterChannel meterChannel) {
        meterChannel.setEnabled(true);
        return this.meterChannelDao.save(meterChannel);
    }

    @Override
    public List<MeterChannel> checkSaveData(MeterChannel param) {
        return  meterChannelDao.findCheckData(param.getChannelName(),param.getChannelAddress());
    }


    @Override
    public MeterChannel getMeterChannel(String id) {
        return meterChannelDao.getOne(id);
    }

    @Override
    public void disable(String ...ids) {
        for (String id : ids) {
            this.meterChannelDao.disable(id);
        }
    }
}
