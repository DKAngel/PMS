package com.pms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pms.pojo.Complain;

@Repository("complainMapper")
public interface ComplainMapper {
    int deleteByPrimaryKey(Integer complainId);

    int insert(Complain record);

    int insertSelective(Complain record);

    Complain selectByPrimaryKey(Integer complainId);

    int updateByPrimaryKeySelective(Complain record);

    int updateByPrimaryKey(Complain record);
    
    //
    int insertByOwner(Complain record);
    
    List<Complain> selectAllComplain();
    
    List<Complain> selectAllComplainByOwner(Integer ownerId);
    
    int updateByAdmin(Complain record);
    
    int deleteByOwnerId(Integer ownerId);
}