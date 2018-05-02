package com.pms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pms.pojo.Activity;

@Repository("activityMapper")
public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
    
    //
    int insertByOwner(Activity record);
    
    List<Activity> selectAllActivityBy1();
    
    List<Activity> selectAllActivityByOwnerId(Integer ownerId);
    
    List<Activity> selectAllActivityBy0();
    
    List<Activity> selectAllActivity();
    
    int updateStateById(Activity record);
    
    int deleteByOwnerId(Integer ownerId);
}