package cn.edu.csu.oa.service;

import java.util.List;

import cn.edu.csu.oa.base.DaoSupport;
import cn.edu.csu.oa.domain.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege>{

	List<Privilege> findTopList();
}
