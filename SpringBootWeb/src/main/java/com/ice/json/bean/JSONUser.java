package com.ice.json.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 1.Spring Boot默认的 JSON 解析方案
 */
public class JSONUser {
    private Integer id;
    private String userName;
    private String address;

    // 单独配置日期展示格式，会覆盖全局配置
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "JSONUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
