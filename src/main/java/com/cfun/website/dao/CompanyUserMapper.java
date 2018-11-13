package com.cfun.website.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cfun.website.domain.CompanyUser;


@Mapper
public interface CompanyUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyUser record);

    int insertSelective(CompanyUser record);

    CompanyUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyUser record);

    int updateByPrimaryKey(CompanyUser record);
    
    @Select("select * from company_user where user_name=#{userName}")
    List<CompanyUser> selectByUserName(@Param("userName") String userName);
}