package com.classbook.demo;

public class ChinaUser {
    private String username;
    private String pwd;
    private Address address;

    public ChinaUser() {
    }

    public ChinaUser(String username, String pwd, Address address) {
        this.username = username;
        this.pwd = pwd;
        this.address = address;
    }

    @Override
    public String toString() {
        return "ChinaUser{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address=" + address +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
