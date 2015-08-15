package cn.edu.csu.oa.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.csu.oa.base.BaseAction;
import cn.edu.csu.oa.domain.Topic;

@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class TopicAction extends BaseAction<Topic> {

	/**
	 * 显示单个主题
	 * 
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception {
		return "show";
	}
	
	/**
	 * 发新帖页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		return "addUI";
	}
	
	/**
	 * 发新帖
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		return "toShow";	//转到当前这个新主题的显示页面
	}
	

}
