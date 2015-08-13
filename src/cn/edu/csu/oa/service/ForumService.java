package cn.edu.csu.oa.service;

import cn.edu.csu.oa.base.DaoSupport;
import cn.edu.csu.oa.domain.Forum;

public interface ForumService extends DaoSupport<Forum> {

	//下移，最下面的不能再下移， id为当前要移动的板块id
	void moveDown(Long id);

	//上移，最上面的不能再上移，id为当前要移动的板块id
	void moveUp(Long id);

}
