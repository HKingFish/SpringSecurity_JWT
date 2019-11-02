package com.securityjwtdemo.dao;

import com.securityjwtdemo.entity.ElstRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ElstRoleMapper {
    List<ElstRole> selectRoleByUser(String userId);
    List<ElstRole> selectRoleByMenu(String menuId);
}