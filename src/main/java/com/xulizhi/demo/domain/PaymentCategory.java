package com.xulizhi.demo.domain;

import com.xulizhi.demo.common.BaseDomain;

/**
 * @author lenovo
 */
public class PaymentCategory extends BaseDomain{

    /**
     * 支付类别名称
     */
    private String name;

    /**
     * 支付类别图标地址
     */
    private String headUrl;

    /**
     * 支付类别页面地址
     */
    private String url;

    /**
     * 备注（描述支付类别）
     */
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
