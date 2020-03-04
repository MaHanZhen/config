package com.mhz.history.config.service;

import com.mhz.history.config.domin.FactorDataGroupCfg;
import com.mhz.history.config.vo.FactorDataGroupCfgVO;
import com.mhz.history.config.vo.LayUiDTreeNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFactorDataGroupCfgService {

    List<LayUiDTreeNode> listAllTreeNode();

    Page<FactorDataGroupCfgVO> findCfgPoint(String parentId, Pageable pageRequest);

    FactorDataGroupCfg addTreeNode(String parentId, String name);

    void updateTreeNode(String id, String name);

    void deleteTreeNode(String id);
}
