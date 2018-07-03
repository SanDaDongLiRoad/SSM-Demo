package com.xulizhi.demo.common;

import java.io.Serializable;
import java.util.Date;

public class BaseDomain implements Serializable {

    private static final long serialVersionUID = -2243226471442315616L;

    private String id;//ID

    private Integer deleted = 0;//是否删除（0:未删除;1:已删除;）

    private String createId;//创建人ID

    private String createName;//创建人名称

    private Date createDate;//创建时间

    private String modifyId;//修改人ID

    private String modifyName;//修改人名称

    private Date modifyDate;//更新时间

    public void setId(String id) {
        this.id = id;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public void setCreaterId(String createrId) {
        this.createId = createrId;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getId() {
        return id;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public String getCreaterId() {
        return createId;
    }

    public String getCreateName() {
        return createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getModifyId() {
        return modifyId;
    }

    public String getModifyName() {
        return modifyName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }
}
