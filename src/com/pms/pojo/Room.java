package com.pms.pojo;

public class Room {
    private Integer roomId;

    private Integer roomSize;

    private String roomPay;

    private Integer roomOwner;

    private Owner owner;
    
    private Pay pay;
    
	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomPay() {
        return roomPay;
    }

    public void setRoomPay(String roomPay) {
        this.roomPay = roomPay == null ? null : roomPay.trim();
    }

    public Integer getRoomOwner() {
        return roomOwner;
    }

    public void setRoomOwner(Integer roomOwner) {
        this.roomOwner = roomOwner;
    }
}