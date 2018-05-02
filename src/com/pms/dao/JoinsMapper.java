package com.pms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pms.pojo.Joins;

@Repository("joinsMapper")
public interface JoinsMapper {
    int deleteByPrimaryKey(Integer joinsId);

    int insert(Joins record);

    int insertSelective(Joins record);

    Joins selectByPrimaryKey(Integer joinsId);

    int updateByPrimaryKeySelective(Joins record);

    int updateByPrimaryKey(Joins record);
    
    //
    int insertByOwner(Joins record);
    
    List<Joins> selectByActivityId(Integer id);
    
    Joins selectByActivityIdAndOwnerId(@Param("activityId")Integer activityId, @Param("ownersId")Integer ownersId);

    int deleteByActivityId(Integer activityId);
    
    int deleteByOwnerId(Integer ownerId);
}