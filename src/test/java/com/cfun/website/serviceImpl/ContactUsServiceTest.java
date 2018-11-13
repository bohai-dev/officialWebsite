package com.cfun.website.serviceImpl;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cfun.website.bean.ResponseBean;
import com.cfun.website.domain.ContactUs;
import com.cfun.website.service.ContactUsService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ContactUsServiceTest {
  @Autowired
  ContactUsService contactUsService;
  
  
  //测试service
  @Test
  public void testInsert() {
	  ContactUs contactUs=new ContactUs();
	  contactUs.setCompanyId(6);
	  contactUs.setContactUser("测试用户10");
	  contactUs.setContactPhone("17621503621");
	  contactUs.setQqWechat("1746569077");
	  contactUs.setContactDeatil("怎么使用该产品？");
	 
	  
	  ResponseBean<Integer> responseBean=contactUsService.insert(contactUs);
	 
  }
	
}
