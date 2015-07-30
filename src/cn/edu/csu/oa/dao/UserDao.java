package cn.edu.csu.oa.dao;

import cn.edu.csu.oa.basedao.BaseDao;
import cn.edu.csu.oa.domain.User;

public interface UserDao extends BaseDao<User>{

	User getByNameAndPassword();
}
