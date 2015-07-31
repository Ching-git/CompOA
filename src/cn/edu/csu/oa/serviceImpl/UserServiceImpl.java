package cn.edu.csu.oa.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.csu.oa.base.DaoSupportImpl;
import cn.edu.csu.oa.domain.User;
import cn.edu.csu.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {
 
}
