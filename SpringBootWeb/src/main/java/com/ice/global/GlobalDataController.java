package com.ice.global;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * 11.@ControllerAdvice 预设全局数据
 */
@RestController
public class GlobalDataController {
    @GetMapping("/getGlobalData")
    public String getGlobalData(Model model) {
        Map<String, Object> map = model.asMap();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + ": " + map.get(key));
        }
        return "GlobalData";
    }
}
