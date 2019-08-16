package com.mhz.history.config.service;

import com.mhz.history.config.domin.Meter400V;
import com.mhz.history.config.vo.Meter400VVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMeter400VService {
    Page<Meter400V> listMeter400V(Meter400VVO param, Pageable pageRequest);

    Meter400V save(Meter400V param);

    Meter400V getMeter400V(String id);
}
