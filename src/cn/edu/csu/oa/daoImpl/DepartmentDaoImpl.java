package cn.edu.csu.oa.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.csu.oa.basedao.BaseDaoImpl;
import cn.edu.csu.oa.dao.DepartmentDao;
import cn.edu.csu.oa.domain.Department;

@Repository
@SuppressWarnings("unchecked")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

	@Override
	public List<Department> findChildren(Long parentId) {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent.id=?")//
				.setParameter(0, parentId).list();
	}

	@Override
	public List<Department> findTopList() {
		return getSession().createQuery(//
				"FROM Department d WHERE d.parent IS NULL").list();
	}

}
