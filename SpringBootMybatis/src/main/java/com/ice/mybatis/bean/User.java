package com.ice.mybatis.bean;

/**
 * 4.Spring Boot 整合 MyBatis
 */
public class User {
    private Integer id;
    private String userName;
    private String address;

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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
