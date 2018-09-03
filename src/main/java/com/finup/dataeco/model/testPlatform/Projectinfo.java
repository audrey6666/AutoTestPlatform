package com.finup.dataeco.model.testPlatform;

import java.util.Date;

public class Projectinfo {
	private Integer id;

	private Date createTime;

	private Date updateTime;

	private String projectName;

	private String responsibleName;

	private String testUser;

	private String devUser;

	private String publishApp;

	private String simpleDesc;

	private String otherDesc;

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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName == null ? null : responsibleName.trim();
	}

	public String getTestUser() {
		return testUser;
	}

	public void setTestUser(String testUser) {
		this.testUser = testUser == null ? null : testUser.trim();
	}

	public String getDevUser() {
		return devUser;
	}

	public void setDevUser(String devUser) {
		this.devUser = devUser == null ? null : devUser.trim();
	}

	public String getPublishApp() {
		return publishApp;
	}

	public void setPublishApp(String publishApp) {
		this.publishApp = publishApp == null ? null : publishApp.trim();
	}

	public String getSimpleDesc() {
		return simpleDesc;
	}

	public void setSimpleDesc(String simpleDesc) {
		this.simpleDesc = simpleDesc == null ? null : simpleDesc.trim();
	}

	public String getOtherDesc() {
		return otherDesc;
	}

	public void setOtherDesc(String otherDesc) {
		this.otherDesc = otherDesc == null ? null : otherDesc.trim();
	}
}