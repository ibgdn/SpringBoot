package com.ice.global;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * 11.@ControllerAdvice 预设全局数据
 */
@ControllerAdvice
public class GlobalData {
    @ModelAttribute("info")
    public Map<String, String> setGlobalData() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "global");
        map.put("url","globalData");
        return map;
    }
}
