package cn.edu.csu.oa.basedao;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import cn.edu.csu.oa.domain.Department;
import cn.edu.csu.oa.service.DepartmentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class BaseAcion<T> extends ActionSupport implements ModelDriven<T> {

	@Resource
	protected DepartmentService departmentService;

	protected T model;

	public BaseAcion() {
		try {
			// 通过反射获得T的真实类型
			ParameterizedType pType = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class<T>) pType.getActualTypeArguments()[0];
			// 通过反射创建model实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public T getModel() {
		return model;
	}
}