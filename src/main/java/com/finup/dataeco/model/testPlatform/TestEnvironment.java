package com.finup.dataeco.model.testPlatform;

import java.util.Date;

public class TestEnvironment {
    private Long id;

    private Long testModuleId;

    private String environmentName;

    private String serverUrl;

    private String oauthAccessTokenUri;

    private String oauthGrantType;

    private String oauthClientId;

    private String oauthSecret;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestModuleId() {
        return testModuleId;
    }

    public void setTestModuleId(Long testModuleId) {
        this.testModuleId = testModuleId;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName == null ? null : environmentName.trim();
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl == null ? null : serverUrl.trim();
    }

    public String getOauthAccessTokenUri() {
        return oauthAccessTokenUri;
    }

    public void setOauthAccessTokenUri(String oauthAccessTokenUri) {
        this.oauthAccessTokenUri = oauthAccessTokenUri == null ? null : oauthAccessTokenUri.trim();
    }

    public String getOauthGrantType() {
        return oauthGrantType;
    }

    public void setOauthGrantType(String oauthGrantType) {
        this.oauthGrantType = oauthGrantType == null ? null : oauthGrantType.trim();
    }

    public String getOauthClientId() {
        return oauthClientId;
    }

    public void setOauthClientId(String oauthClientId) {
        this.oauthClientId = oauthClientId == null ? null : oauthClientId.trim();
    }

    public String getOauthSecret() {
        return oauthSecret;
    }

    public void setOauthSecret(String oauthSecret) {
        this.oauthSecret = oauthSecret == null ? null : oauthSecret.trim();
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
}