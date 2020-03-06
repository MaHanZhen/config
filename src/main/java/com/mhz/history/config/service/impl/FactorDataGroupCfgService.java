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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.ListUtils;

import javax.annotation.Resource;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.Predicate;
import java.util.*;

@Service
public class FactorDataGroupCfgService implements IFactorDataGroupCfgService {


    private static final String CHECK_BOX = "checkbox";
    private static final String SELECT = "select";

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
        factorDataGroupCfg.setShowPrice("0");
        factorDataGroupCfg.setOrderNo(0);

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

    @Transactional
    @Override
    public void updateTreeNode(String id, String name) {
        this.factorDataGroupCfgDao.updateTreeNode(id,name);
    }

    @Transactional
    @Override
    public void deleteTreeNode(String id) {
        Optional<FactorDataGroupCfg> factorDataGroupCfg = this.factorDataGroupCfgDao.findById(id);
        factorDataGroupCfg.ifPresent(obj->factorDataGroupCfgDao.deleteTreeNode(obj.getLayerOrder()+"%"));
    }

    @Override
    public void saveCfgPoint(FactorDataGroupCfg factorDataGroupCfg) throws Exception {

        String id = factorDataGroupCfNativeSqlDao.generateId();
        String layerOrder= generateLayerOrder(factorDataGroupCfg.getParentId());

        factorDataGroupCfg.setId(id);
        factorDataGroupCfg.setLayerOrder(layerOrder);
        factorDataGroupCfg.setEnabled(true);
        factorDataGroupCfg.setDataName(factorDataGroupCfg.getName());
        factorDataGroupCfg.setShowPrice("0");
        factorDataGroupCfg.setOrderNo(0);

        if(SELECT.equals(factorDataGroupCfg.getUiControl())){
            factorDataGroupCfg = handleSelectType(factorDataGroupCfg);
        }else{
            factorDataGroupCfg.setKey(id);
            factorDataGroupCfg.setFullKey(getFullKey(factorDataGroupCfg.getParentId(),id));
        }

        System.out.println(factorDataGroupCfg);
        this.factorDataGroupCfgDao.save(factorDataGroupCfg);
    }

    private FactorDataGroupCfg handleSelectType(FactorDataGroupCfg factorDataGroupCfg) throws Exception{

        FactorDataGroupCfg parent = this.factorDataGroupCfgDao.getOne(factorDataGroupCfg.getParentId());

        if(parent ==null || StringUtils.isEmpty(parent.getParentId())){
            throw new Exception("该分类不能选用选择框控件");
        }

        FactorDataGroupCfg crossParent = this.factorDataGroupCfgDao.getOne(parent.getParentId());
        factorDataGroupCfg.setCrossParentId(crossParent.getId());

        List<FactorDataGroupCfg> subCrossCfgList = this.factorDataGroupCfgDao.getSubCrossCfgByName(crossParent.getId(),factorDataGroupCfg.getName());

        if(ListUtils.isEmpty(subCrossCfgList)){
            factorDataGroupCfg.setKey(factorDataGroupCfg.getId());
        }else{
            factorDataGroupCfg.setKey(subCrossCfgList.get(0).getKey());
        }

        String fullKey = crossParent.getFullKey()+"-"+parent.getKey()+"-"+factorDataGroupCfg.getKey();
        factorDataGroupCfg.setFullKey(fullKey);

        return factorDataGroupCfg;
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
