package com.ice.socket.controller;

import com.ice.socket.bean.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * 2.WebSocket 实现在线群聊
 */
@Controller
public class WebSocketController {
    @MessageMapping("/greeting")
    // 转发 topic 消息
    @SendTo("/topic/greetings")
    public Message greeting(Message message) {
        return message;
    }
}
