package com.pms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pms.pojo.Suggest;

@Repository("suggestMapper")
public interface SuggestMapper {
    int deleteByPrimaryKey(Integer suggestId);

    int insert(Suggest record);

    int insertSelective(Suggest record);

    Suggest selectByPrimaryKey(Integer suggestId);

    int updateByPrimaryKeySelective(Suggest record);

    int updateByPrimaryKey(Suggest record);
    
    //
    int insertByOwner(Suggest record);
    
    List<Suggest> selectAllSuggest();
    
    List<Suggest> selectAllSuggestByOwner(Integer ownerId);
    
    int updateByAdmin(Suggest record);
}