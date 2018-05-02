package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.RoomMapper;
import com.pms.pojo.Room;
import com.pms.service.RoomService;

@Service("roomService")
public class RoomServiceImpl implements RoomService{
	
	@Resource(name = "roomMapper")
	private RoomMapper roomMapper;
	
	@Override
	public List<Room> getAllRoom(){
		return roomMapper.selectAllRoom();
	}
	
	public Room getByPrimaryKey(Integer roomId){
		return roomMapper.selectByPrimaryKey(roomId);
	}
	
	public int updateByRegister(Integer ownerId, Integer roomId){
		return roomMapper.updateByRegister(ownerId, roomId);
	}
	
	public int updateByPay(Integer roomId){
		return roomMapper.updateByPay(roomId);
	}
	
	public List<Room> getByOwnerIsNotNull(){
		return roomMapper.selectByOwnerIsNotNull();
	}
	
	public List<Room> getAllRoomWithOwner(){
		return roomMapper.selectAllRoomWithOwner();
	}
	
	public Room getAllRoomWithOwnerAndPay(Integer roomId){
		return roomMapper.selectAllRoomWithOwnerAndPay(roomId);
	}
	
	public Room getRoomAndOwnerById(Integer roomId){
		return roomMapper.selectRoomAndOwnerById(roomId);
	}
	
	public Room getByRoomId(Integer roomId){
		return roomMapper.selectByRoomId(roomId);
	}
	
	public int updateRoomOwnerByOwnerId(Integer ownerId){
		return roomMapper.updateRoomOwnerByOwnerId(ownerId);
	}
}
