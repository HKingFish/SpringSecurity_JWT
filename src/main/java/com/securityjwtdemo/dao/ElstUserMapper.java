package com.securityjwtdemo.dao;

import com.securityjwtdemo.entity.ElstUser;
import com.securityjwtdemo.entity.security.JwtUserDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ElstUserMapper {

    JwtUserDetails loadUserByUsername(String userId);
    
    int insert(ElstUser record);

    int insertSelective(ElstUser record);

   
}