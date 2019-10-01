package com.mhz.history.config.dao.impl;

import com.mhz.history.config.dao.BaseNativeSqlDao;
import com.mhz.history.config.dao.ITransformFormulaNativeSqlDao;
import com.mhz.history.config.vo.TransformFormulaVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransformFormulaNativeSqlDao extends BaseNativeSqlDao implements ITransformFormulaNativeSqlDao {

    @Override
    public Page<TransformFormulaVO> listTransformFormula(String meterId, Pageable pageRequest) {

        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT  ");
        sql.append(" 	coll.*, ");
        sql.append(" 	dtu.MODEL dtu_name, ");
        sql.append(" 	ch.ADDRESS channel_address, ");
        sql.append(" 	ch.rate, ");
        sql.append(" 	ch.`NAME` channel_name ");
        sql.append(" FROM ");
        sql.append(" 	coll_transform_formula coll, ");
        sql.append(" 	bhsb_clyb_dtu_400v dtu, ");
        sql.append(" 	bhsb_clyb_meter_400v meter, ");
        sql.append(" 	perce_meter_channel ch ");
        sql.append(" 	WHERE coll.DTU_MODEL = dtu.ID AND coll.METER_MODEL = meter.id AND coll.MONITOR_ITEM_ID = ch.ID ");
        sql.append("    and coll.METER_MODEL = :meterId ");

        Map<String, Object> param = new HashMap<>();
        param.put("meterId",meterId);
        return this.queryNativeSql(TransformFormulaVO.class,sql.toString(),param,pageRequest);
    }

    @Override
    public List<Map<String, Object>> listTransformFormula(String meterId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT  ");
        sql.append(" 	cfg.ID,meter.MODELNAME,ch.ADDRESS ");
        sql.append(" FROM ");
        sql.append(" 	coll_transform_formula coll, ");
        sql.append(" 	bhsb_clyb_dtu_400v dtu, ");
        sql.append(" 	bhsb_clyb_meter_400v meter, ");
        sql.append(" 	perce_meter_channel ch, ");
        sql.append(" 	 mea_factor_data_group_cfg cfg ");
        sql.append(" 	WHERE coll.DTU_MODEL = dtu.ID AND coll.METER_MODEL = meter.id AND coll.MONITOR_ITEM_ID = ch.ID and cfg.FACTOR_ID = ch.ID ");
        sql.append("    and coll.METER_MODEL = :meterId ");
        Map<String, Object> param = new HashMap<>();
        param.put("meterId",meterId);
        return this.queryMapNativeSql(sql.toString(),param);
    }
}
