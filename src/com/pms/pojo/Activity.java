package com.pms.pojo;

import java.util.Date;

public class Activity {
    private Integer activityId;

    private String activityTheme;

    private String activityContent;

    private Date activityPtime;

    private Date activityHtime;

    private Integer activityState;

    private Integer ownersId;

    private String ownersName;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityTheme() {
        return activityTheme;
    }

    public void setActivityTheme(String activityTheme) {
        this.activityTheme = activityTheme == null ? null : activityTheme.trim();
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent == null ? null : activityContent.trim();
    }

    public Date getActivityPtime() {
        return activityPtime;
    }

    public void setActivityPtime(Date activityPtime) {
        this.activityPtime = activityPtime;
    }

    public Date getActivityHtime() {
        return activityHtime;
    }

    public void setActivityHtime(Date activityHtime) {
        this.activityHtime = activityHtime;
    }

    public Integer getActivityState() {
        return activityState;
    }

    public void setActivityState(Integer activityState) {
        this.activityState = activityState;
    }

    public Integer getOwnersId() {
        return ownersId;
    }

    public void setOwnersId(Integer ownersId) {
        this.ownersId = ownersId;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName == null ? null : ownersName.trim();
    }
}