package cn.edu.csu.oa.util;

import cn.edu.csu.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		// System.out.println("================> 拦截器（前）<================");
		// String result = arg0.invoke();
		// System.out.println("================> 拦截器（后）<================");
		// return result;

		// 准备数据
		// a,当前登录的用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		// b,当前访问的URL
		String namespace = arg0.getProxy().getNamespace();
		String actionName = arg0.getProxy().getActionName();
		if (null == namespace || "".equals(namespace)) {
			namespace = "/";
		}

		if (!namespace.endsWith("/")) {
			namespace += "/";
		}
		String url = namespace + actionName;

		// 1，如果用户未登录，就转到登录页面
		if (user == null) {
			if (url.startsWith("/loginout_login")) {// loginout_loginUI或loginout_login
				// a,如果访问的是登录功能，就放行
				return arg0.invoke();
			} else {
				// b,如果访问的不是登录功能，就转到登录页面
				return "loginUI";
			}
		}
		// 2，如果用户已登录，则判断权限
		else {
			if (user.hasPrivilegeByUrl(url)) {
				// a,如果有权限访问当前的URL，则放行
				return arg0.invoke();
			} else {
				// b,如果没有权限访问当前的URL，则转到提示消息的页面
				return "noPrivilegeUI";
			}
		}

	}
}
