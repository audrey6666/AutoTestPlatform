package com.finup.dataeco.model.testPlatform;

import java.util.Date;

public class Testsuite {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String suiteName;

    private Integer belongProjectId;

    private String include;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName == null ? null : suiteName.trim();
    }

    public Integer getBelongProjectId() {
        return belongProjectId;
    }

    public void setBelongProjectId(Integer belongProjectId) {
        this.belongProjectId = belongProjectId;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include == null ? null : include.trim();
    }
}