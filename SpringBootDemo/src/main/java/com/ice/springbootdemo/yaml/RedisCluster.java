package com.ice.springbootdemo.yaml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * yaml 配置
 */
@Component
@ConfigurationProperties("redis")
public class RedisCluster {
    private Integer port;
    private List<String> hosts;
    private List<Redis> redisList;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public List<Redis> getRedisList() {
        return redisList;
    }

    public void setRedisList(List<Redis> redisList) {
        this.redisList = redisList;
    }

    @Override
    public String toString() {
        return "RedisCluster{" +
                "port=" + port +
                ", hosts=" + hosts +
                ", redisList=" + redisList +
                '}';
    }
}
