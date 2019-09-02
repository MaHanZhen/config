package com.mhz.history.config.service.impl;

import com.mhz.history.config.dao.IMeter400VDao;
import com.mhz.history.config.domin.Meter400V;
import com.mhz.history.config.service.IMeter400VService;
import com.mhz.history.config.vo.Meter400VVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Meter400VService implements IMeter400VService {

    @Resource
    private IMeter400VDao meter400VDao;

    @Override
    public Page<Meter400V> listMeter400V(Meter400VVO param, Pageable pageRequest) {

        Specification<Meter400V> specification = (Specification<Meter400V>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.isTrue(root.get("enabled")));
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        return this.meter400VDao.findAll(specification,pageRequest);
    }

    @Override
    public Meter400V save(Meter400V param) {
        param.setEnabled(true);
        return this.meter400VDao.save(param);
    }

    @Override
    public Meter400V getMeter400V(String id) {
        return this.meter400VDao.getOne(id);
    }

    @Override
    public void disable(String... ids) {
        for (String id : ids) {
            this.meter400VDao.disable(id);
        }
    }
}
