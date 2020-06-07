package com.ice.actuator.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.Info 端点
 */
@Component
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> info = new HashMap<>();
        info.put("email", "info");
        builder.withDetail("author", info);
    }
}
