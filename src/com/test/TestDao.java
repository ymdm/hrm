package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.UserDao;
import com.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class TestDao {
	@Autowired
	private UserDao dao;
	
	@Test
	public void testSelect(){
		System.out.println("error");
		User user=dao.selectById(1);
		System.out.println(user);
	}
}
