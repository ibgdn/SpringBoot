package com.ice.springbootdemo.freemarker.bean;

/**
 * freemarker 视图实体类
 */
public class User {
    private long id;
    private String userName;
    private String userAddress;
    private int gender;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", gender=" + gender +
                '}';
    }
}
