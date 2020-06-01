package com.ice.socket.bean;

/**
 * 2.WebSocket 实现在线群聊
 * <p>
 * 消息实体类
 */
public class Message {
    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
