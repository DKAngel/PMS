package com.pms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pms.pojo.Pay;

@Repository("payMapper")
public interface PayMapper {
    int deleteByPrimaryKey(Integer payId);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Integer payId);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);
    
    //
    int insertByOwner(Pay record);
    
    Pay selectMaxPayByOwner(Integer ownerId);
    
    List<Pay> selectAllByOwnerId(Integer ownerId);
}