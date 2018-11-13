package com.cfun.website.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cfun.website.domain.ContactUs;

@Mapper
public interface ContactUsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContactUs record);

    int insertSelective(ContactUs record);

    ContactUs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContactUs record);

    int updateByPrimaryKey(ContactUs record);
    
    @Select("select * from contact_us")
    List<ContactUs> selectAll();
    
    @Select("select * from contact_us where company_id=(select id from company_user where user_name=#{userName}) order by  created_time desc")
    List<ContactUs> selectByUerName(@Param("userName") String userName);
    
    int updateReadStatus(List<Integer> idList);

    @Select(value="select CONTACT_US_ID_SEQ.NEXTVAL from dual")
    int generateId();
    
}