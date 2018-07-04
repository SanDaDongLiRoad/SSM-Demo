package com.xulizhi.demo.domain;

import com.xulizhi.demo.common.BaseDomain;

public class User extends BaseDomain {

    private String name;//用户名

    private String password;//密码

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
