package com.mhz.history.config.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LayUiDTree {

    Map<String,Object> status = new HashMap<>();
    {
        status.put("code",200);
        status.put("message","操作成功");
    }

    private List<LayUiDTreeNode> data;

    public Map<String, Object> getStatus() {
        return status;
    }

    public void setStatus(Map<String, Object> status) {
        this.status = status;
    }

    public List<LayUiDTreeNode> getData() {
        return data;
    }

    public void setData(List<LayUiDTreeNode> data) {
        this.data = data;
    }
}
