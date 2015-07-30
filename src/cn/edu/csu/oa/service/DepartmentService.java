package cn.edu.csu.oa.service;

import java.util.List;

import cn.edu.csu.oa.domain.Department;

public interface DepartmentService {

	List<Department> findAll();

	void delete(Long id);

	void save(Department model);

	Department getById(Long id);

	void update(Department department);

	List<Department> findChildren(Long parentId);

	List<Department> findTopList();

}
