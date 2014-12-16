package com.elwin013.arweb.dao.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.elwin013.arweb.dao.UserDao;
import com.elwin013.arweb.dao.model.User;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/dao-context.xml"})
public class UserDaoImplTest extends
		AbstractTransactionalJUnit4SpringContextTests {
	private static UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDAO) {
		userDao = userDAO;
	}
	
	public static User createUserObject() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("test");
		user.setName("Jan");
		user.setSurname("Kowalski");
		return user;
	}
	
	@Rollback(false)
	@Test
	public void testUserCRUD() {
//		User user= createUserObject();
//		
//		userDao.save(user);
//		
//		int index=user.getIdUser();
//		
//		assertEquals(user,userDao.get(index));
//		
//		user.setUsername("Mark");
//		user.setPassword("password123");
//		
//		userDao.update(user);
//		
//		assertEquals(user,userDao.get(index));
//		
//		userDao.delete(user);
//		
//		assertNull(userDao.get(user.getIdUser()));
//		
	}
}
