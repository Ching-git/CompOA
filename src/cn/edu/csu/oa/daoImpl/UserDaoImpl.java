package cn.edu.csu.oa.daoImpl;

import org.springframework.stereotype.Repository;

import cn.edu.csu.oa.basedao.BaseDaoImpl;
import cn.edu.csu.oa.dao.UserDao;
import cn.edu.csu.oa.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/*public UserDaoImpl(Class<User> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}*/

	@Override
	public User getByNameAndPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
