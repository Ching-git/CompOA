package cn.edu.csu.oa.service;

import cn.edu.csu.oa.base.DaoSupport;
import cn.edu.csu.oa.domain.User;

public interface UserService extends DaoSupport<User>{

	/**
	 * 验证用户名和密码
	 * @param loginName
	 * @param password 明文密码
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);

}
