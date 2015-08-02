package cn.edu.csu.oa.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.csu.oa.base.DaoSupportImpl;
import cn.edu.csu.oa.domain.Privilege;
import cn.edu.csu.oa.service.PrivilegeService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {

	
	@Override
	public List<Privilege> findTopList() {

		return getSession().createQuery("FROM Privilege p WHERE parent.id IS NULL").list();
	}

}
