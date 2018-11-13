package com.cfun.website.service;

import java.util.List;

import com.cfun.website.bean.ResponseBean;
import com.cfun.website.domain.ContactUs;

public interface ContactUsService {
	
	
   ResponseBean<Integer> insert(ContactUs contactUs);
   ResponseBean<List<ContactUs>> selectAll();
   ResponseBean<Integer> update(ContactUs contactUs);
   ResponseBean<List<ContactUs>> selectByUser();
   
   //批量标为已读
   ResponseBean<Integer> signRead(List<Integer> idList);

}
