package cn.edu.csu.oa.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.csu.oa.dao.RoleDao;
import cn.edu.csu.oa.domain.Role;
import cn.edu.csu.oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		roleDao.delete(id);
	}

	@Override
	public void save(Role model) {
		// TODO Auto-generated method stub
		roleDao.save(model);
	}

	@Override
	public Role getById(Long id) {
		// TODO Auto-generated method stub
		return roleDao.getById(id);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleDao.update(role);
	}

}
