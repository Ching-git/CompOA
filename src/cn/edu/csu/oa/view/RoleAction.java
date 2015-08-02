package cn.edu.csu.oa.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.csu.oa.base.BaseAction;
import cn.edu.csu.oa.domain.Privilege;
import cn.edu.csu.oa.domain.Role;
import cn.edu.csu.oa.service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings(value = { "all" })
@Controller
@Scope("prototype")

public class RoleAction extends BaseAction<Role>{


	private Long[] privilegeIds;
	
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String list() {
 
		// 准备数据
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		roleService.delete(model.getId());
		return "toList";
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public String add() {
		//封装对象
		//保存到数据库
		roleService.save(model);
		return "toList";
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 */
	public String addUI() {
		return "saveUI";
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String edit() {
		//1.从数据库中回去要修改的原始对象
		Role role = roleService.getById(model.getId());
		//2.设置要修改的属性
		role.setId(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		//3.更新数据库
		roleService.update(role);
		return "toList";
	}

	/**
	 * 修改页面
	 * 
	 * @return
	 */
	public String editUI() {
		//准备要回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	/**
	 *  设置权限
	 * @return
	 */
	public String setPrivilege() {
		//1.从数据库中获取要修改的原始对象
		Role role = roleService.getById(model.getId());
		
		//2.设置要修改的属性
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		
		//3.更新数据库
		roleService.update(role);
		return "toList";
	}

	/**
	 * 设置权限页面
	 * 
	 * @return
	 */
	public String setPrivilegeUI() {
		//准备数据
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		ActionContext .getContext().put("topPrivilegeList", topPrivilegeList);
		
		//准备要回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		privilegeIds = new Long[role.getPrivileges().size()];
		int index = 0;
		for (Privilege p : role.getPrivileges()) {
			privilegeIds[index++] = p.getId();
		}
		
		return "setPrivilegeUI";
	}

}
