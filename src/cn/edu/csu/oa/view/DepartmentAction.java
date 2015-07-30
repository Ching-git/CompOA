package cn.edu.csu.oa.view;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.csu.oa.basedao.BaseAcion;
import cn.edu.csu.oa.domain.Department;
import cn.edu.csu.oa.service.DepartmentService;
import cn.edu.csu.oa.util.DepartmentUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class DepartmentAction extends BaseAcion<Department>{

	private Long parentId;

	/**
	 * 列表:列表只显示同级的部门数据，默认显示最顶级的
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<Department> departmentList = null;
		if (parentId == null) {
			// 默认显示顶级部门列表
			departmentList = departmentService.findTopList();
		} else {
			departmentList = departmentService.findChildren(parentId);
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}

		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		Department department = departmentService.getById(parentId);
		model.setParent(department);
		departmentService.save(model);
		return "toList";
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		// 准备数据（普通方式）
		// List<Department> departmentList = departmentService.findAll();
		// ActionContext.getContext().put("departmentList", departmentList);

		// 准备数据（树状结构）
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartmentList(topList,null);
		System.out.println(departmentList);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		// 1，从数据库中去除原始的数据
		Department department = departmentService.getById(model.getId());

		// 2,设置要修改的数据
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		// 处理上级部门
		Department parent = departmentService.getById(parentId);
		department.setParent(parent);

		// 3,更新到数据库
		departmentService.update(department);

		return "toList";
	}

	/**
	 * 修改页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception {
		// 准备回显的数据
		// System.out.println(model.getId());
		Department department = departmentService.getById(model.getId());//当前要修改的部门
		// System.out.println(department);
		ActionContext.getContext().getValueStack().push(department);

		if (department.getParent() != null) {
			this.parentId = department.getParent().getId();
		}

		// 准备上级部门数据
		// List<Department> departmentList = departmentService.findAll();
		// ActionContext.getContext().put("departmentList", departmentList);
		// 准备数据（树状结构）
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartmentList(topList,department);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
