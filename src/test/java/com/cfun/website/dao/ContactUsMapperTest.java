package com.cfun.website.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ContactUsMapperTest {
  @Autowired
  ContactUsMapper contactUsMapper;
  
  @Test
  public void testUpdateRead() {
	  List<Integer> list=new ArrayList<>();
	  list.add(1);
	  list.add(2);
	  int result=contactUsMapper.updateReadStatus(list);
	  System.out.println(result);
	  
  }

  @Test
    public void generateIdTest(){
      int id=contactUsMapper.generateId();
      System.out.println("id="+id);

  }
  
	
	
}
