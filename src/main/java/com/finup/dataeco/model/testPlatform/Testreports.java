package com.finup.dataeco.model.testPlatform;

import java.util.Date;

public class Testreports {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String reportName;

    private Boolean status;

    private String startAt;

    private Integer testsrun;

    private String successes;

    private String reports;

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

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt == null ? null : startAt.trim();
    }

    public Integer getTestsrun() {
        return testsrun;
    }

    public void setTestsrun(Integer testsrun) {
        this.testsrun = testsrun;
    }

    public String getSuccesses() {
        return successes;
    }

    public void setSuccesses(String successes) {
        this.successes = successes == null ? null : successes.trim();
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports == null ? null : reports.trim();
    }
}