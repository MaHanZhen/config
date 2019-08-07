package com.mhz.history.config.util;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

public class LayUiUtil {

    public static Map<String,Object> transformLayUiTableData(Page page){
        Map<String,Object> result = new HashMap<>();
        result.put("data", page.getContent());
        result.put("count", page.getTotalElements());
        result.put("code", 0);
        result.put("msg", "");
        return result;
    }
}
