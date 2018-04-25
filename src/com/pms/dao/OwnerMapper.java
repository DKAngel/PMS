package com.pms.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pms.pojo.Owner;

@Repository("ownerMapper")
public interface OwnerMapper {
    int deleteByPrimaryKey(Integer ownersId);

    int insert(Owner record);

    int insertSelective(Owner record);

    Owner selectByPrimaryKey(Integer ownersId);

    int updateByPrimaryKeySelective(Owner record);

    int updateByPrimaryKey(Owner record);
    
    //
    Owner selectByEmail(String ownersEmail);
    
    int insertByRegister(Owner owner);
    
    int updatePasswordByEmail(@Param("ownersPassword")String password, 
    						  @Param("ownersEmail")String email);
    
    int updateInfoByEmail(@Param("ownersName")String password,
    					  @Param("ownersSex")String sex,
    					  @Param("ownersPhone")String phone,
    					  @Param("ownersEmail")String email);
    
    int updateAccountByEmail(@Param("ownersNewEmail")String newEmail,
						     @Param("ownersPassword")String password,
						     @Param("ownersOldEmail")String oldEmail);
    
}