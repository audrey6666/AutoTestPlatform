package com.finup.dataeco.model.testPlatform;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Moduleinfo {
	private Integer id;

	private Date createTime;

	private Date updateTime;

	private String moduleName;

	private String testUser;

	private String simpleDesc;

	private String otherDesc;

	private Integer belongProjectId;

	private Projectinfo projectinfo;
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date liftingTime;

	public Date getLiftingTime() {
		return liftingTime;
	}

	public void setLiftingTime(Date liftingTime) {
		this.liftingTime = liftingTime;
	}

	public Projectinfo getProjectinfo() {
		return projectinfo;
	}

	public void setProjectinfo(Projectinfo projectinfo) {
		this.projectinfo = projectinfo;
	}

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

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName == null ? null : moduleName.trim();
	}

	public String getTestUser() {
		return testUser;
	}

	public void setTestUser(String testUser) {
		this.testUser = testUser == null ? null : testUser.trim();
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

	public Integer getBelongProjectId() {
		return belongProjectId;
	}

	public void setBelongProjectId(Integer belongProjectId) {
		this.belongProjectId = belongProjectId;
	}
}