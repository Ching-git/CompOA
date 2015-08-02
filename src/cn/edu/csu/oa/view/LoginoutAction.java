package cn.edu.csu.oa.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.csu.oa.base.BaseAction;
import cn.edu.csu.oa.domain.User;

@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class LoginoutAction extends BaseAction<User>{

	/**
	 * 登录
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		//验证用户名和密码是否正确，不正确则返回null
		User user = userService.findByLoginNameAndPassword(model.getLoginName(),model.getPassword());
		
		//如果登录名或密码错误，就转回到登录界面并提示错误
		if (user == null) {
			addFieldError("login", "登录名或密码不正确！");
			return "loginUI";
		} 
		//如果登录名和密码正确，就登录
		else {
			ActionContext.getContext().getSession().put("user", user);
			return "toHome";
		}
		
	}
	
	/**
	 * 登录页面
	 * @return
	 * @throws Exception
	 */
	public String loginUI() throws Exception {
		return "loginUI";
	}
	
	/**
	 * 注销
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
	
}
