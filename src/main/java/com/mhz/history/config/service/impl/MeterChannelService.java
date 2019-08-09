package com.mhz.history.config.service.impl;

import com.mhz.history.config.dao.IMeterChannelDao;
import com.mhz.history.config.domin.MeterChannel;
import com.mhz.history.config.param.MeterChannelParam;
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
    public Page<MeterChannel> listMeterChannel(final MeterChannelParam meterChannelParam, Pageable pageable) {

        Specification<MeterChannel> specification = (Specification<MeterChannel>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(meterChannelParam.getKeyWord())) {
                predicates.add(cb.or(cb.like(root.get("name"), "%"+meterChannelParam.getKeyWord()+"%"),cb.like(root.get("address"), "%"+meterChannelParam.getKeyWord()+"%")));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        Page<MeterChannel> channels = meterChannelDao.findAll(specification, pageable);
        return channels;
    }
}
