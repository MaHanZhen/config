package com.mhz.history.config.dao;

import com.mhz.history.config.domin.FactorDataGroupCfg;
import com.mhz.history.config.vo.FactorDataGroupCfgVO;
import com.mhz.history.config.vo.LayUiDTreeNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFactorDataGroupCfNativeSqlDao {
    List<LayUiDTreeNode> listAllTreeNode();

    Page<FactorDataGroupCfgVO> findCfgPoint(String parentId, Pageable pageRequest);

    String generateId();

    String generateLayerOrder(String baseLayerOrder,Integer index);
}
