package cn.edu.csu.oa.basedao;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.edu.csu.oa.dao.RoleDao;
import cn.edu.csu.oa.dao.UserDao;
import cn.edu.csu.oa.daoImpl.RoleDaoImpl;
import cn.edu.csu.oa.daoImpl.UserDaoImpl;
import cn.edu.csu.oa.domain.Role;
import cn.edu.csu.oa.domain.User;

public class BaseDaoTest {

	@Test
	public void testGetById() {
		UserDao userDao = new UserDaoImpl();
		RoleDao roleDao = new RoleDaoImpl();
		
		/*User user = userDao.getById(1L);
		Role role = roleDao.getById(1L);*/
	}

}
