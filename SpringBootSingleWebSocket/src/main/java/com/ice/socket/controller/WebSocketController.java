package com.ice.socket.controller;

import com.ice.socket.bean.Chat;
import com.ice.socket.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * 2.WebSocket 实现在线群聊
 */
@Controller
public class WebSocketController {
    // 使消息发送更加灵活
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/greeting")
    public void simpMessagingTemplate(Message message) {
        simpMessagingTemplate.convertAndSend("/topic/greetings", message);
    }

    // Principal 保存用户信息
    @MessageMapping("/singleChat")
    public void singleChat(Principal principal, Chat chat) {
        chat.setFrom(principal.getName());
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/singleChat", chat);
    }
}
