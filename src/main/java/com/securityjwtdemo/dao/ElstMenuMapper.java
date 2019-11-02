package com.securityjwtdemo.dao;

import com.securityjwtdemo.entity.info.ElstMenuInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ElstMenuMapper {
   List<ElstMenuInfo> getAllMenuInfo();
}