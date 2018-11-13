package com.cfun.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfun.website.bean.ResponseBean;
import com.cfun.website.dao.ContactUsMapper;
import com.cfun.website.domain.CompanyUser;
import com.cfun.website.domain.ContactUs;
import com.cfun.website.service.ContactUsService;

@Service
public class ContactUsServiceImpl implements ContactUsService {
    @Autowired
    ContactUsMapper contactUsMapper;
  
    
    @Override
    @Transactional
	public ResponseBean<Integer> insert(ContactUs contactUs) {
    	ResponseBean<Integer> responseBean=new ResponseBean<Integer>();

    	contactUs.setId(contactUsMapper.generateId());
		responseBean.setData(contactUsMapper.insertSelective(contactUs));
		 
		return responseBean;
		
	}
	@Override
	public ResponseBean<List<ContactUs>> selectAll() {
		
		return new ResponseBean<List<ContactUs>>(contactUsMapper.selectAll());
	}
	
	@Override	
   public ResponseBean<List<ContactUs>> selectByUser() {
       //获取当前用户		
	   UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			              .getAuthentication().getPrincipal();
	   if (userDetails==null) {
		throw new UsernameNotFoundException("当前用户为空");
	   }else {
		  // Integer userId=user.getId();
		   String UserName=userDetails.getUsername();
		   List<ContactUs> list=contactUsMapper.selectByUerName(UserName);
		   return new ResponseBean<List<ContactUs>>(list);
	   }
	  
	   
   }

    @Override
	public ResponseBean<Integer> update(ContactUs contactUs) {
		
		return new ResponseBean<Integer>(contactUsMapper.updateByPrimaryKeySelective(contactUs));
	}
	
	@Override
	public ResponseBean<Integer> signRead(List<Integer> idList) {
		int result=contactUsMapper.updateReadStatus(idList);
		return new ResponseBean<Integer>(result);
	}

}
