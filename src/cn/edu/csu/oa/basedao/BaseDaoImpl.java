package cn.edu.csu.oa.basedao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	
	protected Class<T> clazz = null;
	
	public BaseDaoImpl(){
		
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>)pt.getActualTypeArguments()[0];
		
		System.out.println("----> clazz = " + clazz);
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T entity) {
		
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {

		if (id == null) {
			return;
		};
		
		Object entity = getById(id);
		if (entity != null) {
			getSession().delete(entity);
		}
	}

	@Override
	public void update(T entity) {

		getSession().update(entity);
	}

	@Override
	public T getById(Long id) {

		if (id == null) {
			return null;
		}else {
			return (T)getSession().get(clazz, id);
		}
		
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"From " + clazz.getSimpleName() + "WHERE id IN (:ids)")//
				.setParameter("ids", ids)
				.list();
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

	
}
