package cn.edu.csu.oa.dao;

import java.util.List;

import cn.edu.csu.oa.basedao.BaseDao;
import cn.edu.csu.oa.domain.Department;

public interface DepartmentDao extends BaseDao<Department>{

	List<Department> findChildren(Long parentId);

	List<Department> findTopList();

}
