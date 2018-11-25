package portal.backendproject;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import portal.backendproject.dao.UserDao;
import portal.backendproject.daoimpl.UserDaoService;
import portal.backendproject.model.User;
import portal.backendproject.Persistanceconfig;

@SpringJUnitConfig(classes = { Persistanceconfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

	@Autowired
	private UserDao userDao;

	@Autowired
	private User user;

	@Before
	public void setup() {

		user.setName("Raghuveer");
		user.setEmail("Kalluragureddy@gmail.com");
		user.setMobile("8978513016");
		user.setRole("Admin");
		user.setPassword("raghu123");
	}

	@org.junit.Test
	public void userRegisterTest() {

		assertEquals("user register  Failed", true, userDao.registerUser(user));
	}

	@After
	public void deleteUsertest() {
		assertEquals("user deletion  Failed", true, userDao.deleteUser(user));
	}

}
