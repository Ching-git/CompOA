package cn.edu.csu.oa.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.csu.oa.dao.DepartmentDao;
import cn.edu.csu.oa.domain.Department;
import cn.edu.csu.oa.service.DepartmentService;

@Repository
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}

	@Override
	public void delete(Long id) {
		departmentDao.delete(id);
	}

	@Override
	public void save(Department model) {
		departmentDao.save(model);
	}

	@Override
	public Department getById(Long id) {
		return departmentDao.getById(id);
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}

	@Override
	public List<Department> findChildren(Long parentId) {
		
		return departmentDao.findChildren(parentId);
	}

	@Override
	public List<Department> findTopList() {
		return departmentDao.findTopList();
	}

}
