package cn.edu.csu.oa;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestString {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//测试SessionFactory
	
	@Test
	public void testSessionFactory() throws Exception {
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		System.out.println(sf.openSession());
	}
	
	//测试事务管理
	@Test
	public void testTx() throws Exception{
		TestService service = (TestService)ac.getBean("testService");
		service.saveTwoUsers();
	}
}
