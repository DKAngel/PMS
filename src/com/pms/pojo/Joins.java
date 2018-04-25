package com.pms.pojo;

public class Joins {
    private Integer joinsId;

    private String ownersName;

    private String ownersPhone;

    private Integer ownersId;

    private Integer roomId;

    private Integer activityId;

    public Integer getJoinsId() {
        return joinsId;
    }

    public void setJoinsId(Integer joinsId) {
        this.joinsId = joinsId;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName == null ? null : ownersName.trim();
    }

    public String getOwnersPhone() {
        return ownersPhone;
    }

    public void setOwnersPhone(String ownersPhone) {
        this.ownersPhone = ownersPhone == null ? null : ownersPhone.trim();
    }

    public Integer getOwnersId() {
        return ownersId;
    }

    public void setOwnersId(Integer ownersId) {
        this.ownersId = ownersId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
}