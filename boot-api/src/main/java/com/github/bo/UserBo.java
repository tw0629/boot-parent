package com.github.bo;


import java.io.Serializable;

/**
 * Created by chenqimiao on 2017/4/27.
 */
public class UserBo implements Serializable{

    private String username;

    private Integer age;

    private String city;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
