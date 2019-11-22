package com.mhz.history.config.service.impl;

import com.mhz.history.config.dao.IFactorDataGroupCfNativeSqlDao;
import com.mhz.history.config.dao.IFactorDataGroupCfgDao;
import com.mhz.history.config.dao.ITransformFormulaNativeSqlDao;
import com.mhz.history.config.domin.FactorDataGroupCfg;
import com.mhz.history.config.domin.Meter400V;
import com.mhz.history.config.service.IFactorDataGroupCfgService;
import com.mhz.history.config.vo.FactorDataGroupCfgVO;
import com.mhz.history.config.vo.LayUiDTreeNode;
import jdk.internal.util.xml.impl.Input;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.Predicate;
import java.util.*;

@Service
public class FactorDataGroupCfgService implements IFactorDataGroupCfgService {

    @Resource
    ITransformFormulaNativeSqlDao transformFormulaNativeSqlDao;

    @Resource
    IFactorDataGroupCfgDao factorDataGroupCfgDao;

    @Resource
    IFactorDataGroupCfNativeSqlDao factorDataGroupCfNativeSqlDao;

    @Override
    public List<LayUiDTreeNode> listAllTreeNode() {
        return factorDataGroupCfNativeSqlDao.listAllTreeNode();
    }

    @Override
    public Page<FactorDataGroupCfgVO> findCfgPoint(String parentId, Pageable pageRequest) {
        return this.factorDataGroupCfNativeSqlDao.findCfgPoint(parentId,  pageRequest);
    }

    @Override
    public synchronized FactorDataGroupCfg addTreeNode(String parentId, String name) {
        String id = factorDataGroupCfNativeSqlDao.generateId();
        String layerOrder= generateLayerOrder(parentId);

        FactorDataGroupCfg factorDataGroupCfg = new FactorDataGroupCfg();
        factorDataGroupCfg.setId(id);
        factorDataGroupCfg.setLayerOrder(layerOrder);

        factorDataGroupCfg.setKey(id);
        factorDataGroupCfg.setFullKey(getFullKey(parentId,id));
        factorDataGroupCfg.setName(name);
        factorDataGroupCfg.setEnabled(true);
        factorDataGroupCfg.setParentId(parentId);
        factorDataGroupCfg.setDataName(name);
        factorDataGroupCfg.setUiControl("checkbox");
        factorDataGroupCfg.setFactorId(null);

        return factorDataGroupCfgDao.save(factorDataGroupCfg);
    }


    private String generateLayerOrder(String parentId){
        if(StringUtils.isEmpty(parentId)){
            parentId = "-1";
        }
        Optional<FactorDataGroupCfg> groupCfg = factorDataGroupCfgDao.findById(parentId);
        String parentLayerOrder = groupCfg.map(FactorDataGroupCfg::getLayerOrder).orElse("");
        Integer index = parentLayerOrder.length()+1;

        String layerOrder = this.factorDataGroupCfNativeSqlDao.generateLayerOrder(parentLayerOrder,index);
        if(layerOrder.length()<4){
           String zero = "";
           for (int i = 0;i<4-layerOrder.length();i++){
               zero+="0";
           }
           layerOrder = zero + layerOrder;
        }

        return parentLayerOrder+layerOrder;
    }

    private String getFullKey(String parentId,String id){

        if(StringUtils.isEmpty(parentId)){
            return id;
        }

        Optional<FactorDataGroupCfg> groupCfg = factorDataGroupCfgDao.findById(parentId);
        String fullKey = groupCfg.map(FactorDataGroupCfg::getFullKey).orElse("");
        return fullKey+"-"+id;
    }
}
