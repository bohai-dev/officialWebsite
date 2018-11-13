package com.cfun.website.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cfun.website.domain.CompanyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cfun.website.bean.ResponseBean;
import com.cfun.website.domain.ContactUs;
import com.cfun.website.service.ContactUsService;

@RestController
@RequestMapping("/contactUs")
@CrossOrigin
public class ContactUsController {
 @Autowired
 ContactUsService contactUsService;

 
 @RequestMapping("/insert")
 public ResponseBean<Integer> insert(@RequestBody ContactUs contactUs){
	 contactUs.setReadStatus(0);
	 contactUs.setCreatedTime(new Date());
	 return contactUsService.insert(contactUs);
 }
 
 @RequestMapping("/selectAll")
 public ResponseBean<List<ContactUs>> selectAll(){
	 return contactUsService.selectAll();
 }
 @RequestMapping("/update")
 public ResponseBean<Integer> update(@RequestBody ContactUs contactUs){
	 return contactUsService.update(contactUs);
 }
 
 //查询当前用户的数据
 @RequestMapping("/selectByUser")
 public ResponseBean<List<ContactUs>> selectByUser(){
	 
	 return contactUsService.selectByUser();
 }
 
 /**
  * 标为已读
  * @param list : 记录id的List 数组
  * @return 更新成功的数量
  */
 @RequestMapping("/signRead")
 public ResponseBean<Integer> updateReadStatus(@RequestParam("idList") List<Integer> list){
	 
	 return contactUsService.signRead(list);
 }


 @RequestMapping("/findOne")
 public CompanyUser findOne(){
     CompanyUser user=new CompanyUser();
     user.setUserName("caoxingyu");
     user.setPassword("123456");
     user.setCreatedTime(new Date());
     user.setUpdatedTime(new Date());
     user.setRemark("remark");
     return user;
 }

    @RequestMapping("/findList")
    public List<CompanyUser> findList(){
        List<CompanyUser> list=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            CompanyUser user=new CompanyUser();
            user.setUserName("caoxingyu");
            user.setPassword("123456");
            user.setCreatedTime(new Date());
            user.setUpdatedTime(new Date());
            user.setRemark("remark");
            list.add(user);
        }

        return list;
    }





}
