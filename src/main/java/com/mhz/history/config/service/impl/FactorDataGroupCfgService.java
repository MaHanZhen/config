package com.mhz.history.config.service.impl;

import com.mhz.history.config.dao.IFactorDataGroupCfgDao;
import com.mhz.history.config.dao.ITransformFormulaNativeSqlDao;
import com.mhz.history.config.domin.FactorDataGroupCfg;
import com.mhz.history.config.service.IFactorDataGroupCfgService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.ManyToOne;
import java.util.*;

@Service
public class FactorDataGroupCfgService implements IFactorDataGroupCfgService {

    @Resource
    ITransformFormulaNativeSqlDao transformFormulaNativeSqlDao;

    @Resource
    IFactorDataGroupCfgDao factorDataGroupCfgDao;

    @Override
    public Object cfgTree(String meterId) {
        List<Map<String, Object>> maps = transformFormulaNativeSqlDao.listTransformFormula(meterId);

        //获取所有信道分类上级
        Map<String, FactorDataGroupCfg> parents = new HashMap<>();
        maps.forEach(map -> getFactorParent(parents, map.get("ID").toString()));

        //把信道转为树节点
        return getFactorParentGroup(parents);
    }

    private Map<String, List<FactorDataGroupCfg>> getFactorParentGroup(Map<String, FactorDataGroupCfg> parents) {
        Map<String, List<FactorDataGroupCfg>> result = new HashMap<>();

        parents.forEach((k, cfg) -> {
            String parentId = Optional.ofNullable(cfg.getParentId()).orElse("-1");
            List<FactorDataGroupCfg> cfgs = Optional.ofNullable(result.get(parentId)).orElse(new ArrayList<>());
            cfgs.add(cfg);
            result.put(parentId, cfgs);
        });

        return result;
    }

    private void getFactorParent(Map<String, FactorDataGroupCfg> parents, String id) {

        Optional<FactorDataGroupCfg> optional = Optional.ofNullable(parents.get(id));

        if (!optional.isPresent() && !StringUtils.isEmpty(id)) {
            optional = factorDataGroupCfgDao.findById(id);
        }

        if (optional.isPresent() && optional.get().getEnabled()) {
            parents.put(id, optional.get());
            getFactorParent(parents, optional.get().getParentId());
        }
    }
}
