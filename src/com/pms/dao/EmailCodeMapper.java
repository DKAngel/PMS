package com.pms.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pms.pojo.EmailCode;

@Repository("emailCodeMapper")
public interface EmailCodeMapper {
    int deleteByPrimaryKey(Integer codeId);

    int insert(EmailCode record);

    int insertSelective(EmailCode record);

    EmailCode selectByPrimaryKey(Integer codeId);

    int updateByPrimaryKeySelective(EmailCode record);

    int updateByPrimaryKey(EmailCode record);

    //
    int insertByNoId(EmailCode emailCode);
    
    EmailCode selectByEmail(String email);
    
    int updateByEmail(@Param("codeNum")String code, @Param("codeEmail")String email);
}