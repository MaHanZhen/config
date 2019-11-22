package com.mhz.history.config.dao.impl;

import com.mhz.history.config.dao.BaseNativeSqlDao;
import com.mhz.history.config.dao.IFactorDataGroupCfNativeSqlDao;
import com.mhz.history.config.domin.FactorDataGroupCfg;
import com.mhz.history.config.vo.FactorDataGroupCfgVO;
import com.mhz.history.config.vo.LayUiDTreeNode;
import com.mhz.history.config.vo.TransformFormulaVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FactorDataGroupCfNativeSqlDao extends BaseNativeSqlDao implements IFactorDataGroupCfNativeSqlDao {

    @Override
    public List<LayUiDTreeNode> listAllTreeNode() {
        String sql = "SELECT t.ID id, IFNULL(t.PARENT_ID, '-1') parent_id,t.`NAME` title FROM mea_factor_data_group_cfg t where t.ENABLED = '1' and t.FACTOR_ID is  NULL";
        return this.queryNativeSql(LayUiDTreeNode.class,sql,new HashMap<>());
    }

    @Override
    public Page<FactorDataGroupCfgVO> findCfgPoint(String parentId, Pageable pageRequest) {
        StringBuffer sql = new StringBuffer();
        Map<String,Object> param =new HashMap<>();
        sql.append(" SELECT cfg.ID ,cfg.NAME ,cfg.UI_CONTROL ");
        sql.append("     ,mc.ADDRESS CHANNEL_ADDRESS,mc.NAME CHANNEL_NAME,mc.RATE CHANNEL_RATE ");
        sql.append("     ,cfg.HANDLER_IDENTIFY,cfg.HANDLER_FIELDS,cfg.HANDLER_FIELD_RATES ");
        sql.append(" FROM mea_factor_data_group_cfg cfg LEFT JOIN perce_meter_channel mc ON cfg.FACTOR_ID = mc.ID AND mc.ENABLED = '1' ");
        sql.append(" WHERE mc.ENABLED = '1' ");

        if(!StringUtils.isEmpty(parentId)){
            sql.append(" and cfg.PARENT_ID = :parentId ");
            param.put("parentId",parentId);
        }

        return this.queryNativeSql(FactorDataGroupCfgVO.class,sql.toString(),param,pageRequest);
    }

    @Override
    public String generateId() {
        String sql = "SELECT IFNULL(MAX(id+1),1) id FROM mea_factor_data_group_cfg";
        List<Map<String, Object>> maps = this.queryMapNativeSql(sql, new HashMap<>());
        Double id = (Double) maps.get(0).get("id");
        return id.intValue()+"";
    }

    @Override
    public String generateLayerOrder(String baseLayerOrder,Integer index) {
        String sql = "SELECT max(SUBSTRING(LAYER_ORDER,"+index+",4)+1) layerOrder  FROM mea_factor_data_group_cfg cfg where cfg.LAYER_ORDER like :baseLayerOrder ";
        Map<String,Object> param =new HashMap<>();
        param.put("baseLayerOrder",baseLayerOrder+"%");

        List<Map<String, Object>> maps = this.queryMapNativeSql(sql, param);

        Double layerOrder  = Optional.ofNullable(maps).map(obj->obj.get(0)).map(obj->obj.get("layerOrder")).map(obj->(Double) obj).orElse(0D);
        return layerOrder.intValue()+"";
    }
}
