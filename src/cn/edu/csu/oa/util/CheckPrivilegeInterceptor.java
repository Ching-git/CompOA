package cn.edu.csu.oa.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		System.out.println("================> 拦截器（前）<================");
		String result = arg0.invoke();
		System.out.println("================> 拦截器（后）<================");
		return result;
	}

}
