package cn.edu.csu.oa.service;

import java.util.List;

import cn.edu.csu.oa.domain.Role;

public interface RoleService {

	/**
	 * 列出所有的岗位信息
	 * @return
	 */
	List<Role> findAll();

	/**
	 * 删除岗位信息
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 保存实体
	 * @param model
	 */
	void save(Role model);

	/**
	 * 根据Id获取实体
	 * @param id
	 * @return
	 */
	Role getById(Long id);
	
	/**
	 * 更新实体
	 * @param role
	 */
	void update(Role role);

}
