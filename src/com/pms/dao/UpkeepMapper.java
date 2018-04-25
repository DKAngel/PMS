package com.pms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pms.pojo.Upkeep;

@Repository("upkeepMapper")
public interface UpkeepMapper {
    int deleteByPrimaryKey(Integer upkeepId);

    int insert(Upkeep record);

    int insertSelective(Upkeep record);

    Upkeep selectByPrimaryKey(Integer upkeepId);

    int updateByPrimaryKeySelective(Upkeep record);

    int updateByPrimaryKey(Upkeep record);
    
    //
    int insertByOwner(Upkeep record);
    
    List<Upkeep> selectAllUpkeep();
    
    List<Upkeep> selectAllUpkeepByOwner(Integer ownerId);
}