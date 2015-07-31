package cn.edu.csu.oa.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.csu.oa.base.DaoSupportImpl;
import cn.edu.csu.oa.domain.Department;
import cn.edu.csu.oa.service.DepartmentService;

@Service
@SuppressWarnings("all")
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {

	// @Resource
	// private DepartmentDao departmentDao;
	//
	// @Override
	// public List<Department> findAll() {
	//
	// return departmentDao.findAll();
	// }
	//
	// @Override
	// public void delete(Long id) {
	// departmentDao.delete(id);
	// }
	//
	// @Override
	// public void save(Department model) {
	// departmentDao.save(model);
	// }
	//
	// @Override
	// public Department getById(Long id) {
	// return departmentDao.getById(id);
	// }
	//
	// @Override
	// public void update(Department department) {
	// departmentDao.update(department);
	// }

	public List<Department> findChildren(Long parentId) {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}

	public List<Department> findTopList() {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent IS NULL")//
				.list();
	}

}
