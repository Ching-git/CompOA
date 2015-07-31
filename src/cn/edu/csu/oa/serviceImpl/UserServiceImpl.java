package cn.edu.csu.oa.serviceImpl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.csu.oa.base.DaoSupportImpl;
import cn.edu.csu.oa.domain.User;
import cn.edu.csu.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

	@Override
	public void save(User user) {
		//默认密码是1234
		String md5 = DigestUtils.md5Hex("1234");
		user.setPassword(md5);
		
		//保存到数据库
		getSession().save(user);
	}
 
}
