package com.finup.dataeco.model.testPlatform;

import java.util.Date;

public class Testcaseinfo {
	private Integer id;

	private Date createTime;

	private Date updateTime;

	private Integer type;

	private String name;

	private String belongProject;

	private String include;

	private String author;

	private Integer belongModuleId;

	private String level;

	private String request;

	private String interfaceUrl;

	private Moduleinfo moduleinfo;

	private Projectinfo projectinfo;

	public Moduleinfo getModuleinfo() {
		return moduleinfo;
	}

	public void setModuleinfo(Moduleinfo moduleinfo) {
		this.moduleinfo = moduleinfo;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getBelongProject() {
		return belongProject;
	}

	public void setBelongProject(String belongProject) {
		this.belongProject = belongProject == null ? null : belongProject.trim();
	}

	public String getInclude() {
		return include;
	}

	public void setInclude(String include) {
		this.include = include == null ? null : include.trim();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public Integer getBelongModuleId() {
		return belongModuleId;
	}

	public void setBelongModuleId(Integer belongModuleId) {
		this.belongModuleId = belongModuleId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level == null ? null : level.trim();
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request == null ? null : request.trim();
	}

	public String getInterfaceUrl() {
		return interfaceUrl;
	}

	public void setInterfaceUrl(String interfaceUrl) {
		this.interfaceUrl = interfaceUrl == null ? null : interfaceUrl.trim();
	}
}