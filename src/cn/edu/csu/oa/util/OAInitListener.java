package cn.edu.csu.oa.util;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.edu.csu.oa.domain.Privilege;
import cn.edu.csu.oa.service.PrivilegeService;

public class OAInitListener implements ServletContextListener {

	private Log log = LogFactory.getLog(OAInitListener.class);
	
	@Override
	//销毁
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	//初始化
	public void contextInitialized(ServletContextEvent arg0) {

		ServletContext application = arg0.getServletContext();
		
		//从Spring容器中取出PrivilegeService对象实例
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);//获取Spring的监听器中创建的Spring容器对象
		PrivilegeService privilegeService =  (PrivilegeService) ac.getBean("privilegeServiceImpl");
		
		//查询所有顶级权限列表并放到application作用域
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		application.setAttribute("topPrivilegeList", topPrivilegeList);
		log.info("====== topPrivilegeList已经发到application作用域了！！======");
		
		//查询所有权限的URL集合并放到application作用域
		List<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		application.setAttribute("allPrivilegeUrls", allPrivilegeUrls);
		log.info("====== allPrivilegeUrls已经发到application作用域了！！======");
	}
	
}
