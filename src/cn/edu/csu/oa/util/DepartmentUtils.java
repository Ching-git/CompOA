package cn.edu.csu.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.edu.csu.oa.domain.Department;

public class DepartmentUtils {

	/**
	 * 遍历部门树，把所有的部门都改掉名称后放到同一个List中返回，通过名称中的空格表示层次
	 * @param topList
	 * @param removedDepartment 这个部门和这个部门的子孙部门都要删除,如果为null表示没有要移除的部门
	 * @return
	 */
	public static List<Department> getAllDepartmentList(List<Department> topList, Department removeDepartment) {
		
		List<Department> list = new ArrayList<Department>();
		walkTree(topList,"|-",list,removeDepartment);
		return list;
	}

	//递归遍历
	private static void walkTree(Collection<Department> topList, String prefix,
			List<Department> list, Department removeDepartment) {
		for (Department top : topList) {
			//去掉分支
			if (removeDepartment != null && top.getId().equals(removeDepartment.getId())) {
				continue;
			}
			//顶点
			Department copy = new Department();//不要修改Session中的对象，使用副本解决
			copy.setId(top.getId());
			copy.setName(prefix + top.getName());
			list.add(copy);  //添加copy对象
			//子树
			walkTree(top.getChildren(), "　" + prefix, list,removeDepartment);  //不要英文使用空格
		}
	}

}
