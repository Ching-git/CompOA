package cn.edu.csu.oa.service;

import java.util.List;

import cn.edu.csu.oa.base.DaoSupport;
import cn.edu.csu.oa.domain.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege> {

	/**
	 * 查询所有顶级的权限列表
	 * 
	 * @return
	 */
	List<Privilege> findTopList();

	/**
	 * 查询所有权限的URL集合（不包含null和重复的值）
	 * 
	 * @return
	 */
	List<String> getAllPrivilegeUrls();
}
