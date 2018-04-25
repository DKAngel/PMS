package com.pms.dao;

import org.springframework.stereotype.Repository;

import com.pms.pojo.Verify;

@Repository("verifyMapper")
public interface VerifyMapper {
    int deleteByPrimaryKey(Integer verifyId);

    int insert(Verify record);

    int insertSelective(Verify record);

    Verify selectByPrimaryKey(Integer verifyId);

    int updateByPrimaryKeySelective(Verify record);

    int updateByPrimaryKey(Verify record);
    
    //
    Verify selectByActivityId(Integer activityId);
}