package cn.edu.csu.oa.basedao;

import java.util.List;

public interface BaseDao<T> {

	
	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);

	
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);

	
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);

	
	/**
	 * 根据Id查询实体
	 * @param id
	 * @return
	 */
	T getById(Long id);
	
	/**
	 * 根据Id查询实体
	 * @param id
	 * @return
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * 查询所有实体
	 * @return
	 */
	List<T> findAll();
}
