package com.finup.dataeco.model.testPlatform;

import java.util.Date;

public class Webhookinfo {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String webhookName;

    private String jobName;

    private String token;

    private Integer belongProjectId;

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

    public String getWebhookName() {
        return webhookName;
    }

    public void setWebhookName(String webhookName) {
        this.webhookName = webhookName == null ? null : webhookName.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getBelongProjectId() {
        return belongProjectId;
    }

    public void setBelongProjectId(Integer belongProjectId) {
        this.belongProjectId = belongProjectId;
    }
}