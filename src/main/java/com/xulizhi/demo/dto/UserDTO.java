package com.xulizhi.demo.dto;

import com.xulizhi.demo.common.BaseDTO;

public class UserDTO extends BaseDTO {

    private String name;//用户名

    private String createName;//创建人

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }
}
