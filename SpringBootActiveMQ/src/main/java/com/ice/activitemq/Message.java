package com.ice.activitemq;

import java.io.Serializable;
import java.util.Date;

/**
 * 3.Spring Boot 整合 ActiveMQ
 */
public class Message implements Serializable {
    private String content;
    private Date sendDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", sendDate=" + sendDate +
                '}';
    }
}
