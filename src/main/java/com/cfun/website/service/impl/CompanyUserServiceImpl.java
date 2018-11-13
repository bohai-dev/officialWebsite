package com.cfun.website.service.impl;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cfun.website.dao.CompanyUserMapper;
import com.cfun.website.domain.CompanyUser;
import com.cfun.website.service.CompanyUserService;

@Service
public class CompanyUserServiceImpl implements CompanyUserService {
   @Autowired
   CompanyUserMapper userMapper;
	
    @Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
          List<CompanyUser> users=userMapper.selectByUserName(userName);
          if (users==null||users.size()==0) {
        	  throw new UsernameNotFoundException("User"+userName+"not found!");
		  }
		  CompanyUser user=users.get(0);
		  return User.withDefaultPasswordEncoder().username(user.getUserName()).password(user.getPassword()).roles("ADMIN").build(); 
	
	}

}
