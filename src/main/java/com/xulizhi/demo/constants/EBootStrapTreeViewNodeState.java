package com.xulizhi.demo.constants;

public enum EBootStrapTreeViewNodeState {

    Checked("已勾选", "{checked:true}"),UnChecked("未勾选", "{checked:false}");

    private String name;
    private String value;

    EBootStrapTreeViewNodeState(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
