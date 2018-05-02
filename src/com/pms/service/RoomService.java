package com.pms.service;

import java.util.List;

import com.pms.pojo.Room;

public interface RoomService {
	public Room getByPrimaryKey(Integer roomId);
	public List<Room> getAllRoom();
	public int updateByRegister(Integer ownerId, Integer roomId);
	public int updateByPay(Integer roomId);
	public List<Room> getByOwnerIsNotNull();
	public List<Room> getAllRoomWithOwner();
	public Room getAllRoomWithOwnerAndPay(Integer roomId);
	public Room getRoomAndOwnerById(Integer roomId);
	public Room getByRoomId(Integer roomId);
	public int updateRoomOwnerByOwnerId(Integer ownerId);
}
