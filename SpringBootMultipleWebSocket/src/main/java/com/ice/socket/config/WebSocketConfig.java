package com.ice.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 2.WebSocket 实现在线群聊
 */
@Configuration
// 开启消息代理
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 设置消息代理前缀，如果带有前缀，就会发给消息代理
        registry.enableSimpleBroker("/topic");
        // app 开头，消息被代理处理
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册连接点
        registry.addEndpoint("/webSocketChart").withSockJS();
    }
}
