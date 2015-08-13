package cn.edu.csu.oa.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.csu.oa.base.DaoSupportImpl;
import cn.edu.csu.oa.domain.Forum;
import cn.edu.csu.oa.service.ForumService;

@Service
@Transactional
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements ForumService{

	@Override
	public void moveDown(Long id) {
		
	}

	@Override
	public void moveUp(Long id) {
		
	}

}
