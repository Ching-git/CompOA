package cn.edu.csu.oa.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.csu.oa.base.DaoSupportImpl;
import cn.edu.csu.oa.domain.Forum;
import cn.edu.csu.oa.service.ForumService;

@Service
@Transactional
@SuppressWarnings("all")
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements
		ForumService {

	/**
	 * 重写save方法，在里面要设置position的值
	 */
	@Override
	public void save(Forum entity) {
		//保存到数据库
		getSession().save(entity);
		
		//设置position的值(使用id的值)
		entity.setPosition(entity.getId().intValue());
		
	}

	/**
	 * 重写方法，在查询时要按照position的值排序
	 */
	@Override
	public List<Forum> findAll() {
		return getSession().createQuery("FROM Forum f ORDER BY f.position")
				.list();
	}

	@Override
	public void moveUp(Long id) {
		// 1，找出要交换位置号的Forum对象
		Forum forum = getById(id);
		Forum other = (Forum) getSession()
				.createQuery(
						"FROM Forum f WHERE f.position < ? ORDER BY f.position DESC")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)// 从结果列表中的哪个索引开始取数据
				.setMaxResults(1)// 最多取几条数据
				.uniqueResult();

		// 最上面的不能上移
		if (other == null) {
			return;
		}

		// 2，交换position的值
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);

		// 3，保存到数据库
		getSession().save(forum);
		getSession().save(other);

	}

	@Override
	public void moveDown(Long id) {
		// 1，找出要交换位置号的Forum对象
		Forum forum = getById(id);
		Forum other = (Forum) getSession()
				.createQuery(
						"FROM Forum f WHERE f.position > ? ORDER BY f.position ASC")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)// 从结果列表中的哪个索引开始取数据
				.setMaxResults(1)// 最多取几条数据
				.uniqueResult();

		// 最下面的不能下移
		if (other == null) {
			return;
		}

		// 2，交换position的值
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);

		// 3，保存到数据库
		getSession().save(forum);
		getSession().save(other);
	}

}
